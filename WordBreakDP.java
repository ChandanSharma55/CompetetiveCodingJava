import java.util.*;
public class WordBreakDP {

	public static boolean wordBreak(String s,List<String> w)
	{
		int n = s.length();
		int dp[] = new int[n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				String word = s.substring(j,i+1);
				if(w.contains(word))
				{
					if(j>0)
						dp[i] += dp[j-1];
					else
						dp[i] = 1;
				}
			}
		}
		return dp[n-1]>0;
	}
	
	public static void main(String args[])
	{
		String s = "mypenmy";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("my");
		wordDict.add("pen");
		wordDict.add("mypen");
		
		System.out.print(wordBreak(s,wordDict));
	}
}
