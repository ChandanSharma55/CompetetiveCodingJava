import java.util.*;

public class ReconstructQueue {

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> ordered = new LinkedList<>();
		for (int[] p : people) {
			ordered.add(p[1], p);
		}

		return ordered.toArray(new int[people.length][2]);
	}
	
	public static void main(String args[])
	{
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] result = reconstructQueue(people);
		
		for(int[] list:result)
		{
			for(int value:list)
			{
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
}
