import java.util.*;

public class MinCameraCover {

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

	public static int cameras = 0;

	public static int minCameraCover(TreeNode root) {
		
		if(minCameraCoverUtil(root) == -1)
			cameras++;
		
		return cameras;
	}
	
	public static int minCameraCoverUtil(TreeNode root) {
		if (root == null)
			return 1;
		int l = minCameraCoverUtil(root.left);
		int r = minCameraCoverUtil(root.right);

		if (l == -1 || r == -1) {
			cameras++;
			return 0;
		}
		if (l == 0 || r == 0) {
			return 1;
		}
		return -1;

	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = null;
		root.left.left = new TreeNode(0);
		root.left.right = null;
		root.left.left.left = new TreeNode(0);
		root.left.left.right = null;
		root.left.left.left.right = new TreeNode(0);
		root.left.left.left.left = null;
		int result = minCameraCover(root);
		System.out.print(result);
	}
}
