import java.util.*;
public class AmaFreshPromo {

	public static int foo(List<String> codeList, List<String> shoppingCart) {
		// Write your code here

		int startingIndexCode = 0;
		int startingIndexCart = 0;
		for (int i = 0; i < codeList.size(); i++) {
			if (!codeList.get(i).equals("anything")) {
				startingIndexCode = i;
				break;
			}
		}
		for (int i = 0; i < shoppingCart.size(); i++) {
			if (shoppingCart.get(i).equals(codeList.get(startingIndexCode))) {
				startingIndexCart = i;
				break;
			}
		}
		int i = startingIndexCode, j = startingIndexCart;
		while (i < codeList.size() && j < shoppingCart.size()) {
			if (codeList.get(i).equals(shoppingCart.get(j)) || codeList.get(i).equals("anything")) {
				i++;
				j++;
			} else {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String args[])
	{
		List<String> codeList = new ArrayList<String>(Arrays.asList("orange","apple","apple","banana","orange","apple","banana"));
		List<String> shoppingCart = new ArrayList<String>(Arrays.asList("orange","apple","apple","banana","orange","apple","banana"));
		
		System.out.print(foo(codeList,shoppingCart));
	}

}
