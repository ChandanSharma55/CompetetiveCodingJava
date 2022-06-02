import java.util.*;
public class LLPalindrom {
	static class ListNode {
		int data;
		ListNode next;
		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static ListNode ref;
    public static boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public static boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.data == node.data)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }
	
	public static void main(String args[])
	{
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(1);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;
		
		boolean result = isPalindrome(a);
		
		System.out.print(result);
		
	}
}
