public class Car extends Vehicle {

    // Array to hold the consumption factors for different road types
    private double[] consumptionFactors = {0.1, 0.35, 0.45};


    // Constructor to initialize the car with default values
    public Car() {
        // Call the parent constructor with the vehicle name and initial fuel quantity
        super("Car", 0); 
        
        // Set the default fuel quantity to 100
        this.setFuelQuantity(100); 
    }

    
    // Method to compute the fuel consumption factor based on the road type
    public double computeConsumptionFactor(Road road) {
        // Get the base consumption factor for the given road type
        double consumptionFactor = consumptionFactors[road.getType()];
        
        // Update the consumption factor based on the road conditions
        return road.updateConsumptionFactor(consumptionFactor);
    }
}