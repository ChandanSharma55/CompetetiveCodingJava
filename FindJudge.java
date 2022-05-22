import java.util.*;
public class FindJudge {
	public static int findJudge(int n, int[][] trust) {

		if (trust.length == 0 || trust[0].length == 0)
			return -1;

		Hashtable<Integer, Integer> map = new Hashtable<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < trust.length; i++) {
			int a = trust[i][0];
			int b = trust[i][1];

			set.add(a);
			map.put(b, map.getOrDefault(b, 0) + 1);
		}

		for (Map.Entry element : map.entrySet()) {
			if ((int) element.getValue() == n - 1 && !set.contains((int) element.getKey()))
				return (int) element.getKey();
		}

		return -1;
	}
	
	public static void main(String args[])
	{
		int n = 1;
		int[][] trust = {};
		System.out.print(findJudge(n,trust));
	}
}
