import java.util.*;
public class DiameterOfBT {

	
	public static class Diapair
	{
		int ht, dia;
		Diapair(int ht, int dia)
		{
			this.dia = dia;
			this.ht = ht;
		}
	}
	
	public static Diapair diameter(Node root)
	{
		if(root == null)
		{
			Diapair bp = new Diapair(0,0);
			return bp;
		}
		
		Diapair l = diameter(root.left);
		Diapair r = diameter(root.right);
		
		int height = Math.max(l.ht, r.ht)+1;
		int fes = l.ht+r.ht+1;
		int dia = Math.max(height-1, fes);
		Diapair mp = new Diapair(height, dia);
		return mp;
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Node root = null;
		int n = sc.nextInt();
		int i=0;
		while(i++ < n)
		{
			int data = sc.nextInt();
			root = InsertBst.insert(root, data);
		}
		InsertBst.preOrder(root);
		Diapair p = diameter(root);
		System.out.print("\n"+p.dia);
		
		sc.close();
	}
}
