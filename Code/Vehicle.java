public abstract class Vehicle {

    // Name of the vehicle
    private String name;

    // Quantity of fuel available in the vehicle
    private double fuelQuantity;


    // Constructor to initialize the vehicle with a name and fuel quantity
    public Vehicle(String name, double fuelQuantity) {
        this.name = name;                   // Assign the vehicle name
        this.fuelQuantity = fuelQuantity;   // Set the initial fuel quantity
    }


    // Abstract method to compute the consumption factor based on road type
    public abstract double computeConsumptionFactor(Road road);


    // Method to simulate a race on a given road segment
    public double race(Road road, double fuelConsumed) {
        double speed = computeSpeed(road);            // Calculate the vehicle's speed
        double time = road.getKilometers() / speed;   // Calculate the time to complete the segment
        fuelQuantity -= fuelConsumed;                 // Deduct the consumed fuel
        return time;                                  // Return the time taken
    }


    // Method to refuel the vehicle by adding a fixed amount of fuel
    public void refuel() {
        // Add 10 units of fuel
        fuelQuantity += 10; 
    }

    
    // Override toString to provide a string representation of the vehicle
    public String toString() {
        return "\t" + name + " fuel left: " + fuelQuantity;
    }


    // Getter to retrieve the vehicle's name
    public String getName() {
        return name;
    }


    // Getter to retrieve the current fuel quantity
    public double getFuelQuantity() {
        return fuelQuantity;
    }


    // Setter to update the fuel quantity
    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }


    // Private helper method to compute the vehicle's speed on a given road
    private double computeSpeed(Road road) {
        // Get the consumption factor for the road
        double consumptionFactor = computeConsumptionFactor(road);    

        // Calculate the fuel consumption per kilometer
        double actualConsumptionPerKm = fuelQuantity / road.getKilometers(); 

        // Derive the speed from the consumption factor
        return actualConsumptionPerKm / consumptionFactor;            
    }
}
