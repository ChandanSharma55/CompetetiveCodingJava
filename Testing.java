import java.util.*;
public class Testing {

	
	public static void allPermutationsOfSameSize(String s,String o,boolean[] used)
	{
		if(o.length() == s.length())
			System.out.print(o+" ");
		
		for(int i=0;i<s.length();i++)
		{
			if(used[i])
				continue;
			used[i] = true;
			o += s.charAt(i);
			allPermutationsOfSameSize(s,o,used);
			o = o.substring(0,o.length()-1);
			used[i] = false;
		}
	}
	public static void everyPossibleString(String s,String o,int index)
	{
		if(index == s.length())
		{
			System.out.print(o+" ");
		}
		for(int i=index;i<s.length();i++)
		{
			o += s.charAt(i);
			everyPossibleString(s,o,i+1);
			o = o.substring(0,o.length()-1);
		}
	}
	public static void main(String args[])
	{
		String x = "abc";
		String op1 = "";
		String op2 = "";
		System.out.println("PermsOfSameSize");
		allPermutationsOfSameSize(x,op1,new boolean[x.length()]);
		System.out.println("\nEveryPossibleString");
		everyPossibleString(x,op2,0);
	}
}
