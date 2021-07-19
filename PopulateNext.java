import java.util.*;
public class PopulateNext {
	
	
	public static TreeNode connect(TreeNode root)
	{
		
		if(root == null)
			return root;
		
		Queue<TreeNode> q = new LinkedList<>();
		root.next = null;
		if(root.left != null)
			q.add(root.left);
		if(root.right != null)
			q.add(root.right);
		while(!q.isEmpty())
		{
			int qSize = q.size();
			Queue<TreeNode> temp = new LinkedList<>();
			while(qSize-- != 0)
			{
				TreeNode tempNode = q.poll();
				temp.add(tempNode);
				if(tempNode.left != null)
					q.add(tempNode.left);
				if(tempNode.right != null)
					q.add(tempNode.right);
			}
			while(!temp.isEmpty())
			{
				TreeNode a = temp.poll();
				if(!temp.isEmpty())
					a.next = temp.peek();
				else
					a.next = null;
			}
		}
		return root;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root = connect(root);
	}
	

}
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}
    
    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
