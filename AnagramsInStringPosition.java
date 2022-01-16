import java.util.*;

public class AnagramsInStringPosition {

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length())
			return result;
		Hashtable<Character, Integer> map = new Hashtable<>();
		Hashtable<Character, Integer> temp = new Hashtable<>();
		int i = 0, j = 0;
		for (i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (i = 0; i < p.length(); i++) {
			char c = s.charAt(i);
			temp.put(c, temp.getOrDefault(c, 0) + 1);
		}
		i = 0;
		j = p.length() - 1;
		while (j < s.length()) {
			if (temp.equals(map))
				result.add(i);
			j++;
			if(j==s.length())
				break;
			char add = s.charAt(j);
			temp.put(add, temp.getOrDefault(add, 0) + 1);
			char rem = s.charAt(i);
			temp.put(rem, temp.getOrDefault(rem,1) - 1);
			i++;
			if (temp.containsValue(0))
				temp.remove(rem);
		}

		return result;

	}

	public static void main(String args[]) {
		List<Integer> result = findAnagrams("cbaebabacd", "abc");

		for (int value : result)
			System.out.print(value + " ");
	}

}
