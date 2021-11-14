import java.util.*;
public class BoundaryTraversalTree {

	static List<Integer> result = new ArrayList<>();
	static List<Integer> resultReverse = new ArrayList<>();
	public static void findLeftBoundary(Node root)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			return;
		}
		else
		{
			result.add(root.data);
		}
		if(root.left!=null)
			findLeftBoundary(root.left);
		else
			findLeftBoundary(root.right);
	}
	
	public static void findLeaves(Node root)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			result.add(root.data);
		}
		findLeaves(root.left);
		findLeaves(root.right);
	}
	
	public static void findRightBoundary(Node root)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			return;
		}
		else
		{
			resultReverse.add(root.data);
		}
		if(root.right!=null)
			findRightBoundary(root.right);
		else
			findRightBoundary(root.left);
	}
	public static void printBoundary(Node root)
	{
		 findLeftBoundary(root);
		 findLeaves(root);
		 findRightBoundary(root);
		 resultReverse.remove(0);
		 Collections.reverse(resultReverse);
		 List<Integer> finalResult = new ArrayList<>(result);
		 finalResult.addAll(resultReverse);
		 for(int value:finalResult)
		 {
			 System.out.print(value+" ");
		 }
	}
	
	public static void main(String args[])
	{
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.left.left = new Node(4);
		root.right = new Node(22);
		root.right.right = new Node(25);
		
		printBoundary(root);
	}
}
