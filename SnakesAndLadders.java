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

class SnakesAndLadders {

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

	public static void updateGraphWithLaddersSnakes(ArrayList<ArrayList<Integer>> graph, List<List<Integer>> update)
	{
		for(int i=0;i<update.size();i++)
		{
			int v1 = update.get(i).get(0);
			int v2 = update.get(i).get(1);
			graph.set(v1, new ArrayList<Integer>());
			for(int j=v1-1;j>=v1-6 && j>=1;j--)
			{
				if(!graph.get(j).isEmpty())
					graph.get(j).set(v1-1-j, v2);
			}
		}
	}
	
    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
    // Write your code here
    	
    	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    	int i=0,j=0;
    	while(i++ <= 100)
    	{
    		graph.add(new ArrayList<Integer>());
    	}
    	
    	for(i=1;i<=100;i++)
    	{
    		for(j=i+1;j<=i+6 && j<=100;j++)
    		{
    			graph.get(i).add(j);
    		}
    	}
    	
    	updateGraphWithLaddersSnakes(graph, ladders);
    	updateGraphWithLaddersSnakes(graph, snakes);
    	
    	//Graph.printGraph(graph);
    	//bfs
    	Queue<Integer> queue = new LinkedList<Integer>();
    	boolean visited[] = new boolean[101];
    	int dist[] = new int[101];
    	queue.add(1);
		visited[1] = true;
		dist[1] = 0;
		while(!queue.isEmpty())
		{
			int vertex = queue.poll();
			ArrayList<Integer> edges = graph.get(vertex);
			for(int edge : edges)
			{
				if(!visited[edge])
				{
					visited[edge] = true;
					dist[edge] = dist[vertex]+1;
					queue.add(edge);
				}
			}
			
		}
    	
    	return dist[100];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = quickestWayUp(ladders, snakes);
                System.out.println(result);
                //bufferedWriter.write(String.valueOf(result));
                //bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
