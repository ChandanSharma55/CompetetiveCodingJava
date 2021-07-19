import java.util.*;

public class ZigZagTree {
	
	public static List<Integer> reverseNodes(List<Integer> list)
	{
		List<Integer> returnList = new ArrayList<>();
		for(int i=list.size()-1;i>=0;i--)
		{
			returnList.add(list.get(i));
		}
		return returnList;
	}
	
	public static void printZigZag(Node root)
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int counter = 1;
		while(!q.isEmpty())
		{
			int qLength = q.size();
			Node current = q.peek();
			List<Integer> nodes = new ArrayList<>();
			while(qLength > 0)
			{
				Node temp = q.peek();
				nodes.add(temp.data);
				q.poll();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				qLength--;
			}
			if(counter%2 == 0)
				nodes = reverseNodes(nodes);
			for(int i=0;i<nodes.size();i++)
			{
				System.out.print(nodes.get(i)+" ");
			}
			counter++;
		}
		
	}
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = InsertBst.insert(root, data);
        }
        
        printZigZag(root);
        scan.close();
    }	

}
