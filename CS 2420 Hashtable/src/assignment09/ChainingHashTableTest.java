package assignment09;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author XI ZHENG
 *
 */
public class ChainingHashTableTest {


	@Test
	public void testAddMethodMediumSize() {
		BadHashFunctor fun= new BadHashFunctor();
		ChainingHashTable table= new ChainingHashTable(6, fun);
		assertTrue(table.add("China"));
		assertTrue(table.add("Beijing"));
		assertTrue(table.add("shanghai"));
		assertTrue(table.add("nanjing"));
		assertTrue(table.add("chengdu"));
		assertTrue(table.add("fuzhou"));
		assertTrue(table.add("nanning"));
		assertTrue(table.add("guizhou"));
		assertTrue(table.add("ningxia"));
		assertTrue(table.add("neimenggu"));
		assertTrue(table.add("hangzhou"));
		assertTrue(table.add("guangzhou"));
		assertFalse(table.add("nanning"));
		assertTrue(table.add("changping"));
		assertTrue(table.add("hubei"));
		assertTrue(table.add("hunan"));
		assertTrue(table.add("shenzhen"));
		assertTrue(table.add("changsha"));
		assertTrue(table.add("chaoyang"));
		assertTrue(table.add("haidian"));
		assertTrue(table.add("gubei"));
		assertTrue(table.add("gulou"));
		assertTrue(table.add("jinan"));
		assertTrue(table.size()==22);	
	}
	@Test 
	public void testAddWithLargeLengthStringGood() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(3, fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test 
	public void testAddWithLargeLengthStringMed() {
		MediocreHashFunctor fun= new MediocreHashFunctor();
		ChainingHashTable table = new ChainingHashTable(3,fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test 
	public void testAddWithLargeLengthStringBad() {
		BadHashFunctor fun= new BadHashFunctor();
		ChainingHashTable table = new ChainingHashTable(3,fun);
		assertTrue(table.add("hduejmqwwjnjewhfuirfjnsdfnnhsnfrggjskdnkdmcnvjdithgushdfdldnddsjdrngjkdsnvmc vmxmnufgejsnkjfdnvjksdf"));
	}
	@Test
	public void testAddMethodSameLength() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(7, fun);
		assertTrue(table.add("ship"));
		assertTrue(table.add("stop"));
		assertTrue(table.add("slow"));
		assertTrue(table.add("slim"));
		assertTrue(table.add("show"));		
		assertTrue(table.add("swim"));
		assertTrue(table.add("swap"));
	}
	@Test
	public void testAddAllMethodTrue() {
		MediocreHashFunctor fun= new MediocreHashFunctor();
		ChainingHashTable table = new ChainingHashTable(18, fun);
		assertTrue(table.size()==0);
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
		assertTrue(table.size()==13);
		
	}
	@Test
	public void testAddAllMethodFalse() {
		BadHashFunctor fun= new BadHashFunctor();
		ChainingHashTable table = new ChainingHashTable(18,fun);
		table.add("graph");
		table.add("pink");
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("graph");
		checkArray.add("graph");
		checkArray.add("pink");
		assertFalse(table.addAll(checkArray));
		table.clear();
		assertTrue(table.size()==0);
		Collection<String> checkArray1 = new ArrayList<String>();
		checkArray1.add("graph");
		checkArray1.add("graph");
		checkArray1.add("pink");
		assertTrue(table.addAll(checkArray1));
	}
	@Test(expected = NullPointerException.class)
	public void testContainscheckForNull() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(4,fun);
		table.add("pink");
		table.add("red");
		table.add("yellow");
		table.contains(null);	
	}
	@Test
	public void testContainsMethod() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(5,fun);
		table.add("super class");
		table.add("extended");
		table.add("bst");
		table.add("linkedlist");
		table.add("graph");
		table.add("queue");
		table.add("stack");
		table.add("bfs");
		table.add("dfs");
		assertTrue(table.contains("dfs"));
		assertTrue(table.contains("bfs"));
		assertTrue(table.contains("linkedlist"));
		assertFalse(table.contains("hashmap"));
	}
	@Test
	public void testConainsAllCheckForNull() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(5,fun);
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("graph");
		checkArray.add("graph");
		checkArray.add("pink");
		assertFalse(table.containsAll(checkArray));
		table.add("graph");
		table.add("pink");
		assertTrue(table.containsAll(checkArray));
		table.clear();
		assertFalse(table.containsAll(checkArray));
	}
	@Test
	public void testIsEmptyMethod() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(5,fun);
		assertTrue(table.isEmpty()==true);
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("graph");
		checkArray.add("graph");
		checkArray.add("pink");
		assertFalse(table.containsAll(checkArray));
		table.add("graph");
		table.add("pink");
		assertTrue(table.isEmpty()==false);
		assertTrue(table.containsAll(checkArray));
		table.clear();
		assertFalse(table.containsAll(checkArray));
	}
	@Test
	public void testSizeMethod() {
		GoodHashFunctor fun= new GoodHashFunctor();
		ChainingHashTable table = new ChainingHashTable(5,fun);
		assertTrue(table.isEmpty()==true);
		assertTrue(table.size()==0);
		Collection<String> checkArray = new ArrayList<String>();
		checkArray.add("graph");
		checkArray.add("graph");
		checkArray.add("pink");
		assertFalse(table.containsAll(checkArray));
		table.add("graph");
		table.add("pink");
		table.add("graph");
		table.add("pink");
		assertTrue(table.size()==2);
		assertTrue(table.isEmpty()==false);
		assertTrue(table.containsAll(checkArray));
		table.clear();
		assertTrue(table.size()==0);
		assertFalse(table.containsAll(checkArray));
	}
	
		
		
		
	}
	



