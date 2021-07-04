import java.util.*;
public class GraphBFS {
	
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static boolean visited[];
	
	public static void printBFS(int nodes, ArrayList<ArrayList<Integer>> graph)
	{
		queue.add(0);
		visited[0] = true;
		while(!queue.isEmpty())
		{
			int vertex = queue.poll();
			System.out.print(vertex+" ");
			ArrayList<Integer> edges = graph.get(vertex);
			for(int edge : edges)
			{
				if(!visited[edge])
				{
					visited[edge] = true;
					queue.add(edge);
				}
			}
			
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
		i = 0;
		visited = new boolean[v];
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
