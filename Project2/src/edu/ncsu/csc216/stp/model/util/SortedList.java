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
		
	}
	
	/**
	 * Adds element to list
	 * @param element element to be added to list
	 * @throws NullPointerException “Cannot add null element.” if the parameter is null.
	 * @throws IllegalArgumentException “Cannot add duplicate element” if the parameter is a duplicate of an existing element.
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Removes element from list
	 * @param idx index to remove element from
	 * @return element being removed
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Checks element at index 
	 * @param idx index to check element
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	private void checkIndex(int idx) {
		
	}
	
	/**
	 * Checks if list already contains the element
	 * @param E element to be checked
	 * @return false if list does not contain element, true if it does
	 */
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns size of list
	 * @return size of list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
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
			
		}
	}

}
