import java.util.*;

public class NextGreaterPermutation {

	public static void nextGreaterPermutation(int[] a) {

		int n = a.length;
		int index1 = 0;
		int index2 = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (i < n - 1 && a[i] < a[i + 1]) {
				index1 = i;
				break;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] > a[index1]) {
				index2 = i;
				break;
			}
		}

		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
		if(index1 == 0 && index2 == 0)
		{
			Arrays.sort(a);
			return;
		}
		Arrays.sort(a, index1 + 1, a.length);

	}

	public static void main(String args[]) {
		int[] a = { 3, 2, 1 };
		nextGreaterPermutation(a);
		for (int value : a) {
			System.out.print(value + " ");
		}
	}
}
