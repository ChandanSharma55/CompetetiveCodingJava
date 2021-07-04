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

class MSCountInversions {

	/*
	 * Complete the 'countInversions' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */
	public static long steps = 0L;

	public static void Merge(int[] a, int l, int m, int r) {
		int[] helper = new int[a.length];
		for (int i = l; i <= r; i++) {
			helper[i] = a[i];
		}

		int curr = l;
		int left = l;
		int right = m + 1;

		while (left <= m && right <= r) {
			if (helper[left] <= helper[right]) {
				a[curr++] = helper[left++];
			} else {
				
				steps += m + 1 - left;
				a[curr++] = helper[right++];
			}
		}

		
		while (left <= m) {
			a[curr++] = helper[left++];
		}
	}

	public static void MergeSort(int[] a, int l, int r) {
		// int n = a.length;
		if (l < r) {
			int m = l + (r - l) / 2;

			MergeSort(a, l, m);
			MergeSort(a, m + 1, r);
			Merge(a, l, m, r);
		}

	}

	public static long countInversions(List<Integer> arr) {
		int[] a = new int[arr.size()];
		int i = 0;
		for (int value : arr) {
			a[i++] = value;
		}
		MergeSort(a, 0, a.length-1);
		return steps;
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

				long result = countInversions(arr);

				System.out.println(result);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
