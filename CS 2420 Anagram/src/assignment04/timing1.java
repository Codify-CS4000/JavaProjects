package assignment04;


	import java.util.Arrays;
import java.util.Random;


	public class timing1 {
		private static final int ITER_COUNT = 100;
		//private final static int ITER = 10;    
		private final static int NSTART = 1000;
		private final static int NSTOP = 10000;
		private final static int NINCR = 1000;

		
//			public static void main(String[] args) { 		
//				double[] basicArrayTimes = timeBasicArray();
//				//String[] arrayListTimes = timeArrayList();
//				
//				for(int i = 0, N = NSTART; i < basicArrayTimes.length; i++, N += NINCR) 
//					System.out.println(N + "\t" + basicArrayTimes[i]);
//			}
			
			//private static void main timeBasicArray() {
		public static void main(String[] args) {
				
			//	Random rng = new Random(12345);
				long totalTime = 0;
				double[] times = new double[(NSTOP - NSTART) / NINCR + 1];
				int count = 0;
			
				for(int N = NSTART; N <= NSTOP; N += NINCR) { 
					String []a = new String [N];
					// Build an array of random integers 
					// (Notice how it will be randomly ordered and may contain duplicates)
					for(int i =0;i<N;i++) {
					        a[i] = getRandomString(5);
					       
					}
//					String a = getRandomString(N);
//					String b = getRandomString(N);
//					
						
						// TIME IT!
						long start = System.nanoTime();
						Arrays.sort(AnagramUtil.getLargestAnagramGroup(a));
						long stop = System.nanoTime();
						totalTime += stop - start;
						
			
			
					double averageTime = totalTime / (double)ITER_COUNT;
					System.out.println(N+ "\t" + averageTime); // print to console
					System.out.println(483278%9);
				}
					//times[count++] = averageTime;
			
			//return times;
					
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


