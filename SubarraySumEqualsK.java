import java.util.*;

public class SubarraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		for(int value:nums)
		{
			sum += value;
			if(sum == k)
				count++;
			if(map.containsKey(sum-k))
			{
				count += map.get(sum-k);
			}
			
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}

	public static void main(String args[]) {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		
		System.out.print(subarraySum(nums,k));
	}
}
