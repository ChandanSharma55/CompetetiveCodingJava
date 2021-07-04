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

class JackGoesToRapture {

	/*
	 * Complete the 'getCost' function below.
	 *
	 * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
	 */

	/*
	 * For the weighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the
	 * edge is <name>Weight[i].
	 *
	 */

	public static void findCost(ArrayList<ArrayList<DijkPair>> graph, int dest)
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
			if(pair.destination == dest)
				distance = pair.weight;
			ArrayList<DijkPair> pairs = graph.get(pair.destination);
			for(DijkPair edge : pairs)
			{
				if(!visited[edge.destination])
				{
					//visited[edge.destination] = true;
					int weightToAdd;
					if(edge.weight >= pair.weight)
						weightToAdd = edge.weight;
					else
						weightToAdd = pair.weight;
					queue.add(new DijkPair(edge.destination, weightToAdd));
				}
			}
			
		}
		System.out.print(distance);
	}
	
	public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		// Print your answer within the function and return nothing
		
		ArrayList<ArrayList<DijkPair>> graph = new ArrayList<>();
		int i=0;
		//Creating Graph region
		while(i++ <= gNodes)
		{
			graph.add(new ArrayList<DijkPair>());
		}
		i=0;
		while(i < gFrom.size())
		{
			graph.get(gFrom.get(i)).add(new DijkPair(gTo.get(i), gWeight.get(i)));
			graph.get(gTo.get(i)).add(new DijkPair(gFrom.get(i), gWeight.get(i)));
			i++;
		}
		//Graph Created
		
		findCost(graph, gNodes);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();
		List<Integer> gWeight = new ArrayList<>();

		IntStream.range(0, gEdges).forEach(i -> {
			try {
				String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				gFrom.add(Integer.parseInt(gFromToWeight[0]));
				gTo.add(Integer.parseInt(gFromToWeight[1]));
				gWeight.add(Integer.parseInt(gFromToWeight[2]));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		getCost(gNodes, gFrom, gTo, gWeight);

		bufferedReader.close();
	}
}
