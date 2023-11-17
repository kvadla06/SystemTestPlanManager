/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * List that maintains all the elements in sorted order
 * @author Kavya and Kaushya
 * 
 * @param <E> type for SortedList; must implement Comparable
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	
	/** size of sorted list */
	private int size;
	/** next element in linked list */
	private ListNode front;

	/** 
	 * SortedList constructor
	 */
	public SortedList() {
		this.front = null;
		this.size = 0;
	}
	
	/**
	 * Adds element to list
	 * @param element element to be added to list
	 * @throws NullPointerException “Cannot add null element.” if the parameter is null.
	 * @throws IllegalArgumentException “Cannot add duplicate element” if the parameter is a duplicate of an existing element.
	 */
	@Override
	public void add(E element) {
		
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}

		ListNode current = front;
		while (current != null) {
			if (element.compareTo(current.data) == 0) {
				throw new IllegalArgumentException("Cannot add duplicate element.");
			}
			current = current.next;
		}
		boolean add = false;
		
		if (front == null) {
			front = new ListNode(element, null);
			add = true;
		}
		current = front;
		if (front.next == null && !add) {
			if (element.compareTo(front.data) > 0) {
				front.next = new ListNode(element, null);
				add = true;
			} else {
				var x = front;
				front = new ListNode(element, x);
			}
			
		}
		
		if (!add && element.compareTo(front.data) < 0) {
			var x = front;
			front = new ListNode(element, x);
			add = true;
		}
		current = front;
		while(current.next != null && !add) {
			if (element.compareTo(current.next.data) < 0) {
				var x = current;
				if (x != null) {
					x = x.next;
				}
				current.next = new ListNode(element, x);
				add = true;
				break;
			} else {
				current = current.next;
			}
		}
		
		if (!add) {
			current = front;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(element, null);
		}
		size++;
	}
	
	/**
	 * Removes element from list
	 * @param idx index to remove element from
	 * @return element being removed
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		
		E value = null;
		if (idx == 0) {
			value = front.data;
			front = front.next;
		} else {
			ListNode current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			value = current.next.data;
			current.next = current.next.next;
		}

		size--;
		return value;
	}
	
	/**
	 * Checks element at index 
	 * @param idx index to check element
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	/**
	 * Checks if list already contains the element
	 * @param element element to be checked
	 * @return false if list does not contain element, true if it does
	 */
	@Override
	public boolean contains(E element) {

		ListNode current = front;
		while (current != null) {
			if (current.data.equals(element)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	/**
	 * Gets element from list
	 * @param idx index to get element from
	 * @return element in list
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		
		ListNode current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	/**
	 * Returns size of list
	 * @return size of list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * ListNode class that holds an element in a linked list
	 * @author Kavya and Kaushya
	 */
	public class ListNode {
		/** current element */
		public E data;
		/** next element to reference */
		public ListNode next;
		
		/** Constructor of ListNode
		 * @param data element stored
		 * @param next next node
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

}
