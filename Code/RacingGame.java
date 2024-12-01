public class RacingGame {

    public static void main(String[] args) {
        // Initialize a race track with 10 segments
        RaceTrack raceTrack = new RaceTrack(10);
        
        // Initialize race participants (human and computer racers)
        RaceParticipants raceParticipants = new RaceParticipants();

        // Main race loop: Continue while the race track has remaining segments
        while (!raceTrack.reachedEnd()) {
            // Print the remaining segments of the race track
            raceTrack.printRemainingTrack();

            // Refuel all vehicles before the next segment
            raceParticipants.refuelVehicles();

            // Get the next segment of the track
            Road nextSegment = raceTrack.nextSegment();

            // Print the racers sorted by their total time
            raceParticipants.printVehiclesOrderByTime();

            // Run the vehicles on the next segment of the track
            raceParticipants.runVehicles(nextSegment);
        }

        // Determine the winner of the race
        Racer winner = raceParticipants.getWinner();

        // Print the name and total time of the winner
        System.out.println("Winner: " + winner.getName() + " (" + winner.getTotalTime() + ")");
    }
}
