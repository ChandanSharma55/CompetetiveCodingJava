import java.util.*;
public class PrintNodesAtK {

	
	public static void printLevelK(int k, Node root)
	{
		int counter = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(counter <= k)
		{
			int l = q.size();
			while(l-- > 0)
			{
				Node temp = q.remove();
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
			counter++;
		}
		for(Node value:q)
		{
			System.out.print(value.data+" ");
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Node root = null;
		//int n = sc.nextInt();
		int k = sc.nextInt();
		int i=0;
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);
		
		/*while(i++ < n)
		{
			int data = sc.nextInt();
			root = InsertBst.insert(root, data);
		}*/
		System.out.println("Preorder => ");
		InsertBst.preOrder(root);
		System.out.println();
		printLevelK(k,root);
		sc.close();
	}
}
