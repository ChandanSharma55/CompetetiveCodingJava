import java.util.*;

public class RegularExpressionMatchingMemoization {

	// Memoization // Bottom up
	public static boolean solve(String s, String p, int i, int j, int[][] dp) {
		if (dp[i][j] != 0) {
			return dp[i][j] == 1;
		}
		if (i >= s.length() && j >= p.length())
			return true;
		if (j >= p.length())
			return false;
		boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			boolean notTaking = solve(s, p, i, j + 2, dp);
			boolean Taking = match && solve(s, p, i + 1, j, dp);
			dp[i][j] = (notTaking || Taking) == true ? 1 : -1;
			return dp[i][j] == 1;
		} else if (match) {
			dp[i][j] = solve(s, p, i + 1, j + 1, dp) == true ? 1 : -1;
			return dp[i][j] == 1;
		}

		dp[i][j] = -1;
		return false;

	}

	public static boolean isMatch(String s, String p) {

		int[][] dp = new int[s.length() + 1][p.length() + 1];
		return solve(s, p, 0, 0, dp);

	}

	public static void main(String args[]) {
		String p = "c*a*b";
		String s = "aab";

		System.out.print(isMatch(s, p));
	}
}
