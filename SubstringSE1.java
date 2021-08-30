import java.util.*;
//start and end with 1
public class SubstringSE1 {

	public static int countSubs(String s)
	{
		int count = 0, result=0;
		int n = s.length();
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '1')
				count++;
		}
		result = (count*(count-1))/2;
		
		return result;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int result = countSubs(s);
		System.out.print(result);
	}
}
