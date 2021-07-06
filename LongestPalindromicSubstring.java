import java.util.Scanner;
public class LongestPalindromicSubstring {

	public static String longestPSubstrings(String s)
	{
		int n = s.length();
		boolean t[][] = new boolean[n][n];
		int len = 0;
		int x=0,y=0;
		for(int g=0;g<n;g++)
		{
			for(int i=0, j=g; j<n ;i++,j++)
			{
				if(g==0)
					t[i][j] = true;
				else if(g==1)
				{
					if(s.charAt(i) == s.charAt(j))
						t[i][j] = true;
					else
						t[i][j] = false;
				}
				else
				{
					if(s.charAt(i) == s.charAt(j) && t[i+1][j-1])
						t[i][j] = true;
					else
						t[i][j] = false;
				}
				if(t[i][j])
				{
					len = g+1;
					x=i;
					y=j;
				}
			}
		}
		
		return s.substring(x,y+1);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String result = longestPSubstrings(s);
		
		System.out.println(result);
		
	}
}
