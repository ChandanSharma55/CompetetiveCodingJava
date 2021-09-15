import java.util.*;
public class SpiralMatrix {

	public static int[][] generateMatrix(int n) {
		
		int a[][] = new int[n][n];
		int k=1;
		int t=0,b=n-1,r=n-1,l=0;
		int d=0;
		while(k<=(n*n))
		{
			//top
			if(d==0)
			{
				for(int i=l;i<=r;i++)
				{
					a[t][i] = k++;
				}
				t++;
			}
			
			//right
			else if(d==1)
			{
				for(int i=t;i<=b;i++)
				{
					a[i][r] = k++;
				}
				r--;
			}
			
			//bottom
			else if(d==2)
			{
				for(int i=r;i>=l;i--)
				{
					a[b][i] = k++;
				}
				b--;
			}
			
			//left
			else if(d==3)
			{
				for(int i=b;i>=t;i--)
				{
					a[i][l] = k++;
				}
				l++;
			}
			
			d = (d+1)%4;
		}
		return a;
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[][] = generateMatrix(n);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
