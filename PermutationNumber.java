import java.util.*;

public class PermutationNumber {

	//static List<List<Integer>> result = new ArrayList<>();

	public static void permute(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {
		
		if(permutation.size() == nums.length)
		{
			result.add(new ArrayList<>(permutation));
			return;
		}
		
		for(int i =0;i< nums.length;i++)
		{
			if(used[i])
				continue;
			used[i] = true;
			permutation.add(nums[i]);
			permute(nums,used,permutation,result);
			used[i] = false;
			permutation.remove(permutation.size() - 1);
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		List<List<Integer>> result = new ArrayList<>();
		permute(a, new boolean[n], new ArrayList<Integer>(), result);

		
		for(List<Integer> list : result)
		{
			int c=0;
			while(c<list.size())
			{
				System.out.print(list.get(c)+" ");
				c++;
			}
			System.out.println();
		}
		
		sc.close();
	}
}
