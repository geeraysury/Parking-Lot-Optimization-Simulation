public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		int n = 1; 
		
		int steps = 24 * 3600;
		
		
		while (true) {
			int totalAverage = 0;
			int average = 0;

			if (n == 1){
				System.out.println("==== Setting lot capacity to: " + n + "====");
			}

			for (int i = 1; i <= NUM_RUNS; i++){
				long startTime = System.currentTimeMillis();


				Simulator simulateLot = new Simulator(new ParkingLot(n), hourlyRate, steps);
				
				simulateLot.simulate(); 
				totalAverage += simulateLot.getIncomingQueueSize();
				long endTime = System.currentTimeMillis();
				System.out.println("Simulation run " + i + " (" + (endTime - startTime) + "ms); Queue length at the end of simulation run: " + simulateLot.getIncomingQueueSize());
			}
			average = totalAverage / NUM_RUNS;
			
			if (average <= THRESHOLD){
				return n;
			}

			else{
				n++;
				System.out.println("");
				System.out.println("==== Setting lot capacity to: " + n + "====");
			}
		}	
	}

	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}