
public class SearchInsert {

	public static int searchInsert(int[] nums, int target) {

		int n = nums.length;
		int b, e, m = 0;
		b = 0;
		e = n - 1;

		while (b <= e) {
			m = (b + e) / 2;

			if (nums[m] == target)
				break;
			else if (m>0 && nums[m] > target && nums[m - 1] < target) {
				break;
			} else if (nums[m] < target) {
				b = m + 1;
			} else {
				e = m - 1;
			}
		}

		if (b > e) {
			if (target > nums[n - 1])
				return n;
			else
				return 0;
		}
		return m;

	}

	public static void main(String args[]) {
		int a[] = { 1, 3, 5, 6 };
		int t = 0;

		int result = searchInsert(a, t);
		System.out.print(result);
	}

}
