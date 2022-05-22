import java.util.*;

public class DeepestLeavesSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int deepestLeavesSum(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int sum = 0;
		while(!q.isEmpty())
		{
			int ql = q.size();
			sum = 0;
			while(ql-- > 0)
			{
				TreeNode curr = q.poll();
				sum += curr.val;
				if(curr.left!=null)
					q.offer(curr.left);
				if(curr.right!=null)
					q.offer(curr.right);
			}
		}
		
		return sum;
	}
	
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		
		int result = deepestLeavesSum(root);
		System.out.print(result);
	}
}
