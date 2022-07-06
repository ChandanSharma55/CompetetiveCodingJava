import java.util.*;

public class ReduceXToZero {
	public static int minOperations(int[] nums, int x) {
		
		int sum = 0;
		for(int value:nums)
		{
			sum += value;
		}
		
		if(x>sum)
			return -1;
		sum -= x;
		if(sum==0)
			return nums.length;
		
		int i=0;
		int csum = 0;
		int l = 0;
		for(int j=0;j<nums.length;j++)
		{
			csum += nums[j];
			
			while(i<nums.length && csum>sum)
			{
				csum -= nums[i++];
			}
			if(sum == csum)
			{
				l = Math.max(l, j-i+1);
			}
		}
		if(l==0)
			return -1;
		
		return nums.length-l;
	}

	public static void main(String args[]) {
		int nums[] = {3,2,20,1,1,3};
		int x = 10;
		
		int r = minOperations(nums,x);
		System.out.print(r);
	}
}
