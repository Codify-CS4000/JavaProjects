package assignment09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class checkForCollision {

	
// this class is used to check collisons
	public static void main(String [] args) {
	int count=0;
	//	BadHashFunctor fun= new BadHashFunctor();
	MediocreHashFunctor fun= new MediocreHashFunctor();
		//GoodHashFunctor fun = new GoodHashFunctor();
        //for(int exp = 2500; exp <= 50000; exp+=2500) { 
        //int size = exp;
		int size=100;
			ArrayList<String> tester = new ArrayList();
			for (int i = 0; i < (size/2)-1; i++){
				long start = System.nanoTime();
				fun.hash(String.valueOf(i));
				long total = System.nanoTime()-start;
				System.out.println("	"+total);
			}
		}
	}

		//MediocreHashFunctor fun= new MediocreHashFunctor();

//		LinkedList<String>[] storage = (LinkedList<String>[]) new LinkedList[1000000];
//		for(int c=0;c<storage.length;c++) {
//			storage[c]= new LinkedList<String>();
//		}
//		//ChainingHashTable table= new ChainingHashTable(1000, fun);
//		ArrayList<String> List = new ArrayList<String>();
//		for(long z=0;z<8774;z++) {
//			List.add(String.valueOf(z));
//		}
//		
//		long start = System.nanoTime();
//	 for(int j=0;j<List.size();j++) {
//		int a =  fun.hash(List.get(j))%storage.length;
//	 }
//		long stop = System.nanoTime();
//		long totalTime=stop-start;
//		System.out.println(totalTime);
//		 //storage[a].add( List.get(j));
//		 
//	 
//	 for(int j=0;j<storage.length;j++) {
//		 if(storage[j].size()!=0 && storage[j].size()!=1) {
//			// System.out.println(storage[j].size());
//			  count = count+(storage[j].size()-1);
//		 }
//	 }
////	 System.out.println("size:"+storage.length);
////	 System.out.println("collisions:"+count);
//	}
	
	
 		
	
	
