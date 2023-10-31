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
	public Log() {
		
	}
	
	/**
	 * Adds element to log
	 * @param element element to be added to log
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Gets element from log
	 * @param idx index to get element from
	 * @return element in list
	 */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the size of the log
	 * @return size of list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
