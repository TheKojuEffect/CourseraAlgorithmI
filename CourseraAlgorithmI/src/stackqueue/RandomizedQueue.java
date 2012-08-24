package stackqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size;
	
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
	
	public RandomizedQueue() {
		first = null;
		last = null;
	}
	
	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		
		Node oldLast = last;
		last = new Node();
		last.setItem(item);
		last.setPrev(oldLast);
		if (size() == 0)
			first = last;
		size++;
	} // end method enqueue
	
	public boolean isEmpty() {
		return first == null;
	} // end method isEmpty
	
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		Node node = first;
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(size);
		for (int i = 0; i < randomNumber; i++)
			node = node.getNext();
		Item item = node.getItem();
		// point previous node to next node
		node.getPrev().setNext(node.getNext());
		size--;
		return item;
	} // end method dequeue
	
	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		Node node = first;
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(size);
		for (int i = 0; i < randomNumber; i++)
			node = node.getNext();
		Item item = node.getItem();
		return item;
	} // end method sample
	
	public int size() {
		return size;
	} // end method size
	
	@Override
	public Iterator<Item> iterator() {
		return new ItemIterator();
	} // end method iterator
	
	private class ItemIterator implements Iterator<Item> {
		
		private int[] randomSeq;
		private int currentPos = 0;
		private Node currentNode = first;
		
		public ItemIterator() {
			randomSeq = new int[size()];
			
			for (int i = 0; i < randomSeq.length; i++)
				randomSeq[i] = i;
			
			// shuffle
			for (int i = 0; i < randomSeq.length; i++) {
				Random randomGenerator = new Random();
				int randomNum = randomGenerator.nextInt(randomSeq.length);
				int temp = randomSeq[i];
				randomSeq[i] = randomSeq[randomNum];
				randomSeq[randomNum] = temp;
			}
			
			for (int i = 0; i < randomSeq[0]; i++)
				currentNode = currentNode.getNext();
		}
		
		@Override
		public boolean hasNext() {
			if (currentPos == randomSeq.length - 1)
				return false;
			
			return true;
		} // end method hasNext
		
		@Override
		public Item next() {
			int currentNodeIndex = randomSeq[currentPos];
			currentPos++;
			int nextNodeIndex = randomSeq[currentPos];
			if (currentNodeIndex > nextNodeIndex)
				for (; currentNodeIndex != nextNodeIndex; currentNodeIndex--)
					currentNode = currentNode.getPrev();
			
			if (currentNodeIndex < nextNodeIndex)
				for (; currentNodeIndex != nextNodeIndex; currentNodeIndex++)
					currentNode = currentNode.getNext();
			
			Item item = currentNode.getItem();
			return item;
		} // end method next
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		} // end method remove
		
	} // end class ItemIterator
} // end class RandomizedQueue
