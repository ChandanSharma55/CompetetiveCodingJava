import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BFSShortestReachHackerrank {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */
    public static Queue<Integer> queue = new LinkedList<Integer>();
    public static int visited[];
    public static void printGraph(List<List<Integer>> adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            StringBuilder str = new StringBuilder();
            for(Integer value : adj.get(i))
            {
                str.append(value+"--");
            }
            System.out.println(i+" ====> "+str);
        }
    }
    
    public static List<List<Integer>> createGraph(List<List<Integer>> edges, int nodes)
    {
        //List<List<Integer>> graph = new ArrayList<>(Collections.nCopies(nodes, new ArrayList<Integer>()));
    	List<List<Integer>> graph = new ArrayList<>();
    	int i=0;
    	while(i++ < nodes)
    	{
    		graph.add(new ArrayList<Integer>());
    	}
        for(List<Integer> edge : edges)
        {
        	int x,y;
        	x = edge.get(0);
        	y = edge.get(1);
            graph.get(x-1).add(y-1);
            graph.get(y-1).add(x-1);
        }
        return graph;
    }
    
    public static List<Integer> bfs(int n, int m, List<List<Integer>> systemEdges, int s) {
    // Write your code here
    
    	s -= 1;
        List<List<Integer>> graph = createGraph(systemEdges, n);
        printGraph(graph);
        visited = new int[n];
        for(int i=0;i<n;i++)
        {
            visited[i] = -1;
        }
        queue.add(s);
        visited[s] = 0;
        //int dist = 0;
        while(!queue.isEmpty())
        {    
            //dist += 6;
            int vertex = queue.poll();
            //System.out.print(vertex+" ");
            List<Integer> edges = graph.get(vertex);
            //List<Integer> edges = new ArrayList<>();
            for(int edge : edges)
            {
                if(visited[edge] == -1)
                {
                    visited[edge] = visited[vertex]+6;
                    queue.add(edge);
                }
            }
            
        }
        
        List<Integer> distList = new ArrayList<>();
        for(int value : visited)
        {
            if(value!=0)
                distList.add(value);
        }
        return distList;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = bfs(n, m, edges, s);
                
                for(int value : result)
                {
                	System.out.print(value+" ");
                }
                /*bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );*/
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
