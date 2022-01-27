import java.util.*;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> w, int index) {
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

	public static boolean wordBreak(String s, List<String> w) {

		return wordBreak(s, w, 0);

	}

	public static void main(String args[]) {
		String s = "aaaaaaa";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("aaaa");
		wordDict.add("aaa");

		System.out.print(wordBreak(s, wordDict));
	}
}
