import java.util.*;
public class KthLargest {

	public static int find(int[] a, int n, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			queue.add(a[i]);
			if (queue.size() > k)
				queue.poll();
		}
		return queue.peek();
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		
		int result = find(a,n,k);
		
		System.out.print(result);
		
	}
}
