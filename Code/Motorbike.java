public class Motorbike extends Vehicle {

    // Array to hold the consumption factors for different road types
    private double[] consumptionFactors = {0.05, 0.4, 0.5};


    // Constructor to initialize the Motorbike with default values
    public Motorbike() {
        // Call the parent constructor with the vehicle name and initial fuel quantity
        super("Motorbike", 0); 
    }


    // Method to compute the fuel consumption factor based on the road type
    public double computeConsumptionFactor(Road road) {
        // Get the base consumption factor for the given road type
        double consumptionFactor = consumptionFactors[road.getType()];
        
        // Update the consumption factor based on the road conditions
        return road.updateConsumptionFactor(consumptionFactor);
    }
}
