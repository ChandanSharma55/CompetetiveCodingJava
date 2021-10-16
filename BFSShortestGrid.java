import java.util.*;
public class BFSShortestGrid {

	static int m=3,n=3;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static class Point
	{
		int x,y;
		Point(int x,int y)
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
	public static int findPath(int[][] grid)
	{
		int result = 0;
		boolean visited[][] = new boolean[m][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		while(!q.isEmpty())
		{
			int ql = q.size();
			for(int i=0;i<ql;i++)
			{
				Point curr = q.poll();
				int x = curr.x;
				int y = curr.y;
				if(!isValid(x,y) || grid[x][y]==0 || visited[x][y])
				{
					continue;
				}
				if(grid[x][y] == 9)
				{
					return result;
				}
				for(int d=0;d<4;d++)
				{
					int newX = x+dx[d];
					int newY = y+dy[d];
					q.add(new Point(newX,newY));
				}
			}
			result++;
		}
		if(result == 0)
			return -1;
		return result;
		
	}
	public static void main(String args[])
	{
		int matrix[][] = new int[3][3];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				matrix[i][j] = sc.nextInt();
			}
		}
		int result = findPath(matrix);
		System.out.print(result);
		sc.close();
	}
}
