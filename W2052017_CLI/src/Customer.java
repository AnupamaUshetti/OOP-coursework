//Customer class that holding customer threads
public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int customerRetrievalRate;

    public Customer (TicketPool ticketPool, int customerRetrievalRate){
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }


    @Override
    public void run() {
        while (true) {
            ticketPool.removeTickets(customerRetrievalRate);
            //stopping customer threads
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

