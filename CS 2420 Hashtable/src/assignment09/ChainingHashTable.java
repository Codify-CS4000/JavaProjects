package assignment09;

import java.util.Collection;
import java.util.LinkedList;
/**
 * @author XI ZHENG
 *
 */

public class ChainingHashTable implements Set<String>{
	private LinkedList<String>[] storage;
	private HashFunctor fun;
	private int cap;// capacity of hash table
	// use to confirm when need to resize this hash table
	private int currentSize;// keep track of the numbers of Strings in hash table
	
	@SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor) {
		// create an array of linked list with given capacity
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		this.cap=capacity;
		fun=functor;
		currentSize=0;//the number of strings in this hash table
		
	}

	public int hashCode(int num) {
		return Math.abs(num%cap);
	}
	 /**
	   * Ensures that this set contains the specified item.
	   * 
	   * @param item -
	   *          the item whose presence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if the input item was actually inserted); otherwise, returns false
	   */
	@Override
	public boolean add(String item) {
		if(item==null) {
			throw new NullPointerException();
		}
		int value =hashCode( fun.hash(item));// hash string
		//System.out.println(value);
		if(storage[value]==null) {// if this location in array is empty
			storage[value] = new LinkedList<String>();// create a new linked list
			storage[value].addFirst(item);//add the item in the first location of linked list
			currentSize++;
			return true;
		}
		for(String every: storage[value]) {
			if(every.equals(item)){
				return false;
			}
		}
		storage[value].add(item);// add to the hash table
		currentSize++;// increase the currentSize
		
		return true;
	}

	 /**
	   * Ensures that this set contains all items in the specified collection.
	   * 
	   * @param items -
	   *          the collection of items whose presence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if any item in the input collection was actually inserted);
	   *         otherwise, returns false
	   */
	@Override
	public boolean addAll(Collection<? extends String> items) {
		if(items==null) {
			return false;
		}
		// use "count" as the flag to count the strings which can add to the hash table
		int count=0;
		for(String element:items) {
			if(contains(element)==false) {
				add(element);
				count++;
			}
		}
		if(count==0) {
			return false;
		}// if every string in thi collections has already existed, false
		return true;
	}

	 /**
	   * Removes all items from this set. The set will be empty after this method
	   * call.
	   */
	@Override
	public void clear() {
		@SuppressWarnings("unchecked")
		//create a new empty array of linked list for the storage
		LinkedList<String>[]backUp = (LinkedList<String>[]) new LinkedList[cap];
		storage = backUp;// assign back up array to the storage 
		currentSize=0;
		// clear the current size
		
	}
	 /**
	   * Determines if there is an item in this set that is equal to the specified
	   * item.
	   * 
	   * @param item -
	   *          the item sought in this set
	   * @return true if there is an item in this set that is equal to the input
	   *         item; otherwise, returns false
	   */

	@Override
	public boolean contains(String item) {
		if(currentSize==0) {
			return false;
		}
		if(item==null) {
			throw new NullPointerException();
		}
		int value = hashCode(fun.hash(item));
		if(storage[value]==null) {
			return false;
		}// if the location of storage[value] is empty, false
		for(int i =0;i<storage[value].size();i++) {
			if(storage[value].get(i).equals(item)) {
				return true;// check every string of linked list in specific location of the array
			}
		}
		return false;
	}
	/**
	   * Determines if for each item in the specified collection, there is an item
	   * in this set that is equal to it.
	   * 
	   * @param items -
	   *          the collection of items sought in this set
	   * @return true if for each item in the specified collection, there is an item
	   *         in this set that is equal to it; otherwise, returns false
	   */
	@Override
	public boolean containsAll(Collection<? extends String> items) {
		if(storage==null||currentSize==0) {
			return false;
		}
		int count=0;// set this number to keep track of the number of containing elements
		for(String element: items) {
			if(contains(element)==true) {
				count++;
			}
			if(count==items.size()) {
				return true;
			}//if we can find all the strings of collection in this hash table, true
		}
		return false;
	}
	
	 /**
	   * Returns true if this set contains no items.
	   */
	@Override
	public boolean isEmpty() {
		if(this.currentSize==0) {
			return true;
		}// if the currentSize=0, empty
		return false;
	}
	
	/**
	   * Returns the number of items in this set.
	   */
	@Override
	public int size() {
		
		return this.currentSize;
	}
	
	
}
