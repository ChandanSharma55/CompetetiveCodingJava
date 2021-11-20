import java.util.*;
public class BiggestNumberArray {

	
	public static void printLargest(ArrayList<String> list)
	{
		Collections.sort(list, new Comparator<String>()
		{
			@Override
			public int compare(String x,String y)
			{
				String xy = x+y;
				String yx = y+x;
				return xy.compareTo(yx)>0?-1:1;
			}
		});
	}
	
	public static void main(String args[])
	{
		
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("34");
		list.add("3");
		list.add("98");
		list.add("9");
		list.add("76");
		list.add("45");
		list.add("4");
		
		printLargest(list);
		String result = "";
		for(String value:list)
		{
			result += value;
		}
		
		System.out.print(result);
	}
}
