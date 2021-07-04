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

public class MaximumSubarraySubsequence {
	
	public static int kadaneMaxSubarray(List<Integer> list)
	{
		int max_current;
		int max_global;
		max_current = max_global = list.get(0);
		for(int i=1;i<list.size();i++)
		{
			int value = list.get(i);
			max_current = ((max_current+value)>value)?max_current+value:value;
			if(max_current>max_global)
				max_global = max_current;
		}
		if(max_global < 0)
			return -1;
		return max_global;
	}

	public static List<Integer> maxSubarray(List<Integer> arr) {
		List<Integer> returnList = new ArrayList<Integer>();
		if(arr.size() == 1)
		{
			returnList.add(arr.get(0));
			returnList.add(arr.get(0));
			return returnList;
		}
		returnList.add(kadaneMaxSubarray(arr));
		int subMax=0;
		for(int value:arr)
		{
			if(value>0)
				subMax+=value;
		}
		subMax = (subMax<=0)?-1:subMax;
		returnList.add(subMax);
		return returnList;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				List<Integer> result = maxSubarray(arr);

				System.out.print(result.stream().map(Object::toString).collect(joining(" ")) + "\n");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
