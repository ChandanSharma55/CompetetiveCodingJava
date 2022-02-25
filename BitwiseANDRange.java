import java.util.*;
public class BitwiseANDRange {

	public static int rangeBitwiseAnd(int left,int right)
	{
		int count = 0;
		while(left!=right)
		{
			 left = left >>> 1; // 5(101) becomes 2(10)
			 right = right >>> 1;// 7(111) becomes 3 (11)
			 count++;
		}
		return left << count;
	}
	
	public static void main(String args[])
	{
		int l = 5;
		int r = 7;
		
		System.out.print(rangeBitwiseAnd(l,r));
	}
}
