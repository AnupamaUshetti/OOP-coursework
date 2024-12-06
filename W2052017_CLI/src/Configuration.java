//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;


public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity){
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets(){
        return totalTickets;
    }
    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }
    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }
    public int getMaxTicketCapacity(){
        return maxTicketCapacity;
    }

    @Override
        public String toString(){
            return ("Configuration } "+ "Total Tickets: "+ totalTickets+
                    " Release rate: "+ticketReleaseRate+
                    " Retrieval rate: "+customerRetrievalRate+
                    " Maximum Capacity: " +maxTicketCapacity);
    }


}
