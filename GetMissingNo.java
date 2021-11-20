import java.util.*;
public class GetMissingNo {

	public static int getMissingNo(int a[],int n)
	{
		int x = a[0];
		for(int i=1;i<n;i++)
		{
			x ^= a[i];
		}
		for(int i=1;i<=n+1;i++)
		{
			x ^= i;
		}
		return x;
	}
	
	public static void main(String args[])
    {
        int a[] = { 1, 2, 4, 5, 6 };
        int miss = getMissingNo(a, 5);
        System.out.println(miss);
    }
}
