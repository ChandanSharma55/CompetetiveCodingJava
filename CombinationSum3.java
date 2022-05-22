import java.util.*;
public class CombinationSum3 {

	static List<List<Integer>> result = new ArrayList<>();
    public static  List<List<Integer>> combinationSum3(int k, int n)
    {
        combinationSum3(k,n,new ArrayList<Integer>(),0,0,1);
        return result;
    }
    
    public static void combinationSum3(int k,int n,List<Integer> subset,int index,int sum,int start)
    {
        if(subset.size()==k && sum==n)
        {
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        if(subset.size()==k)
            return;
        for(int i=start;i<=9;i++)
        {
            if(!subset.contains(i))
            {
                sum+=i;
                subset.add(i);
                combinationSum3(k,n,subset,index+1,sum,i+1);
                sum-=i;
                subset.remove(subset.size()-1);
            }
        }
    }
    
    public static void main(String args[])
    {
    	List<List<Integer>> result = combinationSum3(3,9);
    	
    	for(List<Integer> list:result)
    	{
    		for(int value:list)
    		{
    			System.out.print(value+" ");
    		}
    		System.out.println();
    	}
    }
}
