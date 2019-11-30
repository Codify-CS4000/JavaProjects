package assignment09;

import java.util.Collection;
/**
 * 
 * @author XI ZHENG
 *
 */

public class QuadProbeHashTable implements Set<String>{
	private String[] hashTable;// hash table to store the hash code of the Strings
	private HashFunctor fun;
	private int cap;// capacity of hash table
	// use to confirm when need to resize this hash table
	private int currentSize;// keep track of the numbers of Strings in hash table
	
	
	/** Constructs a hash table of the given capacity that uses the hashing function
	  * specified by the given functor.
	  */
	public QuadProbeHashTable(int capacity, HashFunctor functor) {
		if(isPrime(capacity)==true) {
			cap=capacity;
		}// if the given capacity is prime number
		else {
			cap=getPrimeNumber(capacity);
		}// if the given capacity is not the prime number, find the next largest prime number
		
		hashTable= new String[cap];
		fun= functor;
		currentSize=0;
		
		
	}
	/*
	 * this method is used to get the next prime number
	 */
	public int getPrimeNumber(int num) {
	 num++;
		for(int i=2;i<num;i++) {
			if(num%i==0) {
				num++;
				i=2;
			}
			else {
				continue;
			}
		}
		return num;
	}
	public static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++)
		{
			if (number % i == 0) {
				return false;
		}
		}
		return true;
			
	}

		
	
	/**
	 *  this method is used to resize the hash table if the load factor 
	 *   is greater than 0.5( helper method)
	 */
	public void resize()
	{
		
		String [] backUp = hashTable;//assign hashTable to backup
		cap=getPrimeNumber(cap*2+1);// resize the capacity but need maintain to the prime numebr
		hashTable = new String[cap];
		for(int i=0;i<backUp.length;i++) {
			if(backUp[i]!=null) {
				int value= hashCode(fun.hash(backUp[i]));// rehash
				int temp=value;
				int H=0;// this is used to quadratic probing 
				
		        while(hashTable[temp]!=null) {
		        	
		        	H++;
		        temp =(int)((value+ (H*H))%cap);
		        }
		        hashTable[temp]=backUp[i];
			}
		}
		
	}
	
	public float loadFactor() {
		return (float)currentSize/cap;
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
		if(loadFactor()>=0.5) {
			resize();
		}
		int value= hashCode(fun.hash(item));// rehash
		int temp=value;
		int H=0;// this is used to quadratic probing 
        while(hashTable[temp]!=null) {
        	if(hashTable[temp].equals(item)) {
        		return false;
        	}
        	H++;
        temp =(int)((value+ (H*H))%cap);//formula for quadratic probing
        }
        hashTable[temp]=item;// put to the correct location
		this.currentSize++;// increment of the size
//		if(loadFactor()>=0.5) {
//			resize();
//		}
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
		for(String every : items) {
			if(contains(every)==false) {
				add(every);
				count++;
			}
		}
		if(count==0) {
			return false;
		}// if every String in this collection has already existed. false
		return true;
	}

	 /**
	   * Removes all items from this set. The set will be empty after this method
	   * call.
	   */
	@Override
	public void clear() {
		String[] backUp = new String[cap];// empty array
		hashTable = backUp;// assign back up to the hash table
		currentSize=0;// clear the current size
		
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
		if(item==null) {
			throw new NullPointerException();
		}
		if(currentSize==0) {
			return false;
		}
		int value=  hashCode(fun.hash(item));
		int temp=value;
		int H=0;// this is used to quadratic probing 
        while(hashTable[temp]!=null) {
        	if(hashTable[temp].equals(item)) {
        		return true;
        	}
        	H++;
        	temp =(int)((value+ (H*H))%cap);// rehash and quadratic probing
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
		if(hashTable==null||currentSize==0) {
			return false;
		}
		int count=0;// set this number to keep track of the number of containing elements
		for(String every: items) {
			if(contains(every)==true) {
				count++;
			}
		}
		if(count==items.size()) {
			return true;
		}// find all Strings of collection in this array, true
		return false;
	}
	
	 /**
	   * Returns true if this set contains no items.
	   */
	@Override
	public boolean isEmpty() {
		if(this.currentSize==0) {
			return true;
		}// currentSize =0, empty
		return false;
	}
	
	/**
	   * Returns the number of items in this set.
	   */
	@Override
	public int size() {
		return this.currentSize;
			
	}
	public int GetCap() {
		
		return this.cap;
	}
	
		
// use this method to see the structure of the hash table
		public String[] toArray() {
	   if(this.currentSize==0) {
			return null;
		}
	   
	   String[] actualArray=  new String [this.cap];

	 for(int i=0;i<this.cap;i++) {
		actualArray[i] = hashTable[i];
	 }

			return actualArray;
		}
		
		
	
}
