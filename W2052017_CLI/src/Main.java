import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Configuration configure;

        while (true){
            try{
                //user inputs for configuration
                System.out.println("Enter total ticket count (must be over '0'): ");
                int totalTickets = scanner.nextInt();

                System.out.println("Enter ticket release rate: ");
                int ticketReleaseRate = scanner.nextInt();

                System.out.println("Enter customer retrieval rate: ");
                int customerRetrievalRate = scanner.nextInt();

                System.out.print("Enter maximum ticket capacity: ");
                int maxTicketCapacity = scanner.nextInt();

                configure = new Configuration(totalTickets,ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
                break;

            }catch(IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
                System.out.println("Try Again!");
            }

        }

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