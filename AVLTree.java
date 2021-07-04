import java.util.Scanner;

public class AVLTree {

	public static Node rightRotate(Node root)
	{
		Node x = root.left;
		Node y = x.right;
		x.right = root;
		root.left = y;
		return x;
	}
	
	public static Node leftRotate(Node root)
	{
		Node x = root.right;
		Node y = x.left;
		x.left = root;
		root.right = y;
		return x;
	}
	
	public static int height(Node root)
	{
		if(root==null)
			return -1;
		int l = height(root.left);
		int r = height(root.right);
		if(l>=r)
			return l+1;
		else
			return r+1;
	}
	
	public static int balanceFactor(Node root)
	{
		if(root == null)
			return -1;
		else
			return height(root.left)-height(root.right);
	}
	
	public static Node insertAVL(Node root, int data)
	{
		//Insert like BST
		if(root == null)
		{
			root = new Node(data);
			return root;
		}
		else if(data<root.data)
		{
			root.left = insertAVL(root.left, data);
		}
		else if(data>root.data)
		{
			root.right = insertAVL(root.right,data);
		}
		
		//Check for balance factor
		int bf = balanceFactor(root);
		System.out.print(root.data + " " + bf+"\n");
		//Rotate according to the values and balance factor
		if(bf>1 && data<root.left.data)
			return rightRotate(root);
		if(bf<-1 && data>root.right.data)
			return leftRotate(root);
		if(bf>1 && data>root.left.data)
		{
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		if(bf<-1 && data<root.right.data)
		{
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
	}
	
	
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		root.right.right = new Node(5);
		while (n-- > 0) {
			int data = sc.nextInt();
			root = insertAVL(root, data);
		}

		sc.close();
	}
}
