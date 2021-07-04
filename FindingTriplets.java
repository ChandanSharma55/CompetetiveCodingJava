import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindingTriplets
{

    public static int Partition(int[] a, int start, int end) {
        int pValue = a[end];
        int pIndex = start;
        for (int i = start; i <= end; i++) {
            if (a[i] <= pValue) {
                int t = a[pIndex];
                a[pIndex] = a[i];
                a[i] = t;
                pIndex++;
            }
        }
        return pIndex - 1;
    }

    public static int[] QuicksortAlgo(int[] a, int left, int right) {
        if (left < right) {
            int pIndex = Partition(a, left, right);
            QuicksortAlgo(a, left, pIndex - 1);
            QuicksortAlgo(a, pIndex + 1, right);
        }
        return a;

    }

    static int binarySearchToGetNumberLessThanElement(int a[], int k) {
        int end = a.length - 1;
        int beg = 0;
        int mid = (beg + end) / 2;
        int index=-1;
        while (beg <= end) {
            mid = beg + ((end - beg) / 2);
            if(a[mid]<=k)
            {
                index = mid;
                beg=mid+1;
            }
            if(a[mid]>k)
            {
                end=mid-1;
            }
        }
        index = index + 1;
        return index;

    }

    public static int[] RemoveDuplicate(int[] x)
    {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int value:x)
        {
            set.add(value);
        } 
        int[] xNew = new int[set.size()];
        int i = 0;
        for(int value:set)
        {
            xNew[i++] = value;
        }
       
        return xNew;
    }
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c)
    {
        long count = 0;
        int aNew[] = RemoveDuplicate(a);
        int bNew[] = RemoveDuplicate(b);
        int cNew[] = RemoveDuplicate(c);
        int la = aNew.length;
        int lb = bNew.length;
        int lc = cNew.length;
        int x[] =  QuicksortAlgo(aNew,0,la-1);
        int y[] = QuicksortAlgo(cNew,0,lc-1);
        for(int i=0;i<lb;i++)
        {
            int left = binarySearchToGetNumberLessThanElement(x,bNew[i]);
            int right = binarySearchToGetNumberLessThanElement(y,bNew[i]);
            long pairs = left*right;
            count+=pairs;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     
        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
        
        System.out.print(ans);
        
        scanner.close();
    }
}
