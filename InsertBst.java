import java.util.*;
import java.io.*;

class InsertBst {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
    
    
	public static Node insert(Node root,int data)
    {
		if(root==null)
        {
            Node node=new Node(data);
            root=node;
        }
        else if(root.data>data)
            root.left=insert(root.left,data);
        else if(root.data<data)
            root.right=insert(root.right,data);

        return root;
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}