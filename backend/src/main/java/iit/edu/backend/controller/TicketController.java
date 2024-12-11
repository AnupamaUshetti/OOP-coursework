package iit.edu.backend.controller;

import iit.edu.backend.model.Configuration;
import iit.edu.backend.model.TicketPool;
import iit.edu.backend.thread.Customer;
import iit.edu.backend.thread.Vendor;
import org.springframework.web.bind.annotation.*;
import iit.edu.backend.util.JsonUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/ws/tickets")
public class TicketController {
    private Configuration configuration;
    private TicketPool ticketPool;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private Thread vendorThread;
    private Thread customerThread;

    @PostMapping("/configure")
    public String configure(@RequestBody Configuration config) {
        this.configuration = config;
        this.ticketPool = new TicketPool(config.getTotalTickets(), config.getMaxTicketCapacity());
        JsonUtil.saveConfiguration(config);
        return "Configuration saved and system ready!";
    }

    @PostMapping("/start")
    public String start() {
        if (configuration == null || ticketPool == null) {
            return "System not configured!";
        }

        vendorThread = new Thread(new Vendor(ticketPool, configuration.getTicketReleaseRate()));
        customerThread = new Thread(new Customer(ticketPool, configuration.getCustomerRetrievalRate()));

        executorService.submit(vendorThread);
        executorService.submit(customerThread);
        return "Threads started!";
    }

    @PostMapping("/stop")
    public String stop() {
        if (vendorThread != null) vendorThread.interrupt();
        if (customerThread != null) customerThread.interrupt();
        return "Threads stopped!";
    }
}
