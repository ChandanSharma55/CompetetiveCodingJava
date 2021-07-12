import java.util.*;

public class ArrayMountain {

	public static boolean validMountainArray(int[] a) {

		int n = a.length;
		int valley = 0;
        int change = 0;
		int plateau = 0;
		if (n <= 2)
			return false;
		for (int i = 1; i < n - 1; i++) {
			if (a[i] == a[i - 1] || a[i] == a[i + 1]) {
				plateau = 1;
				break;
			}
			if (a[i] < a[i + 1] && a[i] < a[i - 1]) {
				valley = 1;
				break;
			}
            if(a[i] > a[i + 1] && a[i] > a[i - 1])
            {
                change++;
            }
		}
		if (valley == 1 || plateau == 1)
			return false;
		else if(change == 1)
			return true;
        else
            return false;

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(validMountainArray(a));
	}
}
