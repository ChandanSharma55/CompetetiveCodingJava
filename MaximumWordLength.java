import java.util.*;
public class MaximumWordLength {

	
	public static int maxProduct(String[] words)
	{
		int n = words.length;
		int[] state = new int[n];
		for(int i=0;i<n;i++)
		{
			state[i] = getState(words[i]);
		}
		
		int maxProduct = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((state[i] & state[j]) == 0)
				{
					maxProduct = Math.max(maxProduct, words[i].length()*words[j].length());
				}
			}
		}
		return maxProduct;
	}
	
	public static int getState(String word)
	{
		int state = 0;
		for(char c:word.toCharArray())
		{
			int index = c-'a';
			state |= 1 << index; 
		}
		return state;
	}
	
	public static void main(String args[])
	{
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		int result = maxProduct(words);
		
		System.out.print(result);
	}
}
