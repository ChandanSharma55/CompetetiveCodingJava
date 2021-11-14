import java.util.*;

public class KthParentEvenSum {

	
	static int result=0;
	
	
	public static void getSum(Node root, int k)
	{
		if(k==0)
		{
			result+=root.data;
			return;
		}
		if(root == null)
			return;
		if(root.left==null && root.right==null && k!=0)
			return;
		if(root.left!=null)
			getSum(root.left, k-1);
		if(root.right!=null)
			getSum(root.right, k-1);
		
			
	}
	
	public static void find(Node root,int k)
	{
		if(root == null)
			return;
		if(root.data%2==0)
		{
			getSum(root,k);
		}
		find(root.left,k);
		find(root.right,k);
	}
	
	public static void main(String args[]) {

		
		Node root = new Node(4);
		root.left = new Node(6);
		root.left.left = new Node(8);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(2);
		root.left.right = new Node(5);
		root.right = new Node(8);
		root.right.left = new Node(3);
		
		int k = 2;
		find(root,k);
		System.out.println(result);
	}
}
