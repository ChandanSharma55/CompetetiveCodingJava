import java.util.*;
public class TreeOfSpace {

	static int nodes;
	static int m;
	static class Node
	{
		String value;
		Node parent;
		List<Node> children;
		boolean isLockable;
		boolean isAncestorLocked;
		boolean isChildrenLocked;
		Node(String value, Node parent)
		{
			this.value = value;
			this.children = new ArrayList<Node>();
			this.parent = parent;
			this.isAncestorLocked = false;
			this.isChildrenLocked = false;
			this.isLockable = true;
		}
	}
	
	
	public static void Insert(String[] names)
	{
		
	}
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		nodes = sc.nextInt();
		m = sc.nextInt();
		int op = sc.nextInt();
		String [] names = new String[nodes];
		for(int i=0;i<nodes;i++)
		{
			names[i] = sc.next();
		}
		
		Insert(names);
		
		for(int i=0;i<op;i++)
		{
			System.out.print((i+1)+"-->");
			int ot = sc.nextInt();
			String value = sc.next();
			int id = sc.nextInt();
			switch(ot)
			{
				case 1: System.out.println(Lock(value,id));
						break;
				case 2: System.out.println(UnLock(value,id));
						break;
				case 3: System.out.println(Upgrade(value,id));
						break;
			}
		}
		
		sc.close();
	}
	
}
