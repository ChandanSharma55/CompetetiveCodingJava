import java.util.*;
public class PrintNBinary1GThan0 {

	
	public static List<String> result = new ArrayList<>(); 
	
	public static void solve(int o, int z, int n,String op)
	{
		//base condition
		if(n==0)
		{
			result.add(op);
			return;
		}
		String op1 = op;
		op1 += "1";
		solve(o+1,z,n-1,op1);
		if(o>z)
		{
			String op2 = op;
			op2 += "0";
			solve(o,z+1,n-1,op2);
		}
		return;
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int one = 0;
		int zero = 0;
		
		solve(one,zero,n,"");
		
		for(String value : result)
		{
			System.out.println(value);
		}
		sc.close();
	}
}
