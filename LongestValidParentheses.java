import java.util.*;
public class LongestValidParentheses {

	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int count=0;
		int max=0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		if(n==0 || s==null)
		{
			System.out.print(0);
			return;
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				if(s.charAt(i)==')')
				{
					stack.pop();
					if(stack.isEmpty())
						stack.push(i);
					else
					{
						count = i-stack.peek();
						max = Math.max(max, count);
					}
				}
				else
				{
					stack.push(i);
				}
			}
		}
		System.out.print(max);
		return;
		
	}
}
