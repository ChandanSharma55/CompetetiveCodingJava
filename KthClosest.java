import java.util.*;

//import KthSmallest.IntegerComparator;
public class KthClosest {

	public static class Pair
	{
		int diff;
		int value;
		Pair(int diff, int value)
		{
			this.diff = diff;
			this.value = value;
		}
	}
	
	public static void find(int x, int k, int[] a)
	{
		
		Comparator<Pair> com = new Comparator<Pair>()
		{
			public int compare(Pair p1, Pair p2)
			{
				if(p2.diff == p1.diff)
					return p2.value - p1.value;
				return p2.diff-p1.diff;
			}
		};
		
		PriorityQueue<Pair> queue = new PriorityQueue<>(com);
		
		int n = a.length;
		for(int i=0;i<n;i++)
		{
			queue.add(new Pair(Math.abs(x-a[i]), a[i]));
			if(queue.size() > k)
				queue.poll();
		}
		PriorityQueue<Integer> queue2 = new PriorityQueue<>();
		while(queue.size() > 0)
		{
			queue2.add(queue.poll().value);
		}
		while(queue2.size() > 0)
		{
			System.out.print(queue2.poll()+" ");
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int k = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		
		find(x,k,a);
		
	}
}
