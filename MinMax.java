import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMax {

	// Complete the riddle function below.
	static long[] riddle(long[] a) {
		int n = a.length;
        int i = 0;
        long[] ans = new long[n];
        for (long value : a) {
            a[i++] = value;
        }
        Stack<Integer> stk = new Stack<Integer>();
        long[] leftSmallest = new long[n];
        long[] rightSmallest = new long[n];
        stk.push(n - 1);
        rightSmallest[n - 1] = n;
        for (i = n - 2; i >= 0; i--) {
            while (!stk.isEmpty() && a[stk.peek()] >= a[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                stk.push(n - 1);
                rightSmallest[i] = stk.peek() + 1;
                stk.push(i);
                continue;
            }
            rightSmallest[i] = stk.peek();
            stk.push(i);

        }
        while (!stk.isEmpty())
            stk.pop();

        stk.push(0);
        leftSmallest[0] = -1;
        for (i = 1; i < n; i++) {
            while (!stk.isEmpty() && a[stk.peek()] >= a[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                stk.push(0);
                leftSmallest[i] = stk.peek() - 1;
                stk.push(i);
                continue;
            }
            leftSmallest[i] = stk.peek();
            stk.push(i);
        }
        long[] diff = new long[n];
        for (i = 0; i < n; i++) {
            diff[i] = Math.abs(leftSmallest[i] - rightSmallest[i]) - 1;
        }
        Hashtable<Long, Long> table = new Hashtable<Long, Long>();
        for (i = 0; i < n; i++) {
            if (table.containsKey(diff[i]) && table.get(diff[i]) < a[i]) {
                table.replace(diff[i], table.get(diff[i]), a[i]);
                continue;
            } else if (table.containsKey(diff[i]) && table.get(diff[i]) >= a[i]) {
                continue;
            }
            table.put(diff[i], a[i]);
        }
        for (i = n-1; i >= 0; i--) {
            long dif = (long)(i+1);
            if (table.containsKey(dif)) {
                ans[i] = table.get(dif);
            } /*else {
                ans[i] = (ans[i + 1] > ans[i]) ? ans[i + 1] : ans[i];
            }*/
        }
        for(i=n-1;i>=0;i--)
        {
        	ans[i] = (ans[i + 1] > ans[i]) ? ans[i + 1] : ans[i];
        }
        return ans;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long[] arr = new long[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr[i] = arrItem;
		}

		long[] res = riddle(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

		scanner.close();
	}
}
