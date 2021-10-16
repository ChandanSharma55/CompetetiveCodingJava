import java.util.*;
public class PermutationofS1inS2 {

	public static boolean checkInclusion(String s1, String s2)
	{
		int n = s1.length();
		Hashtable<Character,Integer> map = new Hashtable<>();
		Hashtable<Character,Integer> map2 = new Hashtable<>();
		Set<Hashtable<Character,Integer>> set= new HashSet<>();
		for(int i=0;i<n;i++)
		{
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
		}
		set.add(map);
		int win = n;
		for(int i=0;i<win;i++)
		{
			map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
		}
		int i=0,j=win-1;
		while(j<s2.length())
		{
			if(set.contains(map2))
				return true;
			else
			{
				j++;
				if(j==s2.length())
					break;
				map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0)+1);
				map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)-1);
				i++;
				if(map2.containsValue(0))
					map2.remove(s2.charAt(i-1));
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		String s1 = "ab";
		String s2 = "eidbaooo";
		
		System.out.print(checkInclusion(s1,s2));
	}
}
