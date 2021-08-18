import java.util.*;

public class NoOfBsts {

	public static int result(int n) {
		int dp[] = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			
			int l=0;
			int r=i-1;
			while(l<=i-1)
			{
				dp[i] += dp[l]*dp[r];
				l++;
				r--;
			}
		}
		return dp[n];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int nodes = sc.nextInt();
		System.out.print(result(nodes));
		sc.close();
	}

}
