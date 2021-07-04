import java.util.*;

public class Dijkstra {

	
	public static int giveShortestDistance(int dest, ArrayList<ArrayList<DijkPair>> graph)
	{
		PriorityQueue<DijkPair> queue = new PriorityQueue<DijkPair>();
		boolean visited[] = new boolean[dest+1];
		queue.add(new DijkPair(1,0));
		//visited[1] = true;
		int distance = -1;
		while(!queue.isEmpty())
		{
			DijkPair pair = queue.remove();
			//System.out.print(vertex+" ");
			if(visited[pair.destination])
				continue;
			//System.out.print(pair.destination+" ");
			visited[pair.destination] = true;
			distance = pair.weight;
			ArrayList<DijkPair> pairs = graph.get(pair.destination);
			for(DijkPair edge : pairs)
			{
				if(!visited[edge.destination])
				{
					//visited[edge.destination] = true;
					queue.add(new DijkPair(edge.destination, edge.weight+pair.weight));
				}
			}
			
		}
		return distance;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		ArrayList<ArrayList<DijkPair>> graph = new ArrayList<>();
		int i = 0;
		while(i++ <= nodes)
		{
			graph.add(new ArrayList<DijkPair>());
		}
		i=0;
		while(i++ < edges)
		{
			int f,t,w;
			f = sc.nextInt();
			t = sc.nextInt();
			w = sc.nextInt();
			graph.get(f).add(new DijkPair(t,w));
		}
		int result = giveShortestDistance(nodes, graph);
		System.out.print("\n"+result);
	}
}
