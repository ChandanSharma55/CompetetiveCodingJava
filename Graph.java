import java.util.*;
public class Graph
{

	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int e)
	{
		adj.get(v).add(e);
	}
	
	public static void printGraph(ArrayList<ArrayList<Integer>> adj)
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
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int v=sc.nextInt();
		ArrayList<ArrayList<Integer>> AdjacencyList = new ArrayList<ArrayList<Integer>>();
		int i=0;
		while(i<v)
		{
			AdjacencyList.add(new ArrayList<Integer>());
			i++;
		}
		
		addEdge(AdjacencyList, 0, 1);
		addEdge(AdjacencyList, 0, 4);
		addEdge(AdjacencyList, 1, 0);
		addEdge(AdjacencyList, 1, 2);
		addEdge(AdjacencyList, 1, 3);
		addEdge(AdjacencyList, 1, 4);
		addEdge(AdjacencyList, 2, 1);
		addEdge(AdjacencyList, 2, 3);
		addEdge(AdjacencyList, 3, 1);
		addEdge(AdjacencyList, 3, 2);
		addEdge(AdjacencyList, 3, 4);
		addEdge(AdjacencyList, 4, 1);
		addEdge(AdjacencyList, 4, 0);
		addEdge(AdjacencyList, 4, 3);
		printGraph(AdjacencyList);
	}
}
