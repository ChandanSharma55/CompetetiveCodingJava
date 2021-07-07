import java.util.*;
public class GenerateParentheses {

	
	public static List<String> result = new ArrayList<>(); 
	
	public static void solve(int o, int c, String op)
	{
		//base condition
		if(o==0 && c==0)
			result.add(op);
		if(o != 0)
		{
			String x = op;
			x += "(";
			solve(o-1,c,x);
		}
		if(c>o)
		{
			String x = op;
			x += ")";
			solve(o,c-1,x);
		}
		return;
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int open = n;
		int close = n;
		
		solve(open,close,"");
		
		for(String value : result)
		{
			System.out.print(value+" ");
		}
	}
}
