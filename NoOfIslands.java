import java.util.*;
public class NoOfIslands {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int n,m;
	public static boolean isValid(int x,int y)
	{
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		return true;	
	}
	
	public static void dfs(int x,int y,boolean[][] visited,char[][] grid)
	{
		visited[x][y] = true;
		for(int i=0;i<4;i++)
		{
			if(isValid(x+dx[i],y+dy[i]) && grid[x+dx[i]][y+dy[i]]=='1' && !visited[x+dx[i]][y+dy[i]])
			{
				dfs(x+dx[i],y+dy[i],visited,grid);
			}
		}
		
	}
	
	public static int numIslands(char[][] grid)
	{
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j]=='1' && !visited[i][j])
				{
					count++;
					dfs(i,j,visited,grid);
				}
			}
		}
		return count;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		char[][] a = {{'1','1','0','0','0'},
				      {'1','1','0','0','0'},
				      {'0','0','1','0','0'},
				      {'0','0','0','1','1'}};
		m = a.length;
		n = a[0].length;
		int result = numIslands(a);
		System.out.println(result);
		sc.close();
	}
	
}
