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

class LuckBalance {

	/*
	 * Complete the 'luckBalance' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. 2D_INTEGER_ARRAY contests
	 */

	public static int luckBalance(int k, List<List<Integer>> contests) {
		
		List<Integer> ones = new ArrayList<Integer>();
		int totalSum = 0;
		for(List<Integer> value : contests)
		{
			if(value.get(1) == 1)
				ones.add(value.get(0));
			totalSum+=value.get(0);
		}
		int x = ones.size();
		int[] arr = new int[x];
		int i=0;
		for(int value:ones)
		{
			arr[i++] = value;
		}
		Arrays.sort(arr);
		i=1;
		while(i<=x-k)
		{
			totalSum-=arr[i-1]*2;
			i++;
		}
		return totalSum;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> contests = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				contests.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = luckBalance(k, contests);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
