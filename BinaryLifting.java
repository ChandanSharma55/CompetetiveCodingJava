import java.util.*;
public class BinaryLifting {

	static int max = 17;
	static int n = 7;
	static int parent[] = {0,0,0,1,1,2,2};
	static int table[][];
	public static void build()
	{
		table = new int[max][n];
		
		for(int i=0;i<n;i++)
		{
			table[0][i] = parent[i];
		}
		for(int i=1;i<max;i++)
		{
			for(int j=0;j<n;j++)
			{
				table[i][j] = table[i-1][table[i-1][j]];
			}
		}
	}
	
	public static int query(int node, int k)
	{
		for(int i=0;i<max;i++)
		{
			int mask = (1<<i);
			if((k&mask) > 0)
			{
				node = table[i][node];
			}
		}
		return node;
	}
	
	public static void main(String args[])
	{
		int node = 3;
		int k = 2;
		build();
		int result = query(node,k);
		System.out.println(result);
	}
}
