package stackqueue;

import java.util.Scanner;

public class LinkedStackOfStrings {
	
	private class Node {
		
		private String data = null;
		private Node next = null;
		
		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
	} // end class Node
	
	private Node top = null;
	
	public boolean isEmpty() {
		return top == null;
	} // end method isEmpty
	
	public String pop() {
		if (isEmpty()) {
			System.out.println("Stack Empty : Stack Underflow");
			return null;
		}
		String data = top.getData();
		top = top.getNext();
		return data;
	} // end method pop
	
	public void push(String data) {
		Node oldTop = top;
		top = new Node();
		top.setData(data);
		top.setNext(oldTop);
	} // end method push
	
	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		Scanner reader = new Scanner(System.in);
		String input = null;
		System.out.println("Press /// to end");
		while (!(input = reader.next()).equals(new String("///"))) {
			input = input.trim();
			if (input.equals(new String("-")))
				System.out.println(stack.pop());
			else
				stack.push(input);
		} // end while
	} // end method main
} // end class LinkedStackOfStrings
