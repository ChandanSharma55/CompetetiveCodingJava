import java.util.*;

public class MedianSortedArrays {
	
	public static double findMedian(int a[],int b[])
	{
		if(a.length>b.length)
			return findMedian(b,a);
		
		int n1 = a.length;
		int n2 = b.length;
		
		int l=0,h=n1;
		while(l<=h)
		{
			int cut1 = l+(h-l)/2;
			int cut2 = (n1+n2+1)/2 - cut1;
			
			int left1 = cut1==0?Integer.MIN_VALUE:a[cut1-1];
			int right1 = cut1==n1?Integer.MAX_VALUE:a[cut1];
			int left2 = cut2==0?Integer.MIN_VALUE:b[cut2-1];
			int right2 = cut2==n2?Integer.MAX_VALUE:b[cut2];
			
			if(left1 <= right2 && left2 <= right1)
			{
				if((n1+n2)%2==0)
					return (Math.max(left1, left2)+Math.min(right1, right2))/2.0;
				else
					return Math.max(left1, left2);
			}
			else if(left1>right2)
			{
				h=cut1-1;
			}
			else
			{
				l=cut1+1;
			}
		}
		return 0.0;
	}
	public static void main(String args[]) {
		int a[] = {1,2};
		int b[] = {3,4};
		double median = 0.0;
		median = findMedian(a, b);

		System.out.print(median);
	}
}
