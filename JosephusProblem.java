import java.util.*;

public class JosephusProblem {

	public static int JPRecursion(int n, int k) {

		if (n == 1)
			return 0;
		return ((JPRecursion(n - 1, k) + k) % n);

	}

	public static int JPLoop(int n, int k) {
		
		int index=0;
		
		for(int i=2;i<n+1;i++)
		{
			index = (index+k)%i;
		}
		return index;
	}

	public static void main(String args[]) {
		int n = 7;
		int k = 4;

		int a = JPRecursion(n, k);
		int b = JPLoop(n, k);

		System.out.print(a + "   " + b);
	}
}
