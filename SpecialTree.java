import java.util.*;
public class SpecialTree {

	
	static int index=0;
	public static Node constructTree(int[] pre, char[] preLN, int i)
	{
		i=index;
		if(i == 5)
			return null;
		
		char c = preLN[i];
		Node newNode = new Node(pre[i]);
		index++;
		
		if(c == 'N')
		{
			newNode.left = constructTree(pre,preLN,index);
			newNode.right = constructTree(pre,preLN,index);
		}
		
		return newNode;
	}
	
	public static void main(String args[])
	{
		int pre[] = {10, 30, 20, 5, 15};
		char preLN[] = {'N','N','L','L','L'};
		
		Node root = constructTree(pre, preLN, index);
		
		InsertBst.preOrder(root);
	}
}
