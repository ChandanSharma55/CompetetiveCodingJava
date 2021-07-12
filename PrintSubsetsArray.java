import java.util.*;

public class PrintSubsetsArray {

	static List<List<Integer>> result = new ArrayList<>();
	public static void generate(int[] nums,List<Integer> subset, int i) {
		
		if(i == nums.length)
		{
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		
		generate(nums, subset,i+1);
		
		subset.add(nums[i]);
		generate(nums,subset,i+1);
		
		subset.remove(subset.size()-1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//List<List<Integer>> result = new ArrayList<>(); 
		generate(a, new ArrayList<>(), 0);

		
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
