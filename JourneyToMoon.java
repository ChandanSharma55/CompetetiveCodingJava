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

class JourneyToMoon {

	/*
	 * Complete the 'journeyToMoon' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY astronaut
	 */
	//static 
	//static  edges = new ArrayList<Integer>();
	static int count;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void dfs(int vertex, boolean[] visited) {
		visited[vertex] = true;
		//System.out.print(vertex + " ");
		ArrayList<Integer> edges = graph.get(vertex);
		for (int i = 0; i < edges.size(); i++) {
			if (!visited[edges.get(i)]) {
				count++;
				dfs(edges.get(i), visited);
			}
		}
	}

	public static int journeyToMoon(int n, List<List<Integer>> astronaut) {

		int i = 0;
		while (i++ < n) {
			graph.add(new ArrayList<Integer>());
		}
		for (List<Integer> list : astronaut) {
			graph.get(list.get(0)).add(list.get(1));
			graph.get(list.get(1)).add(list.get(0));
		}
		
		//Graph.printGraph(graph);

		boolean visited[] = new boolean[n];
		ArrayList<Integer> countEachCity = new ArrayList<Integer>();
		for (i = 0; i < n; i++) {
			if(!visited[i])
			{
				count = 0;
				dfs(i, visited);
				countEachCity.add(count+1);
			}
		}
		
		int oldValue = 0;
		int sumOfOldValues = countEachCity.get(0);
		int newValue = 0; 
		for(i=1;i<countEachCity.size();i++)
		{ 
			newValue = oldValue+(sumOfOldValues*countEachCity.get(i)); oldValue = newValue;
			sumOfOldValues += countEachCity.get(i);
		} 
		
		return newValue;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int p = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> astronaut = new ArrayList<>();

		IntStream.range(0, p).forEach(i -> {
			try {
				astronaut.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = journeyToMoon(n, astronaut);

		System.out.print("\n"+result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
