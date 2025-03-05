# The Racing Game
Welcome to the "The Racing Game" repository. This repository contains a competitive simulation where players and computer-controlled racers compete on a dynamic track using different vehicle types, each with unique characteristics. This project was implemented during the second semester, in the course MYY205 of the curriculum of the University of Ioannina. The final grade of the project is 110 out of 100.



## Instructions
- Objective: Be the first racer to complete the track with the shortest total time.
- How to Play: The race takes place on a track composed of multiple segments, each with a different road type (paved road, dirt road, or rocky road). Players can
  choose between three vehicle types: **Motorbike**, **Car**, or **Jeep**, each with unique fuel consumption factors based on the road type. Each segment of the
  track has specific conditions, such as turns, rain levels, or rocky terrain difficulty, affecting fuel consumption and speed. Players decide how much fuel to
  use for each segment of the track, while computer racers automatically use all available fuel. Vehicles are refueled after each segment. The game ends when
  all segments are completed, and the racer with the shortest total time wins.
- Scoring: The winner is determined by the total time taken to complete all segments of the track.



## Implementation Details
- The game is implemented in Java, following object-oriented principles.
- Key Classes: **`Vehicle`**: Abstract base class for all vehicle types, managing fuel and race behavior. **`Motorbike`**, **`Car`**, **`Jeep`**: Concrete
  implementations of `Vehicle`, each with unique fuel consumption factors. **`Road`**: Base class representing a road segment, with subclasses **`DirtRoad`**
  and **`RockyRoad`** adding specific conditions like rain and rocky difficulty. **`RaceTrack`**: Manages the sequence of road segments and the current progress
  of the race. **`Racer`**: Tracks individual racers, including their vehicle and total time. **`HumanRacer`**: Subclass of `Racer` controlled by the player,
  allowing fuel input for each segment. **`RaceParticipants`**: Manages the racers, their refueling, and their positions in the race. **`RacingGame`**: Serves as
  the entry point for the program, running the main race loop and determining the winner.
