package iit.edu.backend.thread;

import iit.edu.backend.model.TicketPool;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.removeTickets(customerRetrievalRate);
            try {
                Thread.sleep(1000); // Simulate delay in ticket buying
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Customer thread exiting.");
    }
}
