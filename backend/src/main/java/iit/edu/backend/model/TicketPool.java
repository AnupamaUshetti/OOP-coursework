package iit.edu.backend.model;

public class TicketPool {
    private int ticketCount;
    private int maxTicketCapacity;
    private int currentCount;

    public TicketPool(int ticketCount, int maxTicketCapacity) {
        this.ticketCount = ticketCount;
        this.maxTicketCapacity = maxTicketCapacity;
        this.currentCount = 0;
    }

    public synchronized void addTickets(int ticketReleaseRate) {
        while (currentCount == maxTicketCapacity) {
            try {
                System.out.println("Ticket Pool is full. Vendor waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Vendor interrupted!");
                return;
            }
        }

        if (ticketCount == 0) {
            System.out.println("All vendor tickets are sold out. Vendor thread stopping.");
            return;
        }

        int newTickets = Math.min(ticketReleaseRate, Math.min(maxTicketCapacity - currentCount, ticketCount));
        currentCount += newTickets;
        ticketCount -= newTickets;

        System.out.println(newTickets + " tickets added to the pool.\n" +
                currentCount + " tickets in the pool.\n" +
                "Vendor remaining " + ticketCount + " more tickets.\n");
        notifyAll();
    }

    public synchronized void removeTickets(int customerRetrievalRate) {
        while (currentCount < customerRetrievalRate) {
            try {
                System.out.println("Not enough tickets available in the Ticket Pool. Customer waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer interrupted!");
                return;
            }
        }

        currentCount -= customerRetrievalRate;
        System.out.println(customerRetrievalRate + " tickets booked successfully. " + currentCount + " more tickets remaining in the Ticket Pool\n");

        if (currentCount == 0) {
            System.out.println("All tickets have been sold.");
        }

        notifyAll();
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getCurrentCount() {
        return currentCount;
    }
}