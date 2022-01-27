import java.util.*;

public class JumpGame {

	public static boolean canJump(int[] nums) {

		int reachable = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > reachable) {
				return false;
			}
			if (i + nums[i] > reachable)
				reachable = i + nums[i];

		}
		return true;

	}

	public static void main(String args[]) {
		int a[] = { 2, 3, 1, 1, 4 };
		boolean result = canJump(a);

		System.out.print(result);
	}
}
