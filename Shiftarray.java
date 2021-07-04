/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
class Shiftarray {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int newIndex = (int)((i+k)%n);
            a[newIndex] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }

        // Write your code here

    }
}
