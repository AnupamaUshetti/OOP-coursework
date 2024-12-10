import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Configuration configure;

        while (true) {
            try {
                // User inputs for configuration
                System.out.print("Enter total ticket count (must be over '0'): ");
                int totalTickets = scanner.nextInt();
                if (totalTickets <= 0) throw new IllegalArgumentException("Total ticket count must be greater than 0.");

                System.out.print("Enter ticket release rate: ");
                int ticketReleaseRate = scanner.nextInt();
                if (ticketReleaseRate <= 0) throw new IllegalArgumentException("Ticket release rate must be greater than 0.");

                System.out.print("Enter customer retrieval rate: ");
                int customerRetrievalRate = scanner.nextInt();
                if (customerRetrievalRate <= 0) throw new IllegalArgumentException("Customer retrieval rate must be greater than 0.");

                System.out.print("Enter maximum ticket capacity: ");
                int maxTicketCapacity = scanner.nextInt();
                if (maxTicketCapacity <= 0) throw new IllegalArgumentException("Maximum ticket capacity must be greater than 0.");

                configure = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
                break;

                } catch (Exception e) {
                System.out.println("Error: Please enter a valid input. " + (e.getMessage() != null ? e.getMessage() : ""));
                scanner.nextLine(); // Clear invalid input
                }

            System.out.println("Try Again!");
        }


        // Save configuration to files
        String textFileName = "configurations.txt";
        configure.saveToTextFile(textFileName);

        System.out.println("Do you want to save the configuration in a new JSON file?");
        System.out.println("Type 'yes' to create a new JSON file or 'no' to append data to the existing JSON file.");
        String jsonChoice = scanner.next();

        String jsonFileName = "configurations.json";
        boolean createNew = "yes".equalsIgnoreCase(jsonChoice);

        configure.saveToJsonFile(jsonFileName, createNew);

        System.out.println("Program completed successfully.");


        System.out.println(configure); // Print the configuration

        // Create shared TicketPool
        TicketPool ticketPool = new TicketPool(configure.getTotalTickets(), configure.getMaxTicketCapacity());

        // Create and start vendor thread
        Thread vendorThread = new Thread(new Vendor(ticketPool, configure.getTicketReleaseRate()));
        vendorThread.start();

        // Create and start customer thread
        Thread customerThread = new Thread(new Customer(ticketPool,configure.getCustomerRetrievalRate()));
        customerThread.start();

        // Exit logic
        System.out.println("Type 'Q' to stop the program. \n");
        while (true) {
            String command = scanner.next();
            if ("Q".equalsIgnoreCase(command)) {

                vendorThread.interrupt(); // Stop vendor thread
                customerThread.interrupt(); // Stop customer thread
                break;
            }
        }

        System.out.println("Program Stopped.");
    }
}