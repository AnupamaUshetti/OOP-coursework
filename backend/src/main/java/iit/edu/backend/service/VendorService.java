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
            synchronized (ticketPool) {
                // Pause if the ticket pool is full
                while (ticketPool.isFull()) {
                    try {
                        ticketPool.wait(); // Wait for customers to buy tickets
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return; // Exit the thread
                    }
                }

                // Add tickets to the pool
                ticketPool.addTickets(ticketReleaseRate);
                System.out.println("Tickets added: " + ticketReleaseRate);

                // Stop if all tickets have been added
                if (ticketPool.getRemainingTicketsToAdd() <= 0) {
                    System.out.println("All tickets added to the Ticket pool. (Vendor thread stopping!)");
                    return;
                }

                ticketPool.notifyAll(); // Notify waiting threads
            }

            try {
                Thread.sleep(1500); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
