import java.util.*;
public class CloneRandomPointer {
	static class ListNode {
		int data;
		ListNode next;
		ListNode random;

		ListNode(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

	static ListNode cloneTheLinkedList(ListNode head) {
		// add your logic here
		ListNode ht = head;
		Hashtable<ListNode, ListNode> map = new Hashtable<>();
		ListNode result = new ListNode(-1);
		ListNode temp = result;
		while (head != null) {
			ListNode t = new ListNode(head.data);
			map.put(head, t);
			temp.next = t;
			head = head.next;
			temp = temp.next;
		}
		temp = result.next;
		head = ht;
		while (head != null) {
			temp.random = (head.random != null) ? map.get(head.random) : null;
			head = head.next;
			temp = temp.next;
		}

		return result.next;
	}
	
	public static void main(String args[])
	{
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		
		a.next = b;
		b.next = c;
		c.next = null;
		a.random = c;
		b.random = b;
		c.random = null;
		
		cloneTheLinkedList(a);
		
	}
}
