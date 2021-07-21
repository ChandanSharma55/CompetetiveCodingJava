import java.util.*;
//Recursive Solution
public class UniquePathsRecursive {

	static int m;
	static int n;
	public static int uniquePath(int x,int y)
	{
		if(x>m || y>n)
			return 0;
		if(x==m-1 && y==n-1)
			return 1;
		int left  = uniquePath(x,y+1);
		int right = uniquePath(x+1,y);
		return left+right;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		int result = uniquePath(0,0);
	
		System.out.print(result);
	}
}
