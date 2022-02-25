import java.util.*;
import java.io.*;
public class NumDecodings {

	public static int numDecodings(String s) {

		int n = s.length();
		
		int[] dp = new int[n];
		if(s.charAt(0)=='0')
			return 0;
		dp[0] = 1;
		
		for(int i=1;i<n;i++)
		{
			int dd = Integer.parseInt(s.substring(i-1, i+1));
			int sd = Integer.parseInt(s.substring(i, i+1));
			
			if(sd > 0)
				dp[i] += dp[i-1];
			if(dd<=26 && dd>=10)
				dp[i] += i>=2?dp[i-2]:1;
				
		}
		return dp[n-1];
	}

	public static void main(String args[]) {
		
		String s = "26";
		System.out.print(numDecodings(s));
	}
}
