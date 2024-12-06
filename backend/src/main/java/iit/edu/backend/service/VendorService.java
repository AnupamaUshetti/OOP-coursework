package iit.edu.backend.service;

import iit.edu.backend.model.TicketPool;

public class VendorService implements Runnable {

    private final TicketPool ticketPool;
    private final int ticketReleaseRate;

    public VendorService(TicketPool ticketPool, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        while (true) {
            ticketPool.addTickets(ticketReleaseRate);

            // Stop the vendor thread if all tickets are sold
            if (ticketPool.getTicketCount() == 0) {
                System.out.println("All tickets added to the Ticket pool.(Vendor thread stopping!)");
                break;
            }

            try {
                Thread.sleep(1500); // Simulate some delay in adding tickets
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
