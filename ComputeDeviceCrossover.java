import java.util.*;
public class ComputeDeviceCrossover {

	
	public static int compute(int n, int[] w,int m,int[] a)
	{
		if(m==0 || n==0)
			return 0;
		int result = 1;
		int i=0,j=0;
		int curr;
		if(w[0]<a[0])
		{
			curr = 0;
			i++;
		}
		else
		{
			curr = 1;
			j++;
		}
		while(i<n && j<m)
		{
			if(w[i] > a[j])
			{
				if(curr == 0)
				{
					result++;
					curr = 1;
				}
				j++;
			}
			else if(w[i] < a[j])
			{
				if(curr == 1)
				{
					result++;
					curr = 0;
				}
				i++;
			}
		}
		return result;
	}
	
	public static void main(String args[])
	{
		int n = 0;
		int w[] = {};
		int m = 4;
		int a[] = {1,5,7,15};
		
		System.out.print(compute(n,w,m,a));
		
	}
}
