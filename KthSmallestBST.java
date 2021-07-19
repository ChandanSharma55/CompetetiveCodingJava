import java.util.*;
public class KthSmallestBST {
	
	
	public static void find(Node root,int k,Queue<Integer> q)
	{
		if(root == null)
			return;
		
		find(root.left,k,q);
		q.add(root.data);
		if(q.size() == k)
			return;
		find(root.right,k,q);
		
		
	}
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int k = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = InsertBst.insert(root, data);
        }
        
        Queue<Integer> q = new LinkedList<>();
        find(root,k,q);
        System.out.print(q.toArray()[k-1]);
        scan.close();
    }	
	
}
