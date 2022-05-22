import java.util.*;

class Pattern132 {
	public static boolean find132pattern(int[] nums) {

		int n = nums.length;
		boolean[] left = new boolean[n];
		boolean[] right = new boolean[n];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (nums[i] > min)
				left[i] = true;
			else {
				min = nums[i];
				left[i] = false;
			}
		}

		min = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > min)
				right[i] = true;
			else {
				min = nums[i];
				right[i] = false;
			}
		}

		for (int i = 0; i < n; i++) {
			if (left[i] && right[i])
				return true;
		}

		return false;
	}

	public static void main(String args[]) {
		boolean x = find132pattern(new int[]{1,0,1,-4,-3});
		System.out.print(x);
	}
}