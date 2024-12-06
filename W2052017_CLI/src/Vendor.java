public class Vendor implements Runnable{
    private TicketPool ticketPool;
    private int ticketReleaseRate;

    public Vendor(TicketPool ticketPool, int ticketReleaseRate){
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
