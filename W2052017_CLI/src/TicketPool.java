public class TicketPool {
    private int ticketCount; //current count
    private int maximumCapacity; //max capacity
    private int totalTickets; //maximum ticket count

    public TicketPool(int ticketCount, int maximumCapacity, int totalTicket){
        this.ticketCount = ticketCount;
        this.maximumCapacity = maximumCapacity;
        this.totalTickets = totalTicket;
    }

    public synchronized void addTickets(int addCount){
        if (totalTickets < ticketCount)
            if (ticketCount + addCount < maximumCapacity){
            ticketCount += addCount;
            System.out.println( addCount + " tickets added. Total tickets: " + ticketCount);
            }
            else{
                System.out.println("Reached maximum capacity. Cannot add tickets.");
        }
    }

    public synchronized void removeTicket(){
        if (ticketCount > 0){
            ticketCount--;
            System.out.println("Ticket Booked. "+ ticketCount +" tickets remaining." );
        }
        else{
            System.out.println("No more available tickets in the pool.");
        }
    }



}
