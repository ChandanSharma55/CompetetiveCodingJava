import java.util.*;
public class TowerOfHanoi {

	
	public static void toh(int n, char a, char b, char c)
	{
		if(n==1)
		{
			System.out.println("Move "+n+" from "+a+" to "+c);
			return;
		}
		toh(n-1,a,c,b);
		System.out.println("Move "+n+" from "+a+" to "+c);
		toh(n-1,b,a,c);
		return;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char a = 'A';
		char b = 'B';
		char c = 'C';
		toh(n,a,b,c);
	}
}
