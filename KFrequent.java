import java.util.*;
public class KFrequent {

	
	public static class Pair
	{
		int value;
		int frequency;
		Pair(int value,int frequency)
		{
			this.value = value;
			this.frequency = frequency;
		}
	}
	
	public static int[] findKFreq(int a[],int k)
	{
		int result[] = new int[k];
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int value:a)
		{
			map.put(value, map.getOrDefault(value, 0)+1);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>()
		{
			@Override
			public int compare(Pair pair1, Pair pair2)
			{
				return pair2.frequency-pair1.frequency;
			}
		});
		
		for(Map.Entry mapElement : map.entrySet())
		{
			Pair temp = new Pair((int)mapElement.getKey(),(int)mapElement.getValue());
			pq.add(temp);
		}
		for(int i=0;i<k;i++)
		{
			result[i] = pq.remove().value;
		}
		return result;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n,k;
		n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		k=sc.nextInt();
		int[] result = findKFreq(a,k);
		
		for(int value:result)
			System.out.print(value+" ");
		sc.close();
	}
	
}
