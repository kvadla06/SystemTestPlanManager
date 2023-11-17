/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Creates a list that swaps elements and moves elements from the front to the back of a list
 * @author Kavya and Kaushya
 * @param <E> type for the SwapList
 */
public class SwapList<E> implements ISwapList<E> {
	
	/** Initial capacity to initialize list to */
	private static final int INITIAL_CAPACITY = 10;
	/** list that holds elements */
	private E[] list;
	/** size of list */
	private int size;
	
	/** 
	 * Constructor for SwapList
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds element to list
	 * @param element element to be added to list
	 * @throws NullPointerException “Cannot add null element.” if the parameter is null.
	 * @throws IllegalArgumentException “Cannot add element”
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element");
		}
		checkCapacity(size + 1);
		list[size] = element;
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
		
		E initial = list[idx];
		list[idx] = null;
		
		for (int i = idx; i < size; i++) {
			E temp = list[i + 1];
			list[i] = temp;
		}
		
		list[size - 1] = null;
		size--;
		return initial;
	}

	/**
	 *  Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
		if (idx != 0) {
			E temp = list[idx - 1];
			list[idx - 1] = list[idx];
			list[idx] = temp;
		}
		
	}

	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		if (idx != size - 1) {
			E temp = list[idx + 1];
			list[idx + 1] = list[idx];
			list[idx] = temp;
		}
		
	}
	
	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		if (idx != 0) {
			E front = list[idx];
			for (int i = 0; i < size; i++) {
				list[i + 1] = list[i];
			}
			list[0] = front;
		}
		
	}

	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		if (idx != size - 1) {
			E back = list[idx];
			for (int i = size; i <= 0; i--) {
				list[i - 1] = list[i];
			}
			list[size - 1] = back;
		}
		
	}

	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		
		return list[idx];
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
	 * Checks capacity of the list
	 * @param size new size of list
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int size) {
		if (list.length <= size) {
			E[] list2 = (E[]) new Object[list.length * 2];
			for (int i = 0; i < list.length; i++) {
				list2[i] = list[i];
			}
			this.list = list2;
		}
	}
	
	/**
	 * Checks index of the list
	 * @param idx of element
	 * @throws IllegalArgumentException if index is out of bounds
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

}
