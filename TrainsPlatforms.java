import java.util.*;

public class TrainsPlatforms {
	static class Train {

		public int arrival, departure;

		public Train(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}
	}
	/*
	 * This is the Train class definition class Train { public int arrival,
	 * departure; public Train(int arrival, int departure) { this.arrival = arrival;
	 * this.departure = departure; } }
	 */

	static int minPlatforms(Train[] trains) {
		// add your logic here
		List<Integer> arrival = new ArrayList<>();
		List<Integer> departure = new ArrayList<>();

		for (Train value : trains) {
			arrival.add(value.arrival);
			departure.add(value.departure);
		}
		Collections.sort(arrival);
		Collections.sort(departure);

		int i = 0, j = 0;
		int result = 0;
		int max = 0;
		while (i < trains.length && j < trains.length) {
			if (arrival.get(i) <= departure.get(j)) {
				result++;
				i++;
			} else {
				result--;
				j++;
			}
			max = Math.max(max, result);

		}

		return max;
	}

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Train[] trains = new Train[4];
		for(int i=0;i<4;i++)
		{
			trains[i] = new Train(sc.nextInt(),sc.nextInt());
		}
		System.out.print(minPlatforms(trains));
	}
}
