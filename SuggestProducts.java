import java.util.*;

public class SuggestProducts {
	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

		Arrays.sort(products);
		int l = 0, r = products.length - 1;
		int n = searchWord.length();
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			l = 0;
			r = products.length - 1;
			String sub = searchWord.substring(0, i + 1);
			while (l <= r) {
				if(products[l].length() < n)
				{
					l++;
					continue;
				}
				else
				{
					if(!products[l].substring(0, i + 1).equals(sub))
						l++;
					else
						break;
				}
			}
			while (l <= r) {
				if(products[r].length() < n)
				{
					r--;
					continue;
				}
				else
				{
					if(!products[r].substring(0, i + 1).equals(sub))
						r--;
					else
						break;
				}
			}
			List<String> temp = new ArrayList<>();
			for (int x = l; x <= r && temp.size() < 3; x++) {
				temp.add(products[x]);
			}
			result.add(new ArrayList<>(temp));
		}

		return result;
	}

	public static void main(String args[]) {
		String[] p = { "bags", "baggage", "banner", "box", "cloths" };
		String w = "bags";

		List<List<String>> result = suggestedProducts(p, w);

		for (List<String> value : result) {
			for (String v : value) {
				System.out.print(v + "-");
			}
			System.out.println();
		}
	}
}
