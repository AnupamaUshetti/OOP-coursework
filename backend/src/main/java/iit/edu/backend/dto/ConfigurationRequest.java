package iit.edu.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class ConfigurationRequest {

    @NotNull(message = "Total tickets cannot be null.")
    @Min(value = 1, message = "Total tickets must be greater than 0.")
    private Integer totalTickets;

    @NotNull(message = "Ticket release rate cannot be null.")
    @Min(value = 1, message = "Ticket release rate must be greater than 0.")
    private Integer ticketReleaseRate;

    @NotNull(message = "Customer retrieval rate cannot be null.")
    @Min(value = 1, message = "Customer retrieval rate must be greater than 0.")
    private Integer customerRetrievalRate;


    @NotNull(message = "Max ticket capacity cannot be null.")
    @Min(value = 1, message = "Max ticket capacity must be greater than 0.")
    private Integer maxTicketCapacity;

    // Default constructor
    public ConfigurationRequest() {}

    // Parameterized constructor
    public ConfigurationRequest(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters and Setters
    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // toString() for easy display
    @Override
    public String toString() {
        return "ConfigurationRequest{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
