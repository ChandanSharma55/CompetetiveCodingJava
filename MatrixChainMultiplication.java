//memoization

import java.util.*;
public class MatrixChainMultiplication {

	static int[][] t;
	public static int MCM(int a[], int i,int j)
	{
		if(i>=j)
			return 0;
		if(t[i][j]!=0)
			return t[i][j];
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			int temp = MCM(a,i,k) + MCM(a,k+1,j) + (a[i-1]*a[k]*a[j]);
			if(temp<min)
				min = temp;
		}
		t[i][j] = min;
		return min;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		t = new int[n][n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int result = MCM(a,1,n-1);
		System.out.print(result);
		sc.close();
	}
}
