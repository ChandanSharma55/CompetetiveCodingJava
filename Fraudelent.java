import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Fraudelent {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */
     
    static double findMedian(int[] freq, int d)
    {
        double median = 0.0;
        if(d%2 != 0)
        {
            int count=0;
            for(int i=0;i<freq.length;i++)
            {
                count+=freq[i];
                if(count >= ((d+1)/2))
                {
                    median = i;
                    break;
                }
            }
        }
        else
        {
            double v1,v2;
            v1=v2=0.0;
            int count=0;
            for(int i=0;i<freq.length;i++)
            {
                count+=freq[i];
                if(count >= (d/2) && v1==0)
                {
                    v1=(double)(i);
                }
                if(count >= ((d/2)+1) && v2==0)
                {
                    v2=(double)(i);
                    break;
                }
            }
            median = (v1+v2)/2;
        }
        return median;
        
    } 
    
    static int activityNotifications(int[] expenditure, int d)
    {
        int max = 0;
        int notif = 0;
        int n = expenditure.length;
        for(int i=0;i<n;i++)
        {
            max = (max<expenditure[i])?expenditure[i]:max;
        }
        int[] freq = new int[max+1];
        for(int i=0;i<d;i++)
        {
            freq[expenditure[i]]++;
        }
        
        for(int i=d;i<n;i++)
        {
            double median = findMedian(freq,d);
            if(expenditure[i]>=median*2)
            {
                notif++;
            }
            freq[expenditure[i]]++;
            freq[expenditure[i-d]]--;
        }
        
        return notif;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        int[] expenditureArr = new int[expenditure.size()];
        int i=0;
        for(int value:expenditure)
        {
            expenditureArr[i++] = value;
        }
        int result = activityNotifications(expenditureArr, d);
        
        System.out.print(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
