public class LongestConsecutiveOne {

	
	public static int find(int x)
	{
		int count = 0;
		while(x!=0)
		{
			x = (x & (x<<1));
			count++;
		}
		
		return count;
	}
	
	public static void main(String args[])
	{
		int x = 222;
		
		System.out.print(find(x));
	}
}
