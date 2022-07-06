import java.util.*;

public class LongestStringChain {

	public static int longestStrChain(String[] words) {

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String x, String y) {
				return x.length() - y.length();
			}
		});

		Hashtable<String, Integer> map = new Hashtable<>();

		for (String value : words) {
			map.put(value, 1);
		}

		for (String value : words) {
			int l = value.length();
			for (int i = 0; i < l; i++) {
				String temp = value.substring(0, i) + value.substring(i + 1, l);
				if (map.containsKey(temp)) {
					map.put(value, Math.max(map.get(temp) + 1, map.get(value)));
				}
			}
		}
		int max = 0;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			max = Math.max(max, (int) e.getValue());
		}

		return max;
	}

	public static void main(String args[]) {
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		System.out.print(longestStrChain(words));
	}
}
