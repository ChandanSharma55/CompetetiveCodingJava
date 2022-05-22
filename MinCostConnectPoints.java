import java.util.*;

public class MinCostConnectPoints {

	public static class PairDist {
		int start;
		int end;
		int distance;

		PairDist(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}

	public static int minCostConnectPoints(int[][] points) {
		int result = 0;
		HashSet<Integer> visited = new HashSet<>();
		PriorityQueue<PairDist> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		pq.add(new PairDist(0, 0, 0));
		while (!pq.isEmpty() && visited.size()<points.length) {
			PairDist curr = pq.poll();
			int end = curr.end;
			int dist = curr.distance;
			if (visited.contains(end))
				continue;
			result += dist;
			visited.add(end);
			for (int i = 0; i < points.length; i++) {
				if (!visited.contains(i)) {
					pq.add(new PairDist(end, i, findDistance(points, end, i)));
				}
			}
			
		}
		return result;

	}

	public static int findDistance(int[][] points, int start, int end) {
		return Math.abs(points[start][0] - points[end][0]) + Math.abs(points[start][1]-points[end][1]);
	}

	public static void main(String args[]) {
		int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };

		System.out.print(minCostConnectPoints(points));
	}
}
