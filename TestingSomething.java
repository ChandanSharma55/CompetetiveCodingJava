import java.util.*;

public class TestingSomething {

	public static int solve(int n, int[] a, int l, int r) {
		
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i=l-1;i<r;i++)
		{
			ts.add(a[i]);
		}
		int tsSize = ts.size();
		int[] x = new int[tsSize];
		int i=0;
		for(int val : ts)
		{
			x[i++] = val;
		}
		return x[(int) Math.ceil((tsSize-1)/2)];
		
	}

	public static void main(String args[]) {
		int n = 6;
		int l = 3;
		int r = 3;
		int[] a = { 2, 4, 5, 3, 1, 6 };
		
		System.out.print(solve(n,a,l,r));
	}
}
