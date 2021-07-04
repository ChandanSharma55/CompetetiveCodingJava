import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MintimeReqd {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal)
    {
        long min=Integer.MAX_VALUE;
        long max=0;
        long size=machines.length;
        for(int i=0;i<size;i++)
        {
            if(min>machines[i])
            {
                min = machines[i];
            }
            if(max<machines[i])
            {
                max = machines[i];
            }
        }
        long lowerBound = (long)((Math.ceil(goal/size))*min);
        long upperBound = (long)((Math.ceil(goal/size))*max);
        //long result=Integer.MAX_VALUE;
        while(lowerBound<=upperBound)
        {
            long midBound = lowerBound+(upperBound-lowerBound)/2;
            long sum=0L;
            for(int i=0;i<size;i++)
            {
                sum+=(long)(midBound/machines[i]);
            }
            if(sum>=goal)
            {
                upperBound = midBound-1;
            }
            else
            {
                lowerBound = midBound+1;
            }
        }
        return lowerBound;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);
        
        System.out.println(ans);
        /*bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
