import java.util.*;
public class PrisonCellAfterNdays {

	
	public static int[] getNext(int[] cells)
    {
        int[] next = new int[cells.length];
        for(int i=0;i<cells.length;i++)
        {
            if(i==0 || i==cells.length-1)
            {
                next[i] = 0;
            }
            else
            {
                next[i] = cells[i-1] == cells[i+1]?1:0;
            }
        }
        return next;
    }
	
	public static int[] prisonAfterNDays(int[] cells, int n)
	{
		 Set<String> set = new HashSet<>();
	        boolean hasCycle = false;
	        int days = 0;
	        
	        for(int i=0;i<n;i++)
	        {
	            int next[] = getNext(cells);
	            
	            String str = Arrays.toString(next);
	            if(!set.contains(str))
	            {
	                set.add(str);
	                days++;
	            }
	            else
	            {
	                hasCycle = true;
	                break;
	            }
	            cells = next;
	        }
	        
	        if(hasCycle)
	        {
	            n %= days;
	            for(int i=0;i<n;i++)
	            {
	                cells = getNext(cells);
	            }
	        }
	        return cells;
	}
	
	public static void main(String args[])
	{
		int a[] = {0,1,0,1,1,0,0,1};
		int n = 10000000;
		
		int result[] = prisonAfterNDays(a,n);
		
		for(int value:result)
		{
			System.out.print(value+" ");
		}
	}
}
