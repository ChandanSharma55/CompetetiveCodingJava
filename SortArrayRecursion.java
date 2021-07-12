import java.util.*;
public class SortArrayRecursion {

	
	public static void sort(List<Integer> a)
	{
		int n = a.size();
		if(n == 1)
			return;
		int temp = a.get(n-1);
		a.remove(n-1);
		sort(a);
		insert(a, temp);
	}
	
	public static void insert(List<Integer> a, int temp)
	{
		int n = a.size();
		if((n==0) || (a.get(n-1) < temp))
		{
			a.add(temp);
			return;
		}
		int val = a.get(n-1);
		a.remove(n-1);
		insert(a,temp);
		a.add(val);
		return;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> a = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			a.add(sc.nextInt());
		}
		
		sort(a);
		
		for(int v : a)
		{
			System.out.println(v);
		}
		
		sc.close();
	}
}
