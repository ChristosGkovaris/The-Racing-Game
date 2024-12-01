import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RaceParticipants {

    // Human racer controlled by the user
    private HumanRacer userRacer;

    // List of computer-controlled racers
    private List<Racer> computerRacers;


    // Constructor to initialize race participants
    public RaceParticipants() {
        // Create computer-controlled racers
        createComputerRacers(); 

        // Allow user to select their vehicle
        chooseUserVehicle();    
    }


    // Method to create and initialize computer-controlled racers
    private void createComputerRacers() {
        computerRacers = new ArrayList<>();

        // Add a motorbike racer controlled by the computer
        Vehicle motorbike = new Motorbike();
        Racer motorbikeRacer = new Racer("Computer 1", motorbike);
        computerRacers.add(motorbikeRacer);

        // Add a car racer controlled by the computer
        Vehicle car = new Car();
        Racer carRacer = new Racer("Computer 2", car);
        computerRacers.add(carRacer);

        // Add a jeep racer controlled by the computer
        Vehicle jeep = new Jeep();
        Racer jeepRacer = new Racer("Computer 3", jeep);
        computerRacers.add(jeepRacer);
    }


    // Method to let the user select their vehicle
    private void chooseUserVehicle() {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in); 

        try {
            System.out.println("What kind of vehicle do you want? (1: Motorbike, 2: Car, 3: Jeep)");

            // Read the user's choice
            int choice = scanner.nextInt(); 
            Vehicle userVehicle;

            // Assign the user's vehicle based on their choice
            switch (choice) {
                case 1:
                    userVehicle = new Motorbike();
                    break;
                case 2:
                    userVehicle = new Car();
                    break;
                case 3:
                    userVehicle = new Jeep();
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Motorbike.");
                    userVehicle = new Motorbike();
                    break;
            }

            // Create the user racer with the chosen vehicle
            userRacer = new HumanRacer("Human", userVehicle);
        } finally {
            // Ensure the scanner is closed to release resources
            scanner.close(); 
        }
    }


    // Method to make all vehicles run a segment of the track
    public void runVehicles(Road segment) {
        // User racer runs the segment
        userRacer.race(segment); 
        
        for (Racer computerRacer : computerRacers) {
            // Each computer racer runs the segment
            computerRacer.race(segment); 
        }
    }


    // Method to refuel all vehicles
    public void refuelVehicles() {
        // Refuel the user's vehicle
        userRacer.refuel(); 
        
        for (Racer computerRacer : computerRacers) {
            // Refuel each computer-controlled vehicle
            computerRacer.refuel(); 
        }
    }


    // Method to print all racers ordered by their total time
    public void printVehiclesOrderByTime() {
        // Combine user and computer racers into a single list
        List<Racer> allRacers = new ArrayList<>(computerRacers);
        allRacers.add(userRacer);

        // Sort racers by their total time
        Collections.sort(allRacers, Comparator.comparingDouble(Racer::getTotalTime));

        // Print the sorted racers
        for (Racer racer : allRacers) {
            System.out.println(racer.toString());
        }
    }


    // Method to determine the winner of the race
    public Racer getWinner() {
        // Combine user and computer racers into a single list
        List<Racer> allRacers = new ArrayList<>(computerRacers);
        allRacers.add(userRacer);

        // Sort racers by their total time
        Collections.sort(allRacers, Comparator.comparingDouble(Racer::getTotalTime));

        // Return the racer with the best (lowest) time
        return allRacers.get(0);
    }
}
