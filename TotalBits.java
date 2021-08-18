import java.util.*;
public class TotalBits {

	
	public static int find(int n)
	{
		if(n==0)
			return 0;
		int x=0;
		while(Math.pow(2, x) < n)
		{
			x++;
		}
		x--;
		
		return (int)(Math.pow(2,x-1)*x)+(int)(n-Math.pow(2, x)+1)+find((int)(n-Math.pow(2, x)));
	}
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(find(n));
		sc.close();
	}
}
