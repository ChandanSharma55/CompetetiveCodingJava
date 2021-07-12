import java.util.*;
public class KthSymbolGrammer {

	public static int flip(int value)
	{
		return (value == 0)?1:0;
	}
	
	public static int kthGrammer(int n, int k)
	{
		int mid = (int)(Math.pow(2, n-1))/2;
		if(n==1 && k==1)
			return 0;
		if(k<=mid)
		{
			return kthGrammer(n-1,k);
		}
		else
		{
			return flip(kthGrammer(n-1,k-mid));
		}
		
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int result = kthGrammer(n,k);
		System.out.print(result);
	}
}
