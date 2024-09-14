FIRST YEAR PROJECT
Classes Overview:
1. ParkingLot Class
* Manages the parking lot operations.

2. LinkedQueue Class
* Manages the queue for cars waiting to park.

3. Simulator Class
* Runs the parking lot simulation for each parking lot size.
* Uses the peek() and size() methods to manage car arrivals and departures based on the hourly arrival rate and pdf.
4. CapacityOptimizer Class
* Determines the optimal parking lot size by running multiple simulations and tracking the queue length.
* Outputs the optimal number of spots once the average queue length is ≤ 5 across 10 simulations.

Exception Handling:
The program includes error handling for invalid inputs and simulation errors to ensure smooth execution.

Algorithm:
1. The system takes the hourly car arrival rate as input when running the CapacityOptimizer class:

java CapacityOptimizer <hourly rate>

2. The CapacityOptimizer runs a loop, simulating parking lot operations for increasing numbers of parking spots (n).
3. For each n spots, the ParkingLot instance is created, and the Simulator generates random car arrival times based on the hourly rate.
4. The simulator checks if cars can park or need to queue, tracks the duration of each parked car, and removes them when necessary.
5. After each simulation, the queue length is evaluated. If the average queue length across 10 simulations is ≤ 5, the optimal number of parking spots is printed.

