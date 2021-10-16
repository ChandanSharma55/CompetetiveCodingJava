import java.util.*;
public class FloodFill {

	public static class Pair
	{
		int x,y;
		Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int M,N;
	public static boolean isValid(int x,int y)
	{
		if(x>M-1 || x<0 || y>N-1 || y<0)
			return false;
		return true;
	}
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		M = image.length;
		N = image[0].length;
		int oldColour = image[sr][sc];
		boolean visited[][] = new boolean[M][N];
		Queue<Pair> q = new LinkedList<>();
		visited[sr][sc] = true;
		q.add(new Pair(sr,sc));
		while(!q.isEmpty())
		{
			Pair curr = q.poll();
			int currX = curr.x;
			int currY = curr.y;
			for(int i=0;i<4;i++)
			{
				int newX = currX+dx[i];
				int newY = currY+dy[i];
				if(isValid(newX,newY) 
					&& !visited[newX][newY]
					&& image[newX][newY] == oldColour)
				{
					image[newX][newY] = newColor;
					visited[newX][newY] = true;
					q.add(new Pair(newX,newY));
				}
			}
		}
		image[sr][sc] = newColor;
		return image;
		
	}
	
	public static void main(String args[])
	{
		int a[][] = {{1,1,1},
					 {1,1,0},
					 {1,0,1}};
		floodFill(a,1,1,2);
		for(int i =0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
