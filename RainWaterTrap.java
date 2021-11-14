import java.util.*;
public class RainWaterTrap {

	
	public static int trap(int[] height)
	{
		int n=height.length;
		int l=1,r=n-2;
		int leftMax = height[0];
		int rightMax = height[n-1];
		int result = 0;
		while(l<=r)
		{
			if(leftMax<rightMax)
			{
				if(height[l]>=leftMax)
					leftMax = height[l];
				else
					result+=leftMax-height[l];
				l++;
			}
			else
			{
				if(height[r]>=rightMax)
					rightMax = height[r];
				else
					result+=rightMax-height[r];
				r--;
			}
		}
		return result;
		
	}
	
	public static void main(String args[])
	{
		//int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int height[] = {4,2,0,3,2,5};
		int height[] = {4,2,3};
		int result = trap(height);
		System.out.println(result);
	}
}
