package assignment04;
/**
 * * @author XI ZHENG , SeungHoon Jay
 * 
 * testing AnagramUtill 
 * 1. sort method
 * 2. areAnagram method
 * 3. getLargestAnagramGroup
 * 4. getLargestAnagramGroup(Scanner)
 * 
 */


import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class AnagramUtilTest {

	@Test
	public void testsortMethod() {
		Assert.assertEquals("inux", AnagramUtil.sort("unix"));
	}

	@Test
	public void testsortNullMethod() {
		Assert.assertEquals("", AnagramUtil.sort(""));
	}
	@Test 
	public void testsortWithNumber() {
		Assert.assertEquals("124",  AnagramUtil.sort("142"));
	}
	

	@Test
	public void testsortLowerUpper1() {
		Assert.assertEquals("eEHllo", AnagramUtil.sort("HeEllo"));
	}

	@Test
	public void testareAnagramsMethod() {
		Assert.assertEquals(true, AnagramUtil.areAnagrams("Linux", "Lunix"));
		Assert.assertEquals(false, AnagramUtil.areAnagrams("Linux", "xixixi"));
	}
	@Test
	public void testareAnagramswithNull() {
		Assert.assertEquals(true, AnagramUtil.areAnagrams("", ""));
		Assert.assertEquals(false, AnagramUtil.areAnagrams("", "xixixixi"));
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testgetLargestAnagramGroupMethod1() {
		String[] a = { "unix", "xiun" };
		String[]b = { "unix", "xiun", "uud","isjde","wjsj" };
		Assert.assertEquals(a, AnagramUtil.getLargestAnagramGroup(b));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetLargestAnagramGroupMethod() {
		String[] emptyArray = new String [0];
		String[] nullArray = new String [0];
		nullArray = null;
		Assert.assertEquals(emptyArray, AnagramUtil.getLargestAnagramGroup(nullArray));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void getLargestAnagramGroupMethod2() {
		String[] a = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		String[]b = { "carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster", "aspired",
				"allergy", "despair", "asp", "pas", "least", "sap", "spa", "diapers", "praised", "crates", "Reacts",
				"bats", "tea", "Stab", "stale", "tabs", "recast", "darters", "Gallery", "retards", "starred", "code",
				"Coed", "deco", "traders", "traces" };
		Assert.assertEquals(a, AnagramUtil.getLargestAnagramGroup(b));
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testScanner() {
		Scanner scanner = new Scanner("Unix\nixun\ndjnden");
		String[] str1 = { "Unix", "ixun" };
		Assert.assertEquals(str1, AnagramUtil.getLargestAnagramGroup(scanner));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testScanner2() {
		String[] str1 = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };

		Scanner scanner = new Scanner(
	"carets\nCaller\neat\ncellar\nrecall\nCaters\nAte\ncaster\naspired\nallergy\ndespair\nasp\npas\nleast\nsap\nspa\ndiapers\npraised\ncrates\nReacts\nbats\ntea\nStab\nstale\ntabs\nrecast\ndarters\nGallery\nretards\nstarred\ncode\nCoed\ndeco\ntraders\ntraces");
		Assert.assertEquals(str1, AnagramUtil.getLargestAnagramGroup(scanner));
	}
}
