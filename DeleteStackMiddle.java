import java.util.*;
public class DeleteStackMiddle {

	
	public static void removeMiddle(Stack<Integer> s, int k)
	{
		if(s.isEmpty())
			return;
		
		if(k == 1)
		{
			s.pop();
			return;
		}
		
		int val = s.pop();
		removeMiddle(s, k-1);
		s.push(val);
		return;
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		Stack<Integer> s = new Stack<>();
		for(int i = 0;i<(int)n;i++)
		{
			s.push(sc.nextInt());
		}
		
		int k = (int)Math.ceil(n/2);
		removeMiddle(s, k);
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
	}
}
