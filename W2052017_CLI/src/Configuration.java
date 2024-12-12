//Configuration class
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
                    ", Release rate: "+ticketReleaseRate+
                    ", Retrieval rate: "+customerRetrievalRate+
                    ", Maximum Capacity: " +maxTicketCapacity);
    }

    // Save configuration to JSON file
    public void saveToJsonFile(String jsonFileName, boolean createNew) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(jsonFileName);

        try {
            if (createNew || !file.exists()) {
                // Write a new JSON file
                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(Collections.singletonList(this), writer); // Write as a new array
                }
                System.out.println("Configuration saved to a new JSON file: " + jsonFileName);
            } else {
                // Append to existing JSON file
                List<Configuration> configurations;
                if (file.length() == 0) {
                    // If the file is empty, start with an empty list
                    configurations = new ArrayList<>();
                } else {
                    try (FileReader reader = new FileReader(file)) {
                        JsonElement element = JsonParser.parseReader(reader);
                        if (element.isJsonArray()) {
                            configurations = gson.fromJson(element, new TypeToken<List<Configuration>>() {}.getType());
                        } else if (element.isJsonObject()) {
                            Configuration singleConfig = gson.fromJson(element, Configuration.class);
                            configurations = new ArrayList<>();
                            configurations.add(singleConfig);
                        } else {
                            throw new JsonSyntaxException("Invalid JSON format");
                        }
                    }
                }

                configurations.add(this); // Add the new configuration
                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(configurations, writer);
                }
                System.out.println("Configuration appended to existing JSON file: " + jsonFileName);
            }
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Error saving to JSON file: " + e.getMessage());
        }
    }

    // Append configuration to text file
    public void saveToTextFile(String textFileName) {
        try (FileWriter writer = new FileWriter(textFileName, true)) {
            writer.write(this.toString() + "\n");
            System.out.println("Configuration appended to text file: " + textFileName);
        } catch (IOException e) {
            System.out.println("Error saving to text file: " + e.getMessage());
        }
    }


}
