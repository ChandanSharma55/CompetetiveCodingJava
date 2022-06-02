import java.util.*;

public class RestoreIP {
	static List<String> result;

	public static List<String> restoreIpAddresses(String s) {
		result = new ArrayList<>();
		restoreIpAddresses(s, 0, 0, "");
		return result;
	}

	public static void restoreIpAddresses(String s, int i, int p, String o) {
		
		if(i==s.length() && p==4)
		{
			result.add(o.substring(0,o.length()-1));
			return;
		}
		if(i+1<=s.length() && isValid(s.substring(i, i+1)))
			restoreIpAddresses(s,i+1,p+1,o+s.substring(i,i+1)+".");
		if(i+2<=s.length() && isValid(s.substring(i, i+2)))
			restoreIpAddresses(s,i+2,p+1,o+s.substring(i,i+2)+".");
		if(i+3<=s.length() && isValid(s.substring(i, i+3)))
			restoreIpAddresses(s,i+3,p+1,o+s.substring(i,i+3)+".");
	}
	
	public static boolean isValid(String s)
	{
		if(s.charAt(0) == '0' && s.length()>1)
			return false;
		return Integer.parseInt(s)<=255;
	}

	public static void main(String args[]) {
		String s = "25525511135";
		List<String> result = restoreIpAddresses(s);

		for (String value : result) {
			System.out.println(value);
		}
	}
}
