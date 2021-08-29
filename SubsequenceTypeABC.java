import java.util.*;
public class SubsequenceTypeABC {

	public static void printOutputs(String x)
	{
		int a=0,ab=0,abc=0;
		
		for(int i=0;i<x.length();i++)
		{
			if(x.charAt(i) == 'a')
				a = 2*a + 1;
			else if(x.charAt(i) == 'b')
				ab = 2*ab + a;
			else
				abc = 2*abc + ab;
		}
		System.out.print(abc);
	}
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
	
		printOutputs(s); 
		
		sc.close();
	}
}
