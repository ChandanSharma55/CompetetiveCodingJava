import java.util.*;

public class GroupAnagrams {

	public static List<List<String>> findGroup(String[] a) {
		List<List<String>> result = new ArrayList<>();

		HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();

		for (String value : a) {
			HashMap<Character, Integer> smallmap = new HashMap<>();
			for (Character c : value.toCharArray()) {
				smallmap.put(c, smallmap.getOrDefault(c,0)+1);
			}
			if (bigMap.containsKey(smallmap)) {
				ArrayList<String> newValue = bigMap.get(smallmap);
				newValue.add(value);
				bigMap.put(smallmap, newValue);
			}

			else {
				bigMap.put(smallmap, new ArrayList<>(List.of(value)));
			}
		}
		
		for(ArrayList<String> val:bigMap.values())
		{
			result.add(val);
		}
		
		return result;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a[] = new String[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
		}

		List<List<String>> result = findGroup(a);
		for (List<String> value : result) {

			for (String v : value) {
				System.out.print(v + " ");
			}
			System.out.print("\n");
		}

		sc.close();
	}
}
