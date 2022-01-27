import java.util.*;

public class CombinationSum2 {

	public static List<List<Integer>> results = new ArrayList<>();

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		Arrays.sort(candidates);
		combine(candidates, target, 0, new ArrayList<Integer>(), 0,false);
		return results;
	}

	public static void combine(int[] c, int t, int sum, List<Integer> list, int index,boolean isGreater) {
		if (sum == t) {
			results.add(new ArrayList<>(list));
			return;
		}
		if (sum > t || index >= c.length)
		{
			isGreater = true;
			return;
		}

		int prev = -1;
		for (int i = index; i < c.length; i++) {
			if (c[i] == prev)
				continue;
			list.add(c[i]);
			combine(c, t, sum + c[i], list, i + 1,isGreater);
			if(isGreater)
				break;
			list.remove(list.size() - 1);
			prev = c[i];
		}
	}

	public static void main(String args[]) {
		int a[] = { 10,1,2,7,6,1,5 };
		int target = 8;

		List<List<Integer>> result = combinationSum2(a, target);

		for (List<Integer> values : result) {
			for (int value : values) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
