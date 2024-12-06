package iit.edu.backend.service;

import iit.edu.backend.model.Configuration;
import iit.edu.backend.model.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketPool ticketPool;
    private Thread vendorThread;
    private Thread customerThread;

    public TicketService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public void configure(Configuration config) {
        ticketPool.initialize(config.getTotalTickets(), config.getMaxTicketCapacity());
    }

    public void startVendor(int ticketReleaseRate) {
        vendorThread = new Thread(new VendorService(ticketPool, ticketReleaseRate));
        vendorThread.start();
    }

    public void startCustomer(int customerRetrievalRate) {
        customerThread = new Thread(new CustomerService(ticketPool, customerRetrievalRate));
        customerThread.start();
    }

    public void stopThreads() {
        if (vendorThread != null) vendorThread.interrupt();
        if (customerThread != null) customerThread.interrupt();
    }
}
