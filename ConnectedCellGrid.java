import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ConnectedCellGrid {

    /*
     * Complete the 'maxRegion' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY grid as parameter.
     */
	//static int nodes = 0;
	static int[] dx = {0,1,0,-1,1,-1,-1,1};
	static int[] dy = {1,0,-1,0,-1,1,-1,1};
	static int n,m;
	static int nodes = 0;
	public static boolean isValid(int x,int y)
	{
		if(x<0 || x>m-1 || y<0 || y>n-1)
			return false;
		return true;	
	}
	
	public static void dfs(int x,int y,int[][] graph,boolean[][] visited)
	{
		visited[x][y] = true;
		nodes++;
		for(int i=0;i<8;i++)
		{
			if(isValid(x+dx[i],y+dy[i]) && graph[x+dx[i]][y+dy[i]]==1 && !visited[x+dx[i]][y+dy[i]])
			{
				dfs(x+dx[i],y+dy[i],graph,visited);
			}
		}
	}
	
    public static int maxRegion(List<List<Integer>> grid) {
    // Write your code here
    	
    	m = grid.size();
    	n = grid.get(0).size();
    	int[][] graph = new int[m][n];
    	
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			graph[i][j] = grid.get(i).get(j);
    		}
    	}
    	int maxL = 0;
    	boolean visited[][] = new boolean[m][n];
    	for(int i=0;i<m;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			nodes = 0;
    			if(graph[i][j]==1 && !visited[i][j])
    			{
    				dfs(i,j,graph,visited);
    			}
    			maxL = Math.max(maxL, nodes);
    		}
    	}
    	return maxL;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                grid.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = maxRegion(grid);
        
        System.out.print(res);
        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

