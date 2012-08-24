package stackqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private class Node {
		
		private Item item;
		private Node next;
		private Node prev;
		
		public Item getItem() {
			return item;
		}
		
		public Node getNext() {
			return next;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public void setItem(Item item) {
			this.item = item;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	} // end class Node
	
	private Node first;
	
	private Node last;
	
	private int size;
	
	public Deque() {
		first = null;
		last = null;
	}
	
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldFirst = first;
		first = new Node();
		first.setItem(item);
		first.setNext(oldFirst);
		if (size() == 0)
			last = first;
		size++;
	} // end method addFirst
	
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException();
		Node oldLast = last;
		last = new Node();
		last.setItem(item);
		last.setPrev(oldLast);
		if (size() == 0)
			first = last;
		size++;
	} // end method addLast
	
	public boolean isEmpty() {
		return first == null;
	} // end method isEmpty
	
	public Item removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		
		Item item = first.getItem();
		first = first.getNext();
		if (size() == 1)
			last = first;
		size--;
		return item;
	} // end method removeFirst
	
	public Item removeLast() {
		if (last == null)
			throw new NoSuchElementException();
		
		Item item = last.getItem();
		last = last.getPrev();
		if (size() == 1)
			first = last;
		size--;
		return item;
	} // end method removeLast
	
	public int size() {
		return size;
	} // end method size
	
	@Override
	public Iterator<Item> iterator() {
		return new ItemIterator();
	} // end method iterator
	
	private class ItemIterator implements Iterator<Item> {
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		} // end method hasNext
		
		@Override
		public Item next() {
			Item item = current.getItem();
			current = current.getNext();
			return item;
		} // end method next
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		} // end method remove
		
	} // end class ItemIterator
	
} // end class Deque
