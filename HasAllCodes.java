import java.util.*;

public class HasAllCodes {
	public static boolean hasAllCodes(String s, int k) {

		Set<String> set = new HashSet<>();

		int i = 0, j = k;
		while (j <= s.length()) {
			set.add(s.substring(i, j));
			i++;
			j++;
		}

		if (set.size() == (int) Math.pow(2, k))
			return true;
		return false;

	}
	
	public static void main(String args[])
	{
		String s = "00110";
		int k = 2;
		
		System.out.print(hasAllCodes(s,k));
	}
}
