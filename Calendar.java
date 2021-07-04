import java.util.*;
class Calendar {

    public Calendar()
    {
        
    }
    static ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(1,-1));
    public static boolean book(int start, int end)
    {
        int n = list.size();
        //Collections.sort();
        if(list.get(n-1)>start)
            return false;
        else
        {
            list.add(end);
            if(list.get(n-1)<list.get(n-2))
            {
                int t = list.get(n-1);
                list.set(n-1,list.get(n-2));
                list.set(n-2,t);
            }
            return true;
        }
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int start, end;
    	int t = 5;
    	while(t!=0)
    	{
	    	start = sc.nextInt();
	    	end = sc.nextInt();
	    	boolean result = book(start,end);
	    	System.out.print(result);
	    	t--;
    	}
    	sc.close();
    }

}
