package assignment09;
/**
 * @author XI ZHENG
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class QuadProbeHashTableTest {
	
	@Test
	public void testAddMethodAllTrue() {
	   //cap=7;
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7, fun);
		assertTrue(table.add("hello"));
		assertTrue(table.add("Hello"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("Kitty"));
		assertTrue(table.add("china"));
		assertTrue(table.add("Beijing"));
		assertTrue(table.add("excuse me"));
		assertTrue(table.add(""));
		assertTrue(table.add("  "));
		assertTrue(table.add("shanghai"));
		String[] a=table.toArray();
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println(table.size());
	}
	@Test 
	public void testAddWithLargeLengthStringGood() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(3, fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test 
	public void testAddWithLargeLengthStringMed() {
		MediocreHashFunctor fun= new MediocreHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(3,fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test 
	public void testAddWithLargeLengthStringBad() {
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(3,fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test
	public void testAddMethodSameLength() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7, fun);
		assertTrue(table.add("ship"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("slow"));
		assertTrue(table.add("slim"));
		assertTrue(table.add("show"));		
		assertTrue(table.add("swim"));
		assertTrue(table.add("swap"));
		String[] a=table.toArray();
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
//		System.out.println(table.size());
	}
	
//	public static void main( String []args) {
//	String item ="swap";
//	 int hash=7;
//	  for(int i=0;i<item.length();i++) {
//		  hash=(hash*31+item.charAt(i))%7;
//	  }
//	  System.out.println(hash);
//	}
	@Test
	public void testAddMethodHasFalse() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7,fun);
		assertTrue(table.add("ship"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("slow"));
		assertTrue(table.add("slim"));
		assertTrue(table.add("show"));		
		assertTrue(table.add("swim"));
		assertTrue(table.add("swap"));
		assertFalse(table.add("ship"));
		assertTrue(table.add("solo"));
		assertFalse(table.add("slow"));
		
	}
	@Test
	public void testAddMethodNull() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7,fun);
		
		assertTrue(table.size()==0);
		
	}
	@Test
	public void testAddAllMethodTrue() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(13, fun);
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("nihao");
		checkArray.add("NiHao");
		checkArray.add("amazing");
		checkArray.add("BST");
		checkArray.add("graph");
		checkArray.add("directed");
		checkArray.add("happy");
		checkArray.add("hashcode");
		checkArray.add("BST");
		checkArray.add("graph");
		checkArray.add("shy");
		checkArray.add("blue");
		checkArray.add("pink");
		checkArray.add("cute");
		checkArray.add("utah");
		assertTrue(table.addAll(checkArray));
	}
	@Test
	public void testAddAllMethodFasle() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(13, fun);
		table.add("graph");
		table.add("pink");
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("graph");
		checkArray.add("graph");
		checkArray.add("pink");
		assertFalse(table.addAll(checkArray));
	}
	@Test
	public void testClearMethod(){
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7,fun);
		assertTrue(table.add("ship"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("slow"));
		assertTrue(table.add("slim"));
		assertTrue(table.add("show"));		
		assertTrue(table.add("swim"));
		assertTrue(table.add("swap"));
		assertTrue(table.size()==7);
		table.clear();
		assertTrue(table.size()==0);
		assertTrue(table.add("ship"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("slow"));
		assertTrue(table.add("slim"));
		assertTrue(table.add("show"));
		assertTrue(table.size()==5);
		
	}
	@Test
	public void testContainsWithMidFunction() {
		MediocreHashFunctor fun= new MediocreHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(11,fun);
		assertTrue(table.add("utah"));
		assertTrue(table.add("colorado"));
		assertTrue(table.add("california"));
		assertTrue(table.add("michigan"));
		assertTrue(table.add("washington"));		
		assertTrue(table.add("texas"));
		assertTrue(table.add("penn state"));
		assertTrue(table.add("nevada"));
		assertTrue(table.add("oregon"));
		assertTrue(table.add("NYC"));
		assertTrue(table.add("new mexico"));
		assertTrue(table.add("portland"));		
		assertTrue(table.add("seattle"));
		assertTrue(table.add("las vegas"));
		assertTrue(table.contains("seattle"));
		assertFalse(table.contains("Seattle"));
		table.clear();
		assertFalse(table.contains("utah"));
	}
	@Test
	public void testConatinsAllFalse() {
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(7, fun);
		table.add("nihao");
		table.add("NiHao");
		table.add("amazing");
		table.add("BST");
		table.add("graph");
		table.add("directed");
		table.add("happy");
		
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("nihao");
		checkArray.add("NiHao");
		checkArray.add("amazing");
		checkArray.add("BST");
		checkArray.add("graph");
		checkArray.add("directed");
		checkArray.add("happy");
		checkArray.add("hashcode");
		checkArray.add("bst");
		checkArray.add("graph");
		checkArray.add("shy");
		checkArray.add("blue");
		checkArray.add("pink");
		checkArray.add("cute");
		checkArray.add("utah");
		assertFalse(table.containsAll(checkArray));
	}
	@Test
	public void testConatinsAllTrue() {
		BadHashFunctor fun= new BadHashFunctor();
	QuadProbeHashTable table = new QuadProbeHashTable(8, fun);
	table.add("seattle");
	table.add("NYC");
	table.add("SLC");
	table.add("las vegas");
	table.add("los angles");
	table.add("ohio");
	table.add("cleverland");
	Collection<String> checkArray = new ArrayList<String>();
	checkArray.add("seattle");
	checkArray.add("NYC");
	checkArray.add("SLC");
	assertTrue(table.containsAll(checkArray));
	
} 
	@Test
	public void testcontainsAllDuplicate() {
		BadHashFunctor fun= new BadHashFunctor();
	QuadProbeHashTable table = new QuadProbeHashTable(5, fun);
	table.add("seattle");
	table.add("NYC");
	table.add("SLC");
	table.add("las vegas");
	table.add("los angles");
	table.add("ohio");
	table.add("cleverland");
	table.add("portland");
	Collection<String> checkArray = new ArrayList<String>();
	checkArray.add("seattle");
	checkArray.add("NYC");
	checkArray.add("SLC");
	checkArray.add("SLC");
	assertTrue(table.containsAll(checkArray));
	
} 
	@Test
	public void testConatinsAllCheckForNull() {
		BadHashFunctor fun= new BadHashFunctor();
	QuadProbeHashTable table = new QuadProbeHashTable(5, fun);
	
	Collection<String> checkArray = new ArrayList<String>();
	checkArray.add(null);
	
	assertFalse(table.containsAll(checkArray));
} 
	@Test
	public void testIsEmpty() {
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(5, fun);
		table.add("seattle");
		table.add("NYC");
		table.add("SLC");
		table.add("las vegas");
		table.add("los angles");
		table.add("ohio");
		table.add("cleverland");
		assertFalse(table.isEmpty());
		table.clear();
		assertTrue(table.isEmpty());
	}
	@Test
	public void testSize(){
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(5, fun);
		table.add("seattle");
		table.add("NYC");
		table.add("SLC");
		table.add("las vegas");
		table.add("los angles");
		table.add("ohio");
		table.add("cleverland");
		table.add("seattle");
		assertFalse(table.size()==8);
		assertTrue(table.size()==7);
		  int hash=0;
		  String item="Seattle";
		  for(int i=0;i<item.length();i++) {
			  hash=(hash*31+item.charAt(i))%5;
		  }
//		  System.out.println(hash+"xiix");
		System.out.println("hello".hashCode()+"ix");
		
	}
	@Test
	public void testPrimeNumer() {
		BadHashFunctor fun= new BadHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(5, fun);
		System.out.println(table.getPrimeNumber(5));
		table.add("hello");
		table.add("nihao");
		table.add("hi");
		table.add("hao");
		int a = table.GetCap();
//		System.out.println(a);
//		System.out.println(table.size());
			
	}
	@Test 
	public void testForSmallSize() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(1, fun);
		assertTrue(table.add("hello"));
		assertTrue(table.size()==1);
	}
	@Test
	public void testPrimeNumerfirst() {
		GoodHashFunctor fun= new GoodHashFunctor();
		QuadProbeHashTable table = new QuadProbeHashTable(3, fun);
		System.out.println(table.GetCap()+"begin");
		table.add("hello");
		System.out.println(table.GetCap()+"after hello");
		table.add("nihao");
		System.out.println(table.GetCap()+"after nihao");
		table.add("hi");
		System.out.println(table.GetCap()+"after hi");
		table.add("hao");
		System.out.println(table.GetCap()+"after hao");
//		int a = table.GetCap();
//		System.out.println(a+"first capcaity");
		//System.out.println(table.size()+"size:");
		table.add("seattle");
		//System.out.println(table.GetCap()+"after seattle");
		table.add("xiyatu");
		//System.out.println(table.GetCap()+"after xiyatu");
		table.add("niu");
		//System.out.println(table.GetCap()+"after niu");
		table.add("monkey");
		//System.out.println(table.GetCap()+"after minkey");
		table.add("mm");
	//	System.out.println(table.GetCap()+"after mm");
//		int b= table.GetCap();
//		System.out.println(b+"second size");
		
	}
	@Test
	public void testPrime () {
	GoodHashFunctor fun= new GoodHashFunctor();
	QuadProbeHashTable table = new QuadProbeHashTable(7, fun);
	System.out.println(table.GetCap()+"this is the capacity");
	}
	@Test
	public void testNulArray(){
		int[] array = new int[10];
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}

}




