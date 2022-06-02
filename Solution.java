import java.util.*;
public class Solution {
	public static int solution(String S) {

		S += ".";
		int result = 0;
		int len = S.length();
		if (len == 2)
			return 0;
		int maxBlock = 0;
		List<Integer> blockSizes = new ArrayList<>();
		int blockSize = 1;
		for (int i = 1; i < len; i++) {
			if (S.charAt(i) == S.charAt(i - 1)) {
				blockSize++;
			} else {
				maxBlock = Math.max(maxBlock, blockSize);
				blockSizes.add(blockSize);
				blockSize = 1;
			}
		}
		
		for (int value : blockSizes) {
			result += maxBlock - value;
		}

		return result;

	}
	
	public static void main(String args[])
	{
		int result = solution("babaa");
		System.out.print(result);
	}
}
