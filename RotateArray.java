
public class RotateArray {

	
	public static void reverse(int a[],int l,int r)
	{
		while(l<=r)
		{
			int t = a[r];
			a[r] = a[l];
			a[l] = t;
			l++;
			r--;
		}
	}
	
	public static void rotate(int a[],int k)
	{
		int n = a.length;
		k = k%n;
		//if negative k then take absolute value
		reverse(a,0,n-1);
		reverse(a,0,k-1);
		reverse(a,k,n-1);
		
	}
	
	public static void main(String args[])
	{
		int a[] = {1,2,3,4,5,6,7};
		int k = 3;
		
		rotate(a,k);
		
		for(int value:a)
		{
			System.out.print(value+" ");
		}
	}
}
