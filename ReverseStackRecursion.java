import java.util.*;
public class ReverseStackRecursion {
	
	
	public static void reverse(Stack<Integer> a)
	{
		if(a.isEmpty())
			return; 
		int value = a.pop();
		reverse(a);
		insert(a,value);
		return;
	}
	
	public static void insert(Stack<Integer> a, int value)
	{
		if(a.isEmpty())
		{
			a.push(value);
			return;
		}
		int popped = a.pop();
		insert(a,value);
		a.push(popped);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> a = new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			a.push(sc.nextInt());
		}
		
		reverse(a);
		
		while(!a.isEmpty())
		{
			System.out.println(a.pop());
		}
		
		sc.close();
	}

}
