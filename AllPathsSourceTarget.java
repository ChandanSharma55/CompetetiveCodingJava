import java.util.*;

public class AllPathsSourceTarget {

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		
		dfs(graph,result,path,0);
		
		return result;
	}
	
	public static void dfs(int[][] graph,List<List<Integer>> result,List<Integer> path,int source)
	{
		path.add(source);
		if(source == graph.length-1)
			result.add(new ArrayList<>(path));
		else
		{
			for(int i:graph[source])
			{
				dfs(graph,result,path,i);
			}
		}
		path.remove(path.size()-1);
	}

	public static void main(String args[]) {
		int grid[][] = { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> result = allPathsSourceTarget(grid);
		
		for(List<Integer> values : result)
		{
			for(int value:values)
			{
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
}
