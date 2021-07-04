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

class PoisonousPlant {

	/*
	 * Complete the 'poisonousPlants' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY p as parameter.
	 */
	public static int poisonousPlants(List<Integer> p) {
		int result=0;
		Stack<Pair> stk = new Stack<Pair>();
		for(int value:p)
		{
			int day = 0;
			if(!stk.isEmpty() && value>stk.peek().value)
				day=1;
			while(!stk.isEmpty() && value<=stk.peek().value)
			{
				day = Math.max(stk.pop().day+1, day);
			}
			if(stk.isEmpty())
				day=0;
			result = Math.max(day, result);
			stk.push(new Pair(value,day));
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = poisonousPlants(p);
		System.out.print(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
