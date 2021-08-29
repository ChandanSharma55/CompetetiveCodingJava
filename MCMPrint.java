/*
 * Not working code
 */

import java.util.*;
public class MCMPrint {

	static char name;
	public static void printBrackets(int i, int j,int[][] brackets)
	{
		if(i>=j)
		{
			System.out.print(name++);
			return;
		}
		System.out.print("(");
		
		printBrackets(i,brackets[i][j],brackets);
		printBrackets(brackets[i][j]+1,j,brackets);
		
		System.out.print(")");
		
	}
	
	public static void printOptimal(int a[])
	{
		int n = a.length-1;
		//{40, 20, 30, 10, 30}
		int t[][] = new int[n][n];
		int bracket[][] = new int[n][n];
		/*
		 * ABC = > (AB)C  OR   A(BC)
		 * 1st case => left = AB  right = C, multiplication value => AB * C
		 * 2nd case => left = A  right = BC, multiplication value => A * BC
		 */
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
						int left=t[i][k];
						int right=t[k+1][j];
						int mult = a[i]*a[k+1]*a[j+1];
						int cost = left+right+mult;
						//min = Math.min(min, cost);
						if(min > cost)
						{
							min = cost;
							t[i][j] = min;
							bracket[i][j] = k;
						}
					}
					
				}
			}
		}
		name = 'A';
		System.out.println("Least Cost=> "+t[0][n-1]);
		printBrackets(0,n-1,bracket);
		
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		int i=0;
		while(i < n)
		{
			a[i] = sc.nextInt();
			i++;
		}
		
		printOptimal(a);
		
		sc.close();
	}
}
