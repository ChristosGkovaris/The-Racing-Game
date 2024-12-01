public class Jeep extends Vehicle {

    // Array to hold the consumption factors for different road types
    private double[] consumptionFactors = {0.25, 0.3, 0.35};


    // Constructor to initialize the Jeep with default values
    public Jeep() {
        // Call the parent constructor with the vehicle name and initial fuel quantity
        super("Jeep", 0); 
    }


    // Method to compute the fuel consumption factor based on the road type
    public double computeConsumptionFactor(Road road) {
        // Get the base consumption factor for the given road type
        double consumptionFactor = consumptionFactors[road.getType()];
        
        // Update the consumption factor based on the road conditions
        return road.updateConsumptionFactor(consumptionFactor);
    }
}
