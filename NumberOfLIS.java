import java.util.*;

public class NumberOfLIS {

	public static int findNumberOfLIS(int[] nums) {

		int n = nums.length;
		int find[] = new int[n];
		int max = 1,maxC = 1;
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			find[i] = 1;
			count[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (find[i] < find[j]+1) {
						find[i] = find[j] + 1;
						count[i] = count[j];
					} else if (find[i] == find[j] + 1) {
						count[i] += count[j];
					}
				}

			}
			if(max < find[i])
			{
				max = find[i];
				maxC = count[i];
			}
			else if(max == find[i])
			{
				maxC += count[i];
			}
		}
		
		return maxC;

	}

	public static void main(String args[]) {
		int a[] = {1,3,5,4,7};

		System.out.print(findNumberOfLIS(a));
	}
}
