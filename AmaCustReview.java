import java.util.*;

public class AmaCustReview {

	public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
		
		List<List<String>> result = new ArrayList<>();
		
		for(int i=1;i<customerQuery.length();i++)
		{
			String check = customerQuery.substring(0,i+1).toLowerCase();
			
			List<String> temp = new ArrayList<>();
			
			for(String value:repository)
			{
				if(value.toLowerCase().startsWith(check))
				{
					temp.add(value.toLowerCase());
				}
			}
			Collections.sort(temp);
			List<String> tempResult = new ArrayList<>();
			for(int j=0;j<=2 && j<temp.size();j++)
			{
				tempResult.add(temp.get(j));
			}
			result.add(tempResult);
		}
		return result;
	}

	public static void main(String args[]) {
		List<String> repo = new ArrayList<>();
		repo.add("bags");
		repo.add("baggage");
		repo.add("banner");
		repo.add("box");
		repo.add("cloths");
		String query = "bags";

		List<List<String>> result = searchSuggestions(repo, query);
		
		for(List<String> list : result)
		{
			for(String value : list)
			{
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
}
