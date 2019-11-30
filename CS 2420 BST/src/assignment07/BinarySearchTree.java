package assignment07;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/05/2018
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements SortedSet<E> {

	private BinaryNode<E> 	root;
	private int size;
	private int countForArray;

	/**
	 * Constructor for BinarySearchTree class.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		countForArray = 0;
	}

	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E first() throws NoSuchElementException {
		if (root == null)
			throw new NoSuchElementException();

		BinaryNode<E> current = root;
		
		//looking for the most left item.
		while (current.left != null) {
			current = current.left;
		}
		return current.element;
	}

	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E last() throws NoSuchElementException {
		if (root == null)
			throw new NoSuchElementException();

		BinaryNode<E> current = root;

		//looking for most right element.
		while (current.right != null) {
			current = current.right;
		}
		return current.element;
	}

	/**
	 * Adds the specified element to this set if it is not already present and not
	 * set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	@Override
	public boolean add(E element) {
		if (element == null)
			throw new NullPointerException();
		
		if (this.contains(element))
			return false;

		if (root == null) {
			root = new BinaryNode<E>(element);
			size++;
			return true;
		}
		
		else {
			BinaryNode<E> current = root;
			// if the left is not null, then keep find until an open position
			while (true) {
				if (element.compareTo(current.element) < 0) 
					if (current.left == null) {
						current.left = new BinaryNode<E>(element);
						break;
						} 
					else {
						current = current.left;
						continue;
					}
				
			    else 
					if (current.right == null) {
						current.right = new BinaryNode<E>(element);
						break;
						} 
					else {
						current = current.right;
						continue;
						}
				}
			}
		size++;
		return true;
	}
	/**
	 * Adds all of the elements in the specified collection to this set if they are
	 * not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		boolean check = false;
		for (E element : elements) {
			check = this.add(element);
		}
		return check;
	}

	/**
	 * Removes all of the elements from this set. The set will be empty after this
	 * call returns.
	 */
	@Override
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	@Override
	public boolean contains(Object element) {
		if(element ==null) 
			throw new NullPointerException();
		
		if (size == 0) 
			return false;
		
		@SuppressWarnings("unchecked")
		E data = (E) element;
		BinaryNode<E> current= root;
		
		// if find a null, then it does not exist in the tree.
		while (true) {
			if (data.compareTo(current.element) < 0)
				if (current.left == null)
					return false;
				else
					current = current.left;

			else if (data.compareTo(current.element) > 0)
				if (current.right == null)
					return false;
				else
					current = current.right;

			else 
				return true;
		}
	}

	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	@Override
	public boolean containsAll(Collection<?> elements) {
		for (Object element : elements) {
			if (!this.contains(element)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return true if this set contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	@Override
	public boolean remove(Object element) {
		if(element == null) {
			throw new NullPointerException();
		}
		if (!this.contains(element) || size==0) {
			return false;
		}
		//removing null
		//what if empty tree.
		
		@SuppressWarnings("unchecked")
		E data = (E) element;
		BinaryNode<E> current = root;
		BinaryNode<E> parent= current;
		
		while (true) {
			if (data.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
			}
			else if (data.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
			}
			else
				break; // found it, go out the loop.
		}
		
		/*
		 * case 1:Removing a node with 0 subtrees;
		 */
		
		if(current.left==null&& current.right ==null) {
			if(element.equals(root.element)) 
				root = null;
			else if( parent.left !=null && parent.left.element.equals(element)) 
				parent.left =null;
			else 
				parent.right = null;
		}
		
		/*
		 * case 2: Removing a node with 2 subtrees.
		 */
		else if(current.left !=null && current.right !=null) {
			BinaryNode<E> minNode;
			
			if(current.right.left ==null) {
				//check to see if the removing element is in root or not.
				if(element.equals(root.element)) {
					root = current.right;
				}
				else if(parent.left !=null && parent.left.element.equals(element)) {
					parent.left = current.right;
				}
				else 
					parent.right = current.right;
			}
			else {
				minNode = current.right.left;
				//find the right most left node.
				while(minNode.left!=null) {
					minNode = minNode.left;
				}
				
				if(minNode.right ==null) {
					//check to see if the removing element is in root or not.
					if(element.equals(root.element)) { 
							root.element = minNode.element;
							current.right.left =null;
					}
					else {
						if(parent.left !=null && parent.left.element.equals(element)) 
							parent.left = minNode;
						else 
							parent.right = minNode;
					}
				}
					
				else {
					//check to see if the removing element is in root or not.
					if(root.element.equals(element)) {
						if(element.equals(root.element)) 
							current.right.left = minNode.right;
							root = minNode;
					}
					
					else {
						if(parent.left !=null && parent.left.element.equals(element)) {
							current.right.left = minNode.right;
							parent.left = minNode;
						}
						else {
							current.right.left = minNode.right;
							parent.right = minNode;
						}	
					
					}
				}
		}
	}
		
		/*
		 * case 3: Removing a node with 1 subtrees
		 */
		else if(current.left ==null) {
			
			/*
			 * 1) check which side is null. left or right.
			 * 2) which side is the element on. parent left or right.
			 * 
			 */
			if(element.equals(root.element)) {
				root = current.right;
			}
	
			else if(parent.left !=null &&parent.left.element.equals(element)) {
				parent.left = current.right;
			}
			
			else {
				parent.right= current.right;
			}
		}
		
		else {
			
			if(element.equals(root.element)) {
				root = current.left;
			}
			else if(parent.left !=null && parent.left.element.equals(element)) {
				parent.right = current.left;
			}
			else
				parent.left= current.left;
			}
		
		size--;
		return true;
	
	}
	
	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean removeAll(Collection<?> elements) {
		boolean check = false;
		for (Object element: elements) {
			check = remove(element);
		}
		return check;
	}

	/**
	 * @return the number of elements in this set
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	@Override
	public Object[] toArray() {
		if (size == 0) {
			return new Object[0];
		}

		Object[] array = new Object[size];
		toArray(root, array);
		return array;
		
	}
	/**
	 * This method will help you to generate dots for you.
	 * @return
	 * @throws Exception 
	 */
	public String generateDot() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("BST not large enough to visualize.");
		}
		String result = "digraph BST {\n";
		result += "  node [shape=record]\n";
		result += root.generateDot();
		
		return result + "}";

	}

	/**
	 * Private helper recursion method for changing BST into array.
	 * 
	 * @param current
	 *            node
	 * @param array
	 * @param countForArray
	 * @return an array with all the elements in the BST(ascending order)
	 */
	private void toArray(BinaryNode<E> current, Object[] array) {
		if(current != null) {
			toArray(current.left, array);
			array[countForArray++] = current.element;
			toArray(current.right,array);
		}
		
		
	}
	/**
	 * This method is for testing only. Use to test the value of root.
	 * @return
	 */
	public E returnRoot() {
		return root.element;
	}

	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		public BinaryNode(E element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
		
		public String generateDot() {
			String ret = "  node" + element + " [label = \"<f0> |<f1> " + element + "|<f2> \"]\n";
			if(left != null)
				ret += "  node" + element + ":f0 -> node" + left.element + ":f1\n" + left.generateDot();
			if(right != null)
				ret += "  node" + element + ":f2 -> node" + right.element + ":f1\n" + right.generateDot();
			return ret;
		}

	}
}
	