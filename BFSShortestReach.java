import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BFSShortestReach {
	
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static int visited[];
	
	public static void printBFS(int nodes, ArrayList<ArrayList<Integer>> graph)
	{
		//Starting from 0
		queue.add(0);
		visited[0] = 0;
		int dist = 0;
		while(!queue.isEmpty())
		{	
			//dist += 6;
			int vertex = queue.poll();
			//System.out.print(vertex+" ");
			ArrayList<Integer> edges = graph.get(vertex);
			for(int edge : edges)
			{
				if(visited[edge] == -1)
				{
					visited[edge] = visited[vertex]+6;
					queue.add(edge);
				}
			}
			
		}
		
		for(int value : visited)
		{
			System.out.print(value+" ");
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int queries = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int i = 0;
		while (i < v) {
			adj.add(new ArrayList<Integer>());
			i++;
		}
		visited = new int[v];
		for(i=0;i<v;i++)
		{
			visited[i] = -1;
		}
		i = 0;
		while (i < queries) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			Graph.addEdge(adj, from, to);
			i++;
		}
		Graph.printGraph(adj);
		printBFS(v, adj);
		sc.close();
	}

}
