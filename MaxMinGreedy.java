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

class MinMaxGreedy {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
    	
    	int n = arr.size();
    	int i=0;
    	int a[] = new int[n];
    	//int newA[] = new int[k];
    	for(int value:arr)
    		a[i++] = value;
    	
    	Arrays.sort(a);
    	int min = Integer.MAX_VALUE;
    	for(i=0;i<=n-k;i++)
    	{
    		if(a[i+k-1]-a[i]<min)
    			min = a[i+k-1]-a[i];
    	}
    	return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = maxMin(k, arr);
        System.out.print(result);
        bufferedReader.close();
        //bufferedWriter.close();
    }
}
