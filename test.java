import java.util.*;

public class test {

	public static List<String> getThread(String message) {
		String[] splittedString = message.split(" ");
		int limit = 40;
		List<String> result = new ArrayList<>();
		String temp = splittedString[0]+" ";
		for(int i=1;i<splittedString.length;i++)
		{
			String value = splittedString[i];
			if(temp.length()+value.length() <= limit && temp.charAt(temp.length()-2) != '.')
			{
				temp += value+" ";
			}
			else
			{
				result.add(temp.trim());
				temp = value+" ";
			}
		}
		result.add(temp.trim());
		return result;
	}

	public static void main(String args[]) {
		List<String> result = getThread("My mama always said life was like a box of chocolates. You never know what you are gonna get.");
		
		for(String value:result)
		{
			System.out.println(value);
		}
	}

}
