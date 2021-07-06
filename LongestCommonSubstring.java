import java.util.*;
public class LongestCommonSubstring {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int m = a.length();
		int n = b.length();
		
		int t[][] = new int[m+1][n+1];
		
		for(int i=0;i<m+1;i++)
		{
			t[i][0] = 0;
		}
		for(int j=0;j<n+1;j++)
		{
			t[0][j] = 0;
		}
		StringBuilder str = new StringBuilder();
		int lcs=0;
		int x=0,y=0;
		for(int i=1;i<m+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
				{
					t[i][j] = 1+t[i-1][j-1];
					if(lcs < t[i][j])
					{
						lcs = t[i][j];
						x=i;
						y=j;
					}
				}
				else
				{
					t[i][j] = 0;
				}
			}
		}
		int i=x;
		int j=y;
		while(i>0 && j>0)
		{
			if(a.charAt(i-1) == b.charAt(j-1))
				str.append(a.charAt(i-1));
			i--;
			j--;
			
		}
		
		String rev = "";
		for (i = lcs-1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		
		System.out.print("Common Length-->"+lcs+" Common String-->"+rev);
		
	}

}
