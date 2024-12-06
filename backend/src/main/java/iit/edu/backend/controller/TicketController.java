package iit.edu.backend.controller;

import iit.edu.backend.configuration.JsonConfig;
import iit.edu.backend.dto.ConfigurationRequest;
import iit.edu.backend.model.Configuration;
import iit.edu.backend.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final JsonConfig jsonConfig;

    public TicketController(TicketService ticketService, JsonConfig jsonConfig) {
        this.ticketService = ticketService;
        this.jsonConfig = jsonConfig;
    }

    @PostMapping("/configure")
    public String configure(@RequestBody ConfigurationRequest request) throws Exception {
        Configuration config = new Configuration(
                request.getTotalTickets(),
                request.getTicketReleaseRate(),
                request.getCustomerRetrievalRate(),
                request.getMaxTicketCapacity()
        );
        jsonConfig.saveConfiguration(config);
        ticketService.configure(config);
        return "Configuration saved successfully!";
    }

    @PostMapping("/start")
    public String start() {
        try {
            Configuration config = jsonConfig.loadConfiguration();
            ticketService.startVendor(config.getTicketReleaseRate());
            ticketService.startCustomer(config.getCustomerRetrievalRate());
            return "Vendor and Customer threads started.";
        } catch (Exception e) {
            return "Error loading configuration: " + e.getMessage();
        }
    }


    @PostMapping("/stop")
    public String stop() {
        ticketService.stopThreads();
        return "Threads stopped.";
    }
}
