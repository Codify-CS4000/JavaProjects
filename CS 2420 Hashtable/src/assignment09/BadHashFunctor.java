package assignment09;
/**
 *  bad hash function, use length of the string
 * @author XI ZHENG
 *
 */
public class BadHashFunctor implements HashFunctor {
	 public int hash(String item) { 
		  int hash=0;
		  hash=(int)(item.length());
		  return hash; 
	 }

}
