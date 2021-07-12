import java.util.*;
public class StackSortRecursion {

	
	public static void sort(Stack<Integer> a)
	{
		int n = a.size();
		if(n == 1)
			return;
		int temp = a.pop();
		//a.remove(n-1);
		sort(a);
		insert(a, temp);
	}
	
	public static void insert(Stack<Integer> a, int temp)
	{
		int n = a.size();
		if((n==0) || (a.get(n-1) < temp))
		{
			a.push(temp);
			return;
		}
		int val = a.get(n-1);
		a.pop();
		insert(a,temp);
		a.push(val);
		return;
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
		
		sort(a);
		
		while(!a.isEmpty())
		{
			System.out.println(a.pop());
		}
		
		sc.close();
	}
}
