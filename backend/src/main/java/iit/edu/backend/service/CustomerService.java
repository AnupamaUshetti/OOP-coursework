package iit.edu.backend.service;

import iit.edu.backend.model.TicketPool;

public class CustomerService implements Runnable {

    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public CustomerService(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        while (true) {
            ticketPool.removeTickets(customerRetrievalRate);
            if (ticketPool.getCurrentCount() == 0) {
                System.out.println("All tickets sold out.(Customer thread stopping!)");
                break;
            }
            try {
                Thread.sleep(2500); // Simulate some delay in adding tickets
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
