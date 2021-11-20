import java.util.*;

public class MinDEpth {

	public static int minDepth(Node root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		else if(root.left == null)
		{
			return minDepth(root.right)+1;
		}
		else if(root.right == null)
		{
			return minDepth(root.left)+1;
		}
		else
		{
			return Math.min(minDepth(root.left), minDepth(root.right))+1;
		}

	}

	public static void main(String args[]) {

		
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.right = new Node(7);
		root.right.left = new Node(15);
		
		System.out.print(minDepth(root));
	}
}
