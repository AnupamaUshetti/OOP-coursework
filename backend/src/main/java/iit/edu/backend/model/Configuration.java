package iit.edu.backend.model;

public class Configuration {

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration() {}

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        if (totalTickets <= 0) {
            throw new IllegalArgumentException("Total tickets must be greater than 0.");
        }
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters and Setters

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }
    // toString() for display
    @Override
    public String toString() {
        return "Configuration {" +
                "Total Tickets: " + totalTickets + ", " +
                "Ticket Release Rate: " + ticketReleaseRate + ", " +
                "Customer Retrieval Rate: " + customerRetrievalRate + ", " +
                "Max Ticket Capacity: " + maxTicketCapacity +
                "}";
    }
}
