import java.util.Random;

public class DirtRoad extends Road {

    // Field to store the rain level for the dirt road
    private double rainLevel;


    // Constructor to initialize the dirt road with specified kilometers and turns
    public DirtRoad(int kilometers, boolean hasTurns) {
        // Call the parent constructor
        super(kilometers, hasTurns); 
        Random random = new Random();
        
        // Initialize the rain level with a random non-zero value between 0 and 1
        this.rainLevel = 0;
        while (true) {
            // Generate a random double in the range [0, 1)
            this.rainLevel = random.nextDouble(1); 
            if (this.rainLevel != 0) {
                // Ensure the rain level is non-zero
                break; 
            }
        }
    }


    // Method to update the consumption factor based on rain level and road conditions
    public double updateConsumptionFactor(double consumption) {
        // Apply the parent class's consumption factor adjustment
        consumption = super.updateConsumptionFactor(consumption);

        // Additional adjustment based on the rain level
        if (rainLevel >= 0.8 && rainLevel <= 1.0) {
            // Increase consumption by 20% for high rain levels
            consumption *= 1.2; 
        } else if (rainLevel >= 0.5 && rainLevel < 0.8) {
            // Increase consumption by 10% for moderate rain levels
            consumption *= 1.1; 
        }
        return consumption;
    }


    // Override toString to provide a string representation of the dirt road
    public String toString() {
        String roadType = "dirt Road";
        if (getHasTurns()) {
            // Indicate if the road has turns
            roadType += " with turns"; 
        }
        return "(" + getKilometers() + " klm of " + roadType + ")";
    }


    // Override getType to return the type identifier for a dirt road
    public int getType() {
        // Type 1 represents a dirt road
        return 1; 
    }
}
