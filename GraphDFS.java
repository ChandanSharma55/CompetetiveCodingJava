import java.util.*;

public class GraphDFS {

	static int nodesize;
	static boolean[] visited;
	static ArrayList<Integer> edges = new ArrayList<Integer>();

	public static void visit(int vertex, ArrayList<ArrayList<Integer>> adj) {
		edges = adj.get(vertex);
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int i = 0; i < edges.size(); i++) {
			if (!visited[edges.get(i)]) {
				visit(edges.get(i), adj);
			}
		}

	}

	public static void printDFS(int nodes, ArrayList<ArrayList<Integer>> adj) {

		nodesize = nodes;
		visited = new boolean[nodesize];
		for (int i = 0; i < nodes; i++) {
			if (!visited[i]) {
				visit(i, adj);
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
		while (i < queries) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			Graph.addEdge(adj, from, to);
			i++;
		}
		Graph.printGraph(adj);
		printDFS(v, adj);
		sc.close();
	}
}
