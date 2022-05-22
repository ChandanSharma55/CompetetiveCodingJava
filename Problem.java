/*Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false.

Examples: 
 

Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
Output: 12, 3, 9 
Explanation: There is a triplet (12, 3 and 9) present 
in the array whose sum is 24. 
Input: array = {1, 2, 3, 4, 5}, sum = 9 
Output: 5, 3, 1 
Explanation: There is a triplet (5, 3 and 1) present 
in the array whose sum is 9.*/

                       //        hashtable =  3, 4, 1, 6, 
// a + b + c = 24
// a + b = 24-c // c=12
//a + b = 12
//a = 12 - b
import java.util.*;
public class Problem
{
	public static boolean findTriple(int[] arr, int sum)
	{
		HashSet<Integer> set = new HashSet<>();
		int a,b,c;
		for(int j=0;j<arr.length;j++)
		{
			int currTarget = sum - arr[j];//
			for(int i=0;i<arr.length;i++)
			{
				if(i!=j)
				{
					if(set.contains(currTarget - arr[i]))//
					{
						return true;
					}
					else
					{
						set.add(arr[i]);
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		int[] a = {3,3,3,3};
		int sum = 9;
		System.out.print(findTriple(a, sum));
	}
}
