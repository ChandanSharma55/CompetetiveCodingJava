import java.util.*;
public class ReplaceGreatestLeft {

	public static int[] replaceLeft(int[] a)
	{
		int n = a.length;
		//int[] x = new int[n];
		int currMax = a[n-1];
		a[n-1]=-1;
		for(int i=n-2;i>=0;i--)
		{
			int temp = a[i];
			a[i] = currMax;
			if(temp>currMax)
			{
				currMax = temp;
			}
		}
		
		return a;
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
		a = replaceLeft(a);
		for(int value:a)
		{
			System.out.print(value+" ");
		}
		sc.close();
	}
}
