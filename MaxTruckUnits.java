import java.util.*;
public class MaxTruckUnits {
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
		
		Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
		
		int result = 0;
		for(int[] pair:boxTypes)
		{
			int a = pair[0];
			int b = pair[1];
			if(a<truckSize)
			{
				result += a*b;
				truckSize -= a;
			}
			else
			{
				result += truckSize*b;
				break;
			}
		}
		
		return result;
		
	}

	public static void main(String args[]) {
		 int[][] bT = {{5,10},{2,5},{4,7},{3,9}};
		 int t = 10;
		 
		 int result = maximumUnits(bT,t);
		 
		 System.out.print(result);
	}
}
