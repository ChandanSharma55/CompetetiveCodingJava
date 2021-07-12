import java.util.*;
public class LetterCombinationLeetcode {

	
	static List<String> result = new ArrayList<>();
	static String d=""; 
	static Hashtable<Character,String> h = new Hashtable<>();
	public static void findPermutations(String s, int i)
	{
		if(i == d.length())
		{
			result.add(s);
			return;
		}
		
		for(int j=0;j<h.get(d.charAt(i)).length();j++)
		{
			char c = h.get(d.charAt(i)).charAt(j);
			findPermutations(s+c,i+1);
		}
	}
	
	public static List<String> letterCombinations(String digits) {
	        
			d = digits;
	        h.put('2',"abc");
	        h.put('3',"def");
	        h.put('4',"ghi");
	        h.put('5',"jkl");
	        h.put('6',"mno");
	        h.put('7',"pqrs");
	        h.put('8',"tuv");
	        h.put('9',"wxyz");
	        
	        String s = "";
	        
	        
	        findPermutations(s,0);
	        return result;
	    }
	
	public static void main(String args[])
	{
		Scanner sc  = new Scanner(System.in);
		String x = sc.next();
		List<String> answer = letterCombinations(x);
		
		for(String v:answer)
		{
			System.out.println(v);
		}
	}
}
