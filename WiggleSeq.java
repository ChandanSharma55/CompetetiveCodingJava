import java.util.*;

public class WiggleSeq {

	public static int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		
		if(n == 1)
			return 1;
		
		dp[0] = 1;
		if(nums[1]<nums[0] || nums[0]>nums[1])
			dp[1] = 2;
		else
			dp[1] = 1;
		
		int count = dp[1];
		for(int i=2;i<n;i++)
		{
			if((nums[i]<nums[i-1] && nums[i-1]>=nums[i-2]) || (nums[i]>nums[i-1] && nums[i-1]<=nums[i-2]))
			{
				dp[i] = count+1;
				count++;
			}
			else
			{
				dp[i] = count;
			}
		}
		return dp[n-1];
	}

	public static void main(String args[]) {
		int[] nums = {3,3,3,2,5};
		int result = wiggleMaxLength(nums);
		System.out.print(result);
	}
}
