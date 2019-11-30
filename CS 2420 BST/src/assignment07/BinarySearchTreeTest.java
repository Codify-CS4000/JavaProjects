package assignment07;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Binary Search Tree Test
 * 
 * @author Junjun He && Xi Zheng
 * @version 03/05/2018
 *
 */
public class BinarySearchTreeTest {
	BinarySearchTree<Integer> list;

	@Before
	public void setUpBefore ()
	{
		list = new BinarySearchTree<>();
		
		for(Integer i = 0; i < 1000;i++)
		{
			list.add(i);
		}
	}
	
	@Test
	public void getLowestValue() {
		assertEquals((Integer)0, list.first());
		assertEquals(1000, list.size());
	}
	
	@Test
	public void getHighestValue() {
		assertEquals((Integer)999, list.last());
		assertEquals(1000, list.size());
	}
	
	@Test (expected  = NullPointerException.class)
	public void addNullElement() {
		list.add(null);
	}
	
	@Test
	public void addWhenRootIsNull() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<>();
		list2.add(10);
		assertTrue(list2.contains(10));
		assertTrue(list2.size()==1);
	}
	
	@Test
	public void addWhenAlreadInTree() {
		assertFalse(list.add(0));
		assertFalse(list.add(11));
		assertFalse(list.add(12));
		assertFalse(list.add(999));
	}
	
	@Test
	public void addWhenHaveNotInTree() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<>();
		assertTrue(list2.add(1));
		assertTrue(list2.add(0));
		assertTrue(list2.add(-1));
		assertFalse(list2.add(1)); // alread in the tree
	}
	
	@Test
	public void containCheckExistElement() {
		assertTrue(list.contains(0));
		assertTrue(list.contains(100));
		assertTrue(list.contains(999));
	}
	
	@Test
	public void containCheckNotExistElement() {
		assertFalse(list.contains(1000));
		assertFalse(list.contains(1001));
		assertFalse(list.contains(-1));
	}
	
	@Test (expected  = NullPointerException.class)
	public void containSendingNullElement() {
		list.contains(null);
	}
	
	@Test
	public void testClear() {
		list.clear();
		assertTrue(list.size()==0);
	}
	
	
	public void testToArray() {
		Object[] arr = list.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public void testRemove() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add(50);
		list2.add(40);
		list2.add(30);
		list2.add(20);
		list2.add(10);
		
		
		list2.remove(10);
//		Object[] arr = list2.toArray();
//		for(int i = 0; i< arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}
	
	@Test
	public void testRemove2() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add(50);
		list2.add(30);
		list2.add(70);
		list2.add(40);
		list2.add(60);
		list2.add(80);
		list2.remove(30);
//		Object[] arr = list2.toArray();
//		for(int i = 0; i< arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
	}
	
	@Test
	public void testRemove3() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add(50);
		list2.add(40);
		list2.add(70);
		list2.add(60);
		list2.add(80);
		
		list2.remove(50);
		Object[] arr = list2.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	public void testRemove4() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add(50);
		list2.add(40);
		list2.remove(40);
		Object[] arr = list2.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	@Test
	public void testContainsAll()
	{
		ArrayList<Integer> arrList = new ArrayList<>();
		ArrayList<Integer> arrList2 = new ArrayList<>();
		
		for(int i = 0; i <100;i+=5)
		{
			arrList.add(i);
		}
		
		for(int i = 0; i <1000;i++)
		{
			arrList2.add(i);
		}
		
		assertEquals(true, list.containsAll(arrList));
		
		assertEquals(true, list.containsAll(arrList2));
		
	}
	
	
//	comment out when use
//	@Test 
	public void generatDot() throws Exception
	{
		String s= list.generateDot();
		System.out.println(s);
	}

	@Test
	public void testRemoveNoElements() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		System.out.println(list2.remove((Integer) 1));
	}
	
	@Test
	public void testRemoveOnlyOneElement() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add((Integer) 1);
		System.out.println(list2.remove((Integer) 1));
		Object[] arr = list2.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	@Test
	public void testRemoveLeftTreeIsEmpty() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add((Integer) 9);
		list2.add((Integer) 10);
		list2.add((Integer) 11);
		list2.remove((Integer) 9);
		
		Object[] arr = list2.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	@Test
	public void testRemoveRightTreeIsEmpty() {
		BinarySearchTree<Integer> list2 = new BinarySearchTree<Integer>();
		list2.add((Integer) 9);
		list2.add((Integer) 8);
		list2.add((Integer) 7);
		list2.remove((Integer) 9);
		
		Object[] arr = list2.toArray();
		for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
