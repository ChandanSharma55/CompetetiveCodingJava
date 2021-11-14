import java.util.*;
public class BooleanMatrixLargestArea {

	static int m,n;
	static int count=0;
	static int dx[] = {1,0,-1,0,1,1,-1,-1};
	static int dy[] = {0,1,0,-1,1,-1,1,-1};
	
	public static boolean isValid(int x,int y)
	{
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		return true;
	}
	
	public static void dfs(int a[][],int x,int y,boolean[][] visited)
	{
		visited[x][y] = true;
		count++;
		for(int i=0;i<8;i++)
		{
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(isValid(newX,newY) && a[newX][newY]==1 && !visited[newX][newY])
				dfs(a,newX,newY,visited);
		}
	}
	
	public static int findMaxArea(int a[][])
	{
		m = a.length;
		n = a[0].length;
		int max=0;
		boolean visited[][] = new boolean[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{ 
				if(a[i][j] == 1)
				{
					count = 0;
					dfs(a,i,j,visited);
					max = count>max?count:max;
				}
			}
		}
		return max;
	}
	
	
	public static void main(String args[])
	{
		int a[][] = {{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
		
		int result = findMaxArea(a);
		
		System.out.println(result);
	}
}
