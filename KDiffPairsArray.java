import java.util.*;

public class KDiffPairsArray {

	public static int findPairs(int[] nums, int k) {
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int value:nums)
		{
			map.put(value, map.getOrDefault(value, 0)+1);
		}
		int result = 0;
		for(int i:map.keySet())
		{
			if((k>0 && (map.containsKey(i+k))) || (k==0 && map.get(i)>1))
			{
				result++;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 2;

		System.out.print(findPairs(nums, k));
	}
}
