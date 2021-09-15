import java.util.*;

public class RottingOrange {

	public static class Point {
		int x, y;
        int time;
		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
            this.time = time;
		}
	}

	public static boolean isValid(int x, int y) {
		if (x < 0 || x > M - 1 || y < 0 || y > N - 1)
			return false;
		return true;
	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int M, N;
    
    public static int orangesRotting(int[][] grid) {
        
        int m = grid.length;
		int n = grid[0].length;
		M = m;
		N = n;
		int count = 0;
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2)
					q.add(new Point(i,j,0));
			}
		}
		while (!q.isEmpty()) {
			Point curr = q.remove();
			int currX = curr.x;
			int currY = curr.y;
            int currTime = curr.time;
			//boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int newX = currX + dx[i];
				int newY = currY + dy[i];
				if (isValid(newX, newY) && grid[currX][currY] == 2 && grid[newX][newY] == 1) {
					q.add(new Point(newX, newY, currTime+1));
					grid[newX][newY] = 2;

				}
			}
            count = currTime;
			
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}
		return count;

	}

	public static void main(String args[]) {
		// Scanner sc = new Scanner(System.in);
		int a[][] = { {2,1,1},{1,1,0},{0,1,1} };
		int result = orangesRotting(a);

		System.out.print(result);

	}
}
