import java.util.*;

public class MinimumTimeTrips {

	public static long minimumTime(int[] time, int totalTrips) {
		long lowerTime = 1;
		long higherTime = Long.MAX_VALUE;
		long midTime = lowerTime + ((higherTime-lowerTime)/2);
		long sum = 0;
		while(lowerTime < higherTime)
		{
			sum = 0;
			for(int i=0;i<time.length;i++)
			{
				if(time[i]<=t)
				{
					sum += (long)(Math.floor(t/time[i]));
				}
			}
			
		}
		
		
		return t-1;
	}

	public static void main(String args[]) {

		int time[] = {3,3,8};
		int totalTrips = 6;

		System.out.print(minimumTime(time, totalTrips));

	}
}
