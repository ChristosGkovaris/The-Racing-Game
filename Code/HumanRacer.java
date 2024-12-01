import java.util.Scanner;

public class HumanRacer extends Racer {

    // Scanner to handle user input for fuel usage
    private Scanner scanner;


    // Constructor to initialize the human racer with a name and vehicle
    public HumanRacer(String name, Vehicle vehicle) {
        // Call the parent constructor
        super(name, vehicle); 

        // Initialize the scanner for user input
        scanner = new Scanner(System.in); 
    }


    // Method to get the amount of fuel the human racer wants to use
    public double getFuel() {
        // Prompt the user
        System.out.println("How much fuel do you want to use? ");
        
        // Read the fuel amount
        double fuel = scanner.nextDouble(); 

        // Consume the newline character to avoid input issues
        scanner.nextLine(); 

        // Return the user's fuel choice
        return fuel; 
    }
}
