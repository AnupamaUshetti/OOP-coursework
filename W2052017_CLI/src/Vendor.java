public class Vendor implements Runnable{
    private TicketPool ticketpool;
    private int ticketReleaseRate;
    //private int totalTickets;

    public Vendor(TicketPool ticketpool, int ticketReleaseRate, int totalTickets){
        this.ticketpool = ticketpool;
        this.ticketReleaseRate = ticketReleaseRate;
        //this.totalTickets = totalTickets;

    }


    @Override
    public void run(){
        for (int i = 1; i<totalTickets; i++){
            Ticket ticket =
        }

    }

}
