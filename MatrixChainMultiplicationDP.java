import java.util.*;
public class MatrixChainMultiplicationDP {

	static int[][] t;
	public static int MCM(int a[])
	{
		int l = a.length;
		int n=l-1;
		int t[][] = new int[n][n];
		
		
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++,j++)
			{
				if(g==0)
					t[i][j] = 0;
				else if(g==1)
				{
					t[i][j] = a[i]*a[j]*a[j+1];
				}
				else
				{
					int min = Integer.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						int left = t[i][k];
						int right = t[k+1][j];
						int mult = a[i]*a[k+1]*a[j+1];
						if(left+right+mult < min)
							min = left+right+mult;
					}
					t[i][j] = min;
				}
			}
		}
		
		return t[0][n-1];
		
		
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
		int result = MCM(a);
		System.out.print(result);
		sc.close();
	}
}
