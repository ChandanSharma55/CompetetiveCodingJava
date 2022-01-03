import java.util.*;

public class SearchRotatedArray {
	public static int search(int[] nums, int target) {

		int h = nums.length - 1;
		int l = 0, m = 0;
		findPivot(nums, h, l);
		
		if(pivot==-1)
			return binarySearch(nums,h,l,target);
		else
		{
			int x = binarySearch(nums,pivot,l,target);
			int y = binarySearch(nums,h,pivot+1,target);
			return (x!=-1)?x:y;
		}
	}

	public static int pivot = -1;

	public static void findPivot(int[] nums, int h, int l) {
		while (h >= l) {
			int m = l + (h - l) / 2;
			if (m != nums.length - 1 && nums[m + 1] < nums[m]) {
				pivot = m;
				return;
			} else {
				findPivot(nums, h, m + 1);
				findPivot(nums, m - 1, l);
				return;
			}
		}
	}

	public static int binarySearch(int[] nums,int h,int l,int target)
	{
		while(h>=l)
		{
			int m=l+(h-l)/2;
			if(nums[m]==target)
			{
				return m;
			}
			else if(nums[m]>target)
			{
				h=m-1;
			}
			else
			{
				l=m+1;
			}
		}
		return -1;
	}
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5,6,7};
		int target = 3;
		
		int result = search(a,target);
		
		System.out.print(result);
	}
}
