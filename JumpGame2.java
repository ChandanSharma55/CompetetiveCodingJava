public class JumpGame2 {

	public static int canJump(int[] nums) {

		int n = nums.length;
		int maxReach = 0;
		int currentReach = 0;
		int jump = 0;
		for(int i=0;i<n-1;i++)
		{
			maxReach = Math.max(maxReach, i+nums[i]);
			if(i==currentReach)
			{
				jump++;
				currentReach = maxReach; 
			}
		}
		return jump;

	}

	public static void main(String args[]) {
		int a[] = { 2, 3, 0, 1, 4 };
		int result = canJump(a);

		System.out.print(result);
	}
}
