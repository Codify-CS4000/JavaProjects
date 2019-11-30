package assignment09;

/**
 * this is the mediocre hash functor to get hash code
 *   medium hash function, use the ASCII code
 * @author XI ZHENG
 *
 */
public class MediocreHashFunctor implements HashFunctor{
	 public int hash(String item) { 
		  int hash=0;
		  for(int i=0;i<item.length();i++) {
			  hash = hash + item.charAt(i);
		  }
		 
	    return hash; 
	 }
}
