import java.util.*;

public class CombinationSums {

	public static List<List<Integer>> results = new ArrayList<>();

	public static List<List<Integer>> combinationSum(int[] c, int t) {

		combine(c, t, 0, new ArrayList<Integer>(), 0);

		return results;
	}

	public static void combine(int[] c, int t, int sum, List<Integer> list, int index) {
		if (sum == t) {
			results.add(new ArrayList<>(list));
			return;
		}
		if (sum > t || index == c.length)
			return;
		
		list.add(c[index]);
		combine(c,t,sum+c[index],list,index);
		list.remove(list.size()-1);
		combine(c,t,sum,list,index+1);
	}

	public static void main(String args[]) {
		int a[] = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> result = combinationSum(a, target);

		for (List<Integer> values : result) {
			for (int value : values) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
