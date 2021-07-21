import java.util.*;
public class UniquePathsEff {

	public static int uniquePath(int x,int y)
	{
		int[][] t = new int[x][y];
		t[0][0] = 0;
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				if(i==0 || j==0)
					t[i][j]=1;
			}
		}
		t[0][0] = 0;
		for(int i=1;i<x;i++)
		{
			for(int j=1;j<y;j++)
			{
				t[i][j] = t[i-1][j]+t[i][j-1];
			}
		}
		return t[x-1][y-1];
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int result = uniquePath(m,n);
	
		System.out.print(result);
	}
	
}
