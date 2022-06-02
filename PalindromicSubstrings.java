import java.util.*;
public class PalindromicSubstrings {
	public static int countSubstrings(String s) {

		int l = s.length();
		int dp[][] = new int[l][l];

		
		for(int g=0;g<l;g++)
		{
			for(int i=0,j=g;j<l;i++,j++)
			{
				if(g==0)
				{
					dp[i][j] = 1;
				}
				else if(g==1)
				{
					if(s.charAt(i)==s.charAt(j))
						dp[i][j] = 1;
				}
				else
				{
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
						dp[i][j] = 1;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (dp[i][j] == 1)
					result++;
			}
		}

		return result;
	}
	
	public static void main(String args[])
	{
		String s = "aaaaa";
		int result = countSubstrings(s);
		System.out.print(result);
	}
}
