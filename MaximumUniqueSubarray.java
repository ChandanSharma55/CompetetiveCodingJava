import java.util.*;

public class MaximumUniqueSubarray {

	public static int maximumUniqueSubarray(int[] nums) {

		HashSet<Integer> set = new HashSet<>();
		
		int i=0,j=0;
		int sum=0;
		int max = Integer.MIN_VALUE;
		while(i<=j && j<nums.length)
		{
			if(!set.contains(nums[j]))
			{
				sum += nums[j];
				set.add(nums[j]);
				j++;
			}
			else
			{
				set.remove(nums[i]);
				sum -= nums[i];
				i++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String args[])
	{
		int nums[] = {5,2,1,2,5,2,1,2,5};
		
		System.out.print(maximumUniqueSubarray(nums));
	}
}
