import java.util.*;

public class NGEinLL {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static class Pair {
		int p;
		int v;

		Pair(int p, int v) {
			this.p = p;
			this.v = v;
		}
	}

	public static int[] nextLargerNodes(ListNode head) {

		List<Integer> list = new ArrayList<>();
		Stack<Pair> stk = new Stack<>();
		int pos = -1;
		while (head != null) {
			pos++;
			list.add(0);
			while (!stk.isEmpty() && stk.peek().v < head.val) {
				Pair temp = stk.pop();
				list.set(temp.p, head.val);
			}
			stk.push(new Pair(pos, head.val));
			head = head.next;
		}

		int[] result = new int[list.size()];
		int i = 0;
		for (int value : list) {
			result[i++] = value;
		}

		return result;
	}
	public static void main(String args[])
	{
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = null;
		
		int result[] = nextLargerNodes(a);
		for (int value : result) {
			System.out.print(value+" ");
		}
	}
}
