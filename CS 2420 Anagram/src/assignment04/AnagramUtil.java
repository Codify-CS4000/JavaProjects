package assignment04;


import java.util.ArrayList;
import java.util.Comparator;

import java.util.Scanner;


public class AnagramUtil {
	
	/**
	 * @author XI ZHENG , SeungHoon Jay
	 * 
	 * This method returns the sorted version of the input string. The sorting must
	 * be accomplished using an insertion sort. If a null argument is passed, the
	 * method should return null.
	 * 
	 * @param word  
	 * @return result
	 */
// if you directly use toString method, it will only return the address
	public static String sort(String word) {
		
		if (word == null) {
			return null;
		}//  if this string is null
		
		Character[] newWord = new Character[word.length()];// change string word to character array
		
		for(int i =0;i<word.length();i++) {
			newWord[i]= word.charAt(i);
		}// assign every element into this newWord array 
		 
		Comparator<Character> stringComp = new Comparator<Character>() {
	           public int compare(Character a, Character b) {
	        	 Character  a1 = Character.toLowerCase(a);// make to lower case
	        	 Character  b1 = Character.toLowerCase(b);
	                return a1.compareTo(b1);
	           }
	       };// the aim of this comparator is to compare character in their alpha order
		
		insertionSort(newWord,stringComp);// use the insertionSort method below to sort the string

	     String result = "";// make char to string
	       for (Character each : newWord) {
	            result += each;
	       }
	       
//	       System.out.println(result);
	       return result;
		
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object. If a null argument is passed, the method should
	 * throw a NullPointerException.
	 * 
	 * @param T[] wordToArr , Comparator <? super T> comp
	 */
	public static <T> void insertionSort(T[] wordToArr, Comparator<? super T> comp) {

		if (wordToArr == null||comp==null) {
			throw new NullPointerException();
		}//if the arguments are null
		
		int n = wordToArr.length;
		
		for (int i = 1; i < n; ++i) {
			T key = wordToArr[i];
			int j = i - 1;
			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && comp.compare(wordToArr[j], key) > 0) {
				wordToArr[j + 1] = wordToArr[j];
				j = j - 1;
			}
			wordToArr[j + 1] = key;
		}
		 //Key to be inserted
	}

	
	/**
	 * This method returns true if the two input strings are anagrams of each other,
	 * otherwise returns false. If either argument is null, the method should return
	 * false.
	 * 
	 * @param a
	 * @param b
	 * @return true if a and b are same, false if they are not same
	 */
	public static boolean areAnagrams(String a, String b) {
		if (a == null || b == null) {
			return false;
		}// if either argument is null, return false

		String aOrder = sort(a).toLowerCase();// make this to lower case to compare easily
		String bOrder = sort(b).toLowerCase();
		
		if (aOrder.compareTo(bOrder) == 0) {
		 	return true;// use the natural order to compare
		}

		return false;// two String are not anagrams
	}

	
	/**
	 * This method returns the largest group of anagrams in the input array of
	 * words, in no particular order. It returns an empty array if there are no
	 * anagrams in the input array, or if a null argument is passed in. You may
	 * assume that there will only ever be one largest group of anagrams in a list
	 * of words for testing. There are no restrictions on maintaining the original
	 * array.
	 * 
	 * @param a[] / array of String
	 * @return lastResult  / largest group of anagrams
	 */
	public static String[] getLargestAnagramGroup(String[] a) {
      
		String[] emptyArray = new String [0];
		if(a == null) {
			return emptyArray;
		}
		
		String[] copyArray = new String[a.length];// make a new array, and each element in this new is the same as the a
    
		for(int i =0;i<a.length;i++) {
    	  copyArray[i]=sort(a[i].toLowerCase());
      }

      
		 Comparator<String> com = new Comparator<String>() {
			 public int compare(String s1, String s2) {
					int diff = s1.length() - s2.length();
					
					// Break ties with the "natural" lexicographical ordering.
					if(diff == 0) {
						return s1.compareTo(s2);
					}
					
					return diff;
				}
		 };
		 insertionSort(copyArray,com);// after this sorting, pair anagrams list together and with the same alpha order
//		 for(String l:copyArray) {
//			 System.out.println(l+"*");
//		 }
	       
	       int lGroupSize = 1; // size of Largest group
	       int lGroupIndex = 0; // index of Largest group 
	       int lGEndPoint = 0; //Largest group index end point
	       int gIndex = 0; // length of index
	       int gLength = 1; // length of group 
	       
	       String firstWordG = copyArray[0]; // first word in group
	      
	       for (int i = 1; i < copyArray.length; i++) {
	           if (areAnagrams(firstWordG, copyArray[i])) {
	               gLength++;
	               
	               if (gLength > lGroupSize) {
	            	   lGEndPoint = i;
	            	   lGroupIndex = gIndex;	                 
	                   lGroupSize = gLength;
	               }
	           } else {
	        	   
	               firstWordG = copyArray[i];
	               gIndex = i;
	               gLength = 1;
	               
	           }
	       }

	       String[] alist; // a anagram list to get the largest Strings group 
	       if (lGroupSize > 1) {
	          
	           alist = new String[1 +  lGEndPoint - lGroupIndex ];
	    
	           for (int i = 0; i < alist.length; i++) {
	               alist[i] = copyArray[i + lGroupIndex];
	           }
	       } else {
	           alist = new String[0];// no anagram
	       }//find the largest group, but in this array, every element in this group is the same order
//	       for(String each: anagramList) {
//	     	  System.out.println(each);
//	       }   
       String[] lastResult = new String[alist.length];// use this result array to return the original largest group
     
       String compare = alist[0];
       
       int ind=0;
       
       for(int i =0;i<a.length;i++) {
    	   
    	   if(areAnagrams(compare,a[i])) {
    		   lastResult[ind]=a[i];
    		   ind++;
    	   }
    	   
       }
//      for(String each: lastResult) {
//    	  System.out.println(each);
//      }
	       return lastResult;
	   }
		

	/**
	 * Behaves the same as the previous method, but reads the list of words from a
	 * file using a Java Scanner (Links to an external site.)Links to an external
	 * site.. It is assumed that the file contains one word per line. If the file
	 * does not exist or is empty, the method returns an empty array because there
	 * are no anagrams.
	 * 
	 * @param scanner
	 * @return largestAngramGroup which we found from scanner
	 */
	public static String[] getLargestAnagramGroup(Scanner scanner) {

		ArrayList<String> Arr = new ArrayList<String>();// make a array list to store the String in scanner
		String[] emptyArray = new String [0];
		if(scanner == null||!scanner.hasNext()) {
			return emptyArray;// if the scanner is null or the file is empty, return false
		}
		
		while(scanner.hasNextLine()) {
			Arr.add(scanner.nextLine());
		}// add each string into the arr
		
//      for(String each: Arr) {
//  	  System.out.println(each);
//    }
		return getLargestAnagramGroup(Arr.toArray(new String[Arr.size()]));// call the above method to get the largest group
	}

	

}
