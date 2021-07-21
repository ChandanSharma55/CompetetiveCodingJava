import java.util.*;

public class LongestNonRepeatSubstring {

	public static int lengthOfLongestSubstring(String s) {

		int l = s.length();
		Hashtable<Character, Integer> h = new Hashtable<>();
		int count = 0;
		int max = 0;
		for (int i = 0; i < l; i++) {
			if (h.containsKey(s.charAt(i))) {
				count = i - h.get(s.charAt(i));
				h.remove(s.charAt(i));
				h.put(s.charAt(i), i);
			} else {
				h.put(s.charAt(i), i);
				count++;
			}
			max = (count > max) ? count : max;
		}
		return max;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.print(lengthOfLongestSubstring(s));
		sc.close();
	}
}
