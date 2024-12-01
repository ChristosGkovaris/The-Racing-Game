import java.util.Random;

public class RaceTrack {

    // Array to store the road segments of the track
    private Road[] segments;

    // Index of the current segment being raced
    private int currentIndex;

    // Size of the race track
    private int size;

    
    // Constructor to initialize the race track with a given number of segments
    public RaceTrack(int size) {
        // Initialize the array to hold road segments
        segments = new Road[size]; 
        
        Random random = new Random();

        // Default size initialization
        this.size = 50; 

        // Ensure a valid size for the track
        while (true) {
            // Randomly generate a size between 0 and 100
            this.size = random.nextInt(100); 
            if (this.size != 0) {
                // Ensure the size is non-zero
                break; 
            }
        }

        // Populate the track with road segments
        for (int i = 0; i < size; i++) {
            // Randomly select a road type (0, 1, or 2)
            int roadType = random.nextInt(3); 

            // Randomly generate length between 50 and 100 km
            int kilometers = random.nextInt(51) + 50; 

            if (roadType == 0) {
                // Randomly decide if the road has turns
                boolean hasTurns = random.nextBoolean(); 
                // Create a paved road
                segments[i] = new Road(kilometers, hasTurns); 
            } else if (roadType == 1) {
                // Create a dirt road
                segments[i] = new DirtRoad(kilometers, random.nextBoolean()); 
            } else {
                // Create a rocky road
                segments[i] = new RockyRoad(kilometers, random.nextBoolean()); 
            }
        }
        // Initialize the starting index
        currentIndex = 0; 
    }


    // Method to get the next segment of the track
    public Road nextSegment() {
        if (currentIndex >= segments.length) {
            // Print the first segment if no more are left
            System.out.println(segments[0]); 
            return null;
        }

        // Get the current segment
        Road nextSegment = segments[currentIndex]; 

        // Move to the next segment
        currentIndex++; 
        return nextSegment;
    }


    // Method to check if the race has reached the end of the track
    public boolean reachedEnd() {
        // Return true if all segments are raced
        return currentIndex >= segments.length; 
    }


    // Method to print the remaining segments of the track
    public void printRemainingTrack() {
        if (currentIndex >= segments.length) {
            System.out.println("Next Segment: ");
            System.out.println(nextSegment());
        }

        // Print all remaining segments from the current index
        for (int i = currentIndex; i < segments.length; i++) {
            System.out.println(segments[i]);
        }
    }


    // Main method to demonstrate the functionality of RaceTrack
    public static void main(String[] args) {
        // Create a track with 10 segments
        RaceTrack raceTrack = new RaceTrack(10); 
        for (int i = 0; i < 10; i++) {
            // Get each segment in sequence
            Road segment = raceTrack.nextSegment(); 
            // Print the segment details
            System.out.println(segment); 
        }

        // Print the remaining track segments
        raceTrack.printRemainingTrack(); 
    }
}
