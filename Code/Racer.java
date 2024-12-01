public class Racer {

    // Name of the racer
    private String name;

    // Vehicle assigned to the racer
    private Vehicle vehicle;

    // Total time the racer has taken in the race
    private double totalTime;


    // Constructor to initialize the racer's name, vehicle, and starting time
    public Racer(String name, Vehicle vehicle) {
        this.name = name;         // Assign the racer's name
        this.vehicle = vehicle;   // Assign the racer's vehicle
        this.totalTime = 0;       // Initialize the total time to zero
    }


    // Method to get the available fuel quantity of the racer's vehicle
    public double getFuel() {
        // Retrieve fuel quantity from the vehicle
        return vehicle.getFuelQuantity(); 
    }


    // Method to simulate the racer running a segment of the road
    public void race(Road road) {
        double fuel = getFuel();                 // Get the current fuel quantity
        double time = vehicle.race(road, fuel);  // Calculate the time taken for this segment
        totalTime += time;                       // Add the segment time to the total time
    }


    // Method to refuel the racer's vehicle
    public void refuel() {
        // Call the vehicle's refuel method
        vehicle.refuel(); 
    }


    // Override toString to provide a string representation of the racer
    public String toString() {
        return name + " (" + totalTime + ")" + "\n" + vehicle.toString();
    }


    // Getter for the racer's name
    public String getName() {
        return name;
    }


    // Getter for the racer's total time
    public double getTotalTime() {
        return totalTime;
    }


    // Setter to update the racer's total time
    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }


    // Getter for the racer's vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }


    // Setter to assign a new vehicle to the racer
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
