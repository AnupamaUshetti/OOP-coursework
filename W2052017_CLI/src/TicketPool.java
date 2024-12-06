public class TicketPool {
    private int ticketCount; //max tickets that vendor have
    private int maxTicketCapacity; //max capacity
    private int currentCount; //current tickets amount ticket pool have


    public TicketPool(int ticketCount, int maximumCapacity){
        this.currentCount = 0;
        this.ticketCount = ticketCount;
        this.maxTicketCapacity = maximumCapacity;
    }

    public synchronized int getCurrentCount() {
        return currentCount;
    }

    public synchronized int getTicketCount(){
        return ticketCount;
    }


    public synchronized void addTickets(int ticketReleaseRate){
        while(currentCount==maxTicketCapacity){
            try{
                System.out.println("Ticket Pool is full. Vendor waiting...");
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Vendor interrupted!");
                return;
            }
        }

        // Stop vendor thread if no tickets left to release
        if (ticketCount == 0) {
            System.out.println("All vendor tickets are sold out. Vendor thread stopping.");
            return;
        }

        int newTickets;
        if (ticketReleaseRate <= (maxTicketCapacity-currentCount) && ticketReleaseRate <= ticketCount){
            newTickets = ticketReleaseRate;
        }
        else if((maxTicketCapacity - currentCount) <= ticketReleaseRate && (maxTicketCapacity - currentCount) <= ticketCount){
            newTickets = maxTicketCapacity - currentCount;
        }
        else {
            newTickets = ticketCount;
        }
        currentCount += newTickets;
        ticketCount-= newTickets;

        System.out.println(newTickets + " tickets added to the pool. \n" +
                currentCount + " tickets in the pool. \n"+
                "Vendor remaining "+ ticketCount + " more tickets. \n");
        notifyAll(); //notify customers
    }


    public synchronized void removeTickets(int customerRetrievalRate) {
        while (currentCount < customerRetrievalRate) {
            try {
                System.out.println("Not enough tickets available in the Ticket Pool. Customer waiting...");
                wait(); // Wait until enough tickets are available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer interrupted!");
                return;
            }
        }

        // Reduce tickets based on input
        currentCount -= customerRetrievalRate;

        System.out.println(customerRetrievalRate + " tickets booked successfully. " + currentCount + " more tickets remaining in the Ticket Pool \n");

        if (currentCount == 0) {
            System.out.println("All tickets have been sold.");
            return; // Exit when no tickets are left
        }

        notifyAll(); // Notify any waiting vendors
    }

}
