import java.util.*;
public class NonRepeatininStream {

	
	
	public static String findChar(String input)
	{
		int charArr[] = new int[26];
		String result = "";
		Queue<Character> q = new LinkedList<>();
		int l = input.length();
		for(int i=0;i<l;i++)
		{
			charArr[input.charAt(i)-'a']++;
			q.add(input.charAt(i));
			
			while(!q.isEmpty())
			{
				if(charArr[q.peek()-'a'] > 1)
					q.remove();
				else
				{
					result += q.peek();
					break;
				}
			}
			if(q.isEmpty())
				result = "-1";
		}
		return result;
	}
	
	public static void main(String args[])
	{
		String input = "aqizqazpn";
		System.out.println(findChar(input));
		
	}
}
