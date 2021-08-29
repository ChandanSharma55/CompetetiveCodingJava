import java.util.*;
public class TwoPowerLessThanNumber {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int res = 1;
		for(int i=0;i<8*Integer.BYTES;i++)
		{
			int curr = 1 << i;
			
			if(curr >= n)
				break;
			res = curr;
		}
		System.out.print(res);
	}
}
