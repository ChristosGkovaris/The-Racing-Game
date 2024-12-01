import java.util.Random;

public class Road {

    // Length of the road segment in kilometers
    private int kilometers;

    // Indicates if the road segment has turns
    private boolean hasTurns;

    // String representation of the road type
    private String roadType;


    // Constructor to initialize the road segment
    public Road(int kilometers, boolean hasTurns) {
		// Set the length of the road
        this.kilometers = kilometers; 
        Random random = new Random();
        
        // Randomly determine if the road has turns
        this.hasTurns = random.nextBoolean();
    }


    // Method to update the consumption factor based on road conditions
    public double updateConsumptionFactor(double consumption) {
        if (hasTurns) {
			// Increase consumption by 10% if the road has turns
            consumption *= 1.1; 
        }
        return consumption;
    }


    // Override toString to provide a string representation of the road
    public String toString() {
		// Default to a paved road
        roadType = "paved road"; 
        
		if (hasTurns) {
			// Add details if the road has turns
            roadType += " with turns"; 
        }
        return "(" + kilometers + " klm of " + roadType + ")";
    }


    // Getter to check if the road has turns
    public boolean getHasTurns() {
        return hasTurns;
    }


    // Setter to modify the road's turn property
    public void setHasTurns(boolean hasTurns) {
        this.hasTurns = hasTurns;
    }


    // Method to get the type of the road
    // Type 0 represents a paved road
    public int getType() {
        return 0;
    }


    // Getter to retrieve the length of the road
    public int getKilometers() {
        return kilometers;
    }


    // Setter to modify the length of the road
    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }
}
