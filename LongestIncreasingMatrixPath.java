import java.util.*;
public class LongestIncreasingMatrixPath {

	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int m,n;
	static class Pair
	{
		int x;
		int y;
		Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static boolean isValid(int x,int y)
	{
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		return true;
	}
	
	public static int bfs(int [][]grid)
	{
		int result = 0;
		boolean visited[][] = new boolean[m][n];
		Queue<Pair> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(new Pair(0,0));
		while(!q.isEmpty())
		{
			int ql = q.size();
			while(ql--!=0)
			{
				Pair curr = q.poll();
				int x = curr.x;
				int y = curr.y;
				visited[x][y] = true;
				for(int i=0;i<4;i++)
				{
					int newX = x+dx[i];
					int newY = y+dy[i];
					if(isValid(newX,newY) && !visited[newX][newY] && grid[newX][newY]>grid[x][y])
					{
						q.add(new Pair(newX,newY));
					}
				}
			}
			result++;
		}
		return result;
	}
	
	public static void main(String args[])
	{
		 int grid[][] = { { 1, 2 },
                          { 3, 4 } };
		 m = grid.length;
		 n = grid[0].length;
		 int result = bfs(grid);
		 
		 System.out.println(result);
	}
}
