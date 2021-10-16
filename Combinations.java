import java.util.*;
public class Combinations {

	public static List<List<Integer>> result = new ArrayList<>();
	public static int N;
	public static void combinations(int[] nums,int k, List<Integer> subset,int start)
	{
		if(subset.size() == k)
		{
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		
		for(int i=start;i<N;i++)
		{
			subset.add(nums[i]);
			combinations(nums,k,subset,i+1);
			subset.remove(subset.size()-1);
		}
		
	}
	
	public static List<List<Integer>> combine(int n,int k)
	{
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = i+1;
		}
		combinations(nums,k,new ArrayList<>(),0);
		return result;
	}
	
	public static void main(String args[])
	{
		int n = 4;
		N=n;
		int k = 2;
		List<List<Integer>> result = combine(n,k);
		
		for(List<Integer> each:result)
		{
			for(Integer value:each)
			{
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
}
