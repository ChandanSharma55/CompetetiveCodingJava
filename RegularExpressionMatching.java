import java.util.*;

public class RegularExpressionMatching {

	//Recursion
	public static boolean solve(String s,String p,int i,int j)
	{
		if(i>=s.length() && j>=p.length())
			return true;
		if(j>=p.length())
			return false;
		boolean match = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j)=='.');
		
		if(j+1 < p.length() && p.charAt(j+1)=='*')
		{
			boolean notTaking = solve(s,p,i,j+2);
			boolean Taking = match && solve(s,p,i+1,j);
			return notTaking || Taking;
		}
		else if(match)
		{
			return solve(s,p,i+1,j+1);
		}
		
		return false;
		
	}
	
	public static boolean isMatch(String s, String p) {

		return solve(s,p,0,0);
		
	}

	public static void main(String args[]) {
		String p = "a*";
		String s = "aa";

		System.out.print(isMatch(s, p));
	}
}
