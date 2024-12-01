import java.util.Random;

public class RockyRoad extends Road {

    // Field to store the difficulty level of the rocky road (0 to 2)
    private int roadDifficulty;


    // Constructor to initialize the rocky road segment
    public RockyRoad(int kilometers, boolean hasTurns) {
        // Call the parent constructor to set length and turns
        super(kilometers, hasTurns); 
        Random random = new Random();

        // Randomly assign a difficulty level (0, 1, or 2)
        this.roadDifficulty = random.nextInt(3);
    }


    // Method to update the consumption factor based on road difficulty and conditions
    public double updateConsumptionFactor(double consumption) {
        // Apply the parent class's consumption factor adjustment
        consumption = super.updateConsumptionFactor(consumption);

        // Further adjust consumption based on the road's difficulty
        if (roadDifficulty == 2) {
            // Increase consumption by 20% for high difficulty
            consumption *= 1.2; 
        } else if (roadDifficulty == 1) {
            // Increase consumption by 10% for medium difficulty
            consumption *= 1.1; 
        }
        return consumption;
    }


    // Override toString to provide a string representation of the rocky road
    public String toString() {
        // Default type is rocky road
        String roadType = "rocky Road"; 
        
        if (getHasTurns()) {
            // Indicate if the road has turns
            roadType += " with Turns"; 
        }
        return "(" + getKilometers() + " klm of " + roadType + ")";
    }


    // Override getType to return the type identifier for rocky roads
    public int getType() {
        // Type 2 represents a rocky road
        return 2; 
    }
}
