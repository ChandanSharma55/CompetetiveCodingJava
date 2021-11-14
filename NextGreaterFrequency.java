import java.util.*;
public class NextGreaterFrequency {

	
	public static int[] solve(int a[])
	{
		int n = a.length;
		int result[] = new int[n];
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int value:a)
		{
			map.put(value, map.getOrDefault(value, 0)+1);
		}
		
		int freq[] = new int[n];
		for(int i=0;i<n;i++)
		{
			freq[i] = map.get(a[i]);
		}
		
		Stack<Integer> stk = new Stack<>();
		result[n-1] = -1;
		stk.push(n);
		for(int i=n-1;i>=0;i--)
		{
			while(!stk.isEmpty() && stk.peek()!=n && freq[stk.peek()]<=freq[i])
			{
				stk.pop();
			}
			if(stk.isEmpty())
			{
				stk.push(n);
			}
			result[i] = stk.peek()==n?-1:a[stk.peek()];
			stk.push(i);
		}
		
		return result;
	}
	
	public static void main(String args[])
	{
		//int a[] = {1,1,2,3,4,2,1};
		int a[] = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
		int result[] = solve(a);
		
		for(int value:result)
		{
			System.out.print(value+" ");
		}
	}
}
