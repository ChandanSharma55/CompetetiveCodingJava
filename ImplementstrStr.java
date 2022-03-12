import java.util.*;

public class ImplementstrStr {

	public static int strStr(String haystack, String needle) {

		int i = 0;
		int j = needle.length();
		
		while(j<=haystack.length())
		{
			if(haystack.substring(i, j).equals(needle))
				return i;
			i++;
			j++;
		}
		return -1;
	}

	public static void main(String args[]) {
		
		System.out.print(strStr("hello","ll"));
	}
}
