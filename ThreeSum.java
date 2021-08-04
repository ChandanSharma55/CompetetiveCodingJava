import java.util.*;

public class ThreeSum {

	// keep 1 fix and then find the other two as 2 sum problem
	// sort(nlogn)
	// two pointers, high--, low++ till value found
	// a+b+c = 0 can be written as b+c = -a
	public static List<List<Integer>> find3Sum(int a[]) {
		List<List<Integer>> result = new ArrayList<>();
		int l = a.length;
		Arrays.sort(a);
		for (int i = 0; i < l; i++) {
			if(i==0 || (i>0 && a[i]!=a[i-1])) {
			int x = a[i];
			int toFind = -x;
			int low = i + 1;
			int high = l - 1;
			while (low < high) {
				if (a[low] + a[high] < toFind) {
					low++;
				}
				else if(a[low]+a[high] > toFind)
				{
					high--;
				}
				else
				{
					List<Integer> addList = new ArrayList<>();
					addList.add(x);
					addList.add(a[low]);
					addList.add(a[high]);
					result.add(addList);
					low++;
					high--;
					while(a[low]==a[low-1])
						low++;
					while(a[high]==a[high+1])
						high--;
				}
			}
			}
		}

		return result;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		List<List<Integer>> result = find3Sum(a);

		for (List<Integer> value : result) {

			for (int v : value) {
				System.out.print(v + " ");
			}
			System.out.print("\n");
		}

		sc.close();
	}
}
