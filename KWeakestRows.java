import java.util.*;

public class KWeakestRows {

	private static class Pair
	{
		int pos;
		int val;
		Pair(int pos,int val)
		{
			this.pos = pos;
			this.val = val;
		}
	}
	
	public static int[] kWeakestRows(int[][] mat, int k) {
		
		int[] a = new int[mat.length];
		
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(mat[i][j]==1)
					a[i]++;
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>()
		{
			@Override
			public int compare(Pair a,Pair b)
			{
				if(a.val!=b.val)
					return a.val-b.val;
				else
					return a.pos-b.pos;
			}
		});
		for(int i=0;i<a.length;i++)
		{
			pq.add(new Pair(i,a[i]));
		}
		int[] result = new int[k];
		for(int i=0;i<k;i++)
		{
			result[i] = pq.poll().pos;
		}
		return result;
	}

	public static void main(String args[]) {

		int mat[][] = {{1,1,0,0,0},
					   {1,1,1,1,0},
					   {1,0,0,0,0},
					   {1,1,1,0,0},
					   {1,1,1,1,1}};
		int k = 3;
		
		int[] result = kWeakestRows(mat,k);
		for(int value:result)
		{
			System.out.print(value+" ");
		}
	}

}
