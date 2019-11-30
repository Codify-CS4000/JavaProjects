package assignment09;
/**
 * this is the good functor method for the hash code
 * @author XI ZHENG
 *good hash function(reference:codereview.stackexchange.com)
 */
public class GoodHashFunctor implements HashFunctor{
	
		  public int hash(String item) { 
			  int hash=0;
			  for(int i=0;i<item.length();i++) {
				  hash=(hash*31+item.charAt(i));
			  }
			  
		    return hash; 
		  } 
		}

