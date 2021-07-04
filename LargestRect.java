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

class LargestRect {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> height)
    {
    	int n = height.size();
        int[] h = new int[n];
        int i=0;
        long area = 0;
        for(int value:height)
        {
        	h[i++] = value;
        }
        
        Stack<Integer> stk = new Stack<Integer>();
        
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];
        stk.push(n-1);
        rightSmallest[n-1] = n;
        
        for(i=n-2;i>=0;i--)
        {
        	while(!stk.isEmpty() && h[stk.peek()] >= h[i])
        	{
        		stk.pop();
        	}
        	if(stk.isEmpty())
        	{
        		stk.push(n-1);
        		rightSmallest[i] = stk.peek()+1;
        		stk.push(i);
        		continue;
        	}
        	rightSmallest[i] = stk.peek();
        	stk.push(i);
        	
        }
        
        while(!stk.isEmpty())
        	stk.pop();
        
        stk.push(0);
        leftSmallest[0] = -1;
        
        for(i=1;i<n;i++)
        {
        	while(!stk.isEmpty() && h[stk.peek()] >= h[i])
        	{
        		stk.pop();
        	}
        	if(stk.isEmpty())
        	{
        		stk.push(0);
        		leftSmallest[i] = stk.peek()-1;
        		stk.push(i);
        		continue;
        	}
        	leftSmallest[i] = stk.peek();
        	stk.push(i);
        	
        }
        int[] diff = new int[n];
        for(i=0;i<n;i++)
        {
        	diff[i] = Math.abs(leftSmallest[i]-rightSmallest[i]) - 1;
        	if(area < (diff[i]*h[i]))
        		area = diff[i]*h[i];
        }
        return area;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = largestRectangle(h);
        
        System.out.println(result);
        
    }
}
