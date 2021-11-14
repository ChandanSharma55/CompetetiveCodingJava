import java.util.*;
public class MostFrequentSubtreeSum {

	static HashMap<Integer,Integer> map = new HashMap<>();
	public static int find(Node root)
	{
		if(root==null)
			return 0;
		
		int sum = root.data+find(root.left)+find(root.right);
		map.put(sum, map.getOrDefault(sum, 0)+1);
		return sum;
	}
	
	public static int[] findFrequentTreeSum(Node root)
	{
		List<Integer> list= new ArrayList<>();
		int max = Integer.MIN_VALUE;
		find(root);
		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue() > max)
				max = entry.getValue();
		}
		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue() == max)
				list.add(entry.getKey());
		}
		return list.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String args[])
	{
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(-4);
		
		int result[] = findFrequentTreeSum(root);
		
		for(int value:result)
		{
			System.out.print(value+" ");
		}
	}
}
