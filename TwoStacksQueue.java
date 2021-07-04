import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoStacksQueue {

	public static class MyQueue<T> {
		Stack<T> stack1;
		Stack<T> stack2;

		public MyQueue() {
			stack1 = new Stack<T>();
			stack2 = new Stack<T>();
		}

		public void enqueue(T e) {
			// Integer iInteger = Integer.parseInt(e);
			stack1.add(e);
		}

		public void transfer() {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		public void dequeue() {
			if (stack2.isEmpty()) {
				transfer();
			}
			stack2.pop();
		}

		public T peek() {
			if (stack2.isEmpty()) {
				transfer();
			}
			return stack2.peek();
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}