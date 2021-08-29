import java.util.*;
public class MaxProdPair {

	public static void findPair(int a[])
	{
		int n = a.length;
		if(n<2)
		{
			System.out.print("No such pair");
			return;
		}
		if(n==2)
		{
			System.out.print(a[0]+" * "+a[1]);
			return;
		}
		int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		for(int value:a)
		{
			if(Math.abs(value) > Math.abs(max))
			{
				max2 = max;
				max = value;	
			}
		}
		System.out.print(max+" * "+max2);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		findPair(a);
		sc.close();
	}
}
