/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Creates a list that swaps elements and moves elements from the front to the back of a list
 * @author Kavya and Kaushya
 */
public class SwapList<E> implements ISwapList<E> {
	
	/** Initial capacity to initialize list to */
	private static final int INITIAL_CAPACITY = 10;
	/** list that holds elements */
	private E[] list;
	/** size of list */
	private int size;
	
	/**
	 * Adds element to list
	 * @param element element to be added to list
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Removes element from list
	 * @param idx index to remove element from
	 * @return element being removed
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *  Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveUp(int idx) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		return 0;
	}
	
	/**
	 * Checks capacity of the list
	 * @param idx of element
	 */
	private void checkCapacity(int idx) {
		
	}
	
	/**
	 * Checks index of the list
	 * @param idx of element
	 */
	private void checkIndex(int idx) {
		
	}

}
