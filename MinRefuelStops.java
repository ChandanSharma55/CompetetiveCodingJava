import java.util.*;

public class MinRefuelStops {

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		int far = startFuel;
		int count = 0, i = 0;
		while (far < target) {
			while (i < stations.length && stations[i][0] <= far) {
				pq.add(stations[i][1]);
				i++;
			}

			if (pq.isEmpty())
				return -1;
			far += pq.poll();
			count++;
		}

		return count;
	}

	public static void main(String args[]) {
		int target = 1000;
		int startFuel = 83;
		// int[][] stations = { { 25, 25 }, { 50, 100 }, { 100, 100 }, { 150, 40 }};
		// int[][] stations = { { 25, 30 }};
		int[][] stations = { { 47, 220 }, { 65, 1 }, { 98, 113 }, { 126, 196 }, { 186, 218 }, { 320, 205 },
				{ 686, 317 }, { 707, 325 }, { 754, 104 }, { 781, 105 } };

		System.out.print(minRefuelStops(target, startFuel, stations));
	}
}
