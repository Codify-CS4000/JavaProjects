package assignment09;
/**
 * @author XI ZHENG
 */
import java.util.ArrayList;
import java.util.Random;

public class timing {
	private static final int ITER_COUNT = 100;
	private static final int COUNT = 5000;
	public static void main(String[] args) {
		
		//long startTime = System.nanoTime();
//		while (System.nanoTime() - startTime < 1_000_000_000);
		
			Random random = new Random();
			for(int exp = 2500; exp <= 50000; exp+=2500) { 
				int size = exp;
				ArrayList<String> tester = new ArrayList();
				//for (int i = 0; i < (size/2)-1; i++){
				for (int i = 0; i < COUNT; i++) {
					int a = random.nextInt(500);
					tester.add(getRandomString(a));
				}
				HashFunctor fun= new GoodHashFunctor();
			//	HashFunctor fun= new BadHashFunctor();
			//HashFunctor fun = new MediocreHashFunctor();
				//QuadProbeHashTable QPT = new QuadProbeHashTable(size, fun);
				//ChainingHashTable SCT = new ChainingHashTable(size, fun);
				long totalTime = 0;
				
				for (int iter = 0; iter < ITER_COUNT; iter++) {
										
					// TIME IT!
					long start = System.nanoTime();
					int a = random.nextInt(500);
					
					//QPT.addAll(tester);
				//SCT.addAll(tester);
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
				double averageTime = totalTime / (double)ITER_COUNT;
				System.out.println(size + "\t" +(averageTime / 1000000) );
//				System.out.println(size + "\t" + (averageTime / 1000000) + "\t"+QPT.CountCollisions() ); // print to console
			}
	}
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     Random random=new Random();
	     StringBuffer randomStr=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(52);
	       randomStr.append(str.charAt(number));
	     }
	     return randomStr.toString();
	}

}
