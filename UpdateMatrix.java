import java.util.*;
public class UpdateMatrix {

	public static class Pair
	{
		int x,y;
		Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static int m,n,minSteps=Integer.MAX_VALUE,count=0;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static boolean isValid(int x,int y)
	{
		if(x>m-1 || y>n-1 || y<0 || x<0)
			return false;
		return true;
	}
	
	
	public static int[][] updateMatrix(int a[][])
	{
		boolean visited[][] = new boolean[m][n];
		Queue<Pair> q = new LinkedList<>();
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j] == 0)
				{
					q.add(new Pair(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty())
		{
			int size = q.size();
			while(size-->0)
			{
				Pair curr = q.poll();
				int currX = curr.x;
				int currY = curr.y;
				for(int i=0;i<4;i++)
				{
					int newX = currX+dx[i];
					int newY = currY+dy[i];
					if(!isValid(newX,newY) || visited[newX][newY])
						continue;
					a[newX][newY] = a[currX][currY]+1;
					q.add(new Pair(newX,newY));
					visited[newX][newY] = true;
				}
			}
		}
		
		return a;
	}
	
	public static void main(String args[])
	{
		int a[][] = {{0,0,0},
					 {0,1,0},
					 {1,1,1}};
		m=a.length;
		n=a[0].length;
		a = updateMatrix(a);
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
