/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Maintains a log of elements where items are added and cannot be removed.
 * @author Kavya and Kaushya
 * 
 * @param <E> type for the Log
 */
public class Log<E> implements ILog<E> {
	
	/** log of elements */
	private E[] log;
	/** size of log */
	private int size;
	/** size to initialize the array to */
	private static final int INIT_CAPACITY = 10;
	
	/** Constructor of Log object */
	@SuppressWarnings("unchecked")
	public Log() {
		log = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds element to log
	 * @param element element to be added to log
	 * @throws NullPointerException “Cannot add null element.” if the parameter is null.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		
		if (size >= log.length) {
			E[] log2 = (E[]) new Object[log.length * 2];
			for (int i = 0; i < log.length; i++) {
				log2[i] = log[i];
			}
			this.log = log2;
		}
		log[size] = element;
		size++;
	}
	
	/**
	 * Gets element from log
	 * @param idx index to get element from
	 * @return element in list
	 * @throws IndexOutOfBoundsException “Invalid index.” if the index parameter is out of bounds for the list.
	 */
	@Override
	public E get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		return log[idx];
	}

	/**
	 * Returns the size of the log
	 * @return size of list
	 */
	@Override
	public int size() {
		return size;
	}

}
