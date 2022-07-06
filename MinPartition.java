import java.util.*;
public class MinPartition {

	public static void main(String args[])
	{
		String x = "82734";
		
		int result = x.chars().max().getAsInt()-'0';
		
		System.out.print(result);
	}
}
