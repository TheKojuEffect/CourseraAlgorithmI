package stackqueue;

import java.util.Scanner;

public class ResizingArrayStackOfStrings {
	
	private String[] stack;
	private int top = 0;
	
	public ResizingArrayStackOfStrings() {
		stack = new String[1];
	}
	
	public String pop() {
		if (top > 0 && top == stack.length / 4)
			resize(top / 2);
		if (top == 0) {
			System.err.println("Stack Empty : Stack Underflow");
			return null;
		}
		return stack[--top];
	} // end method pop
	
	public void push(String data) {
		if (top == stack.length)
			resize(top * 2);
		stack[top++] = data;
	} // end method push
	
	private void resize(int capacity) {
		String[] newStack = new String[capacity];
		for (int i = 0; i < top; i++)
			newStack[i] = stack[i];
		stack = newStack;
	} // end method resize
	
	public static void main(String[] args) {
		ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
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
} // end class ResizingArrayStackOfStrings
