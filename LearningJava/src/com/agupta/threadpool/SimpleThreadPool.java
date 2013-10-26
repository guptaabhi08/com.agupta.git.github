package com.agupta.threadpool;

import java.util.Arrays;
import java.util.List;

public class SimpleThreadPool {
	public static void main(final String args[]) {
		String[] stringArray = {"A1","b1","c1","d1","A2","b2","c2","d2","A3","b3","c3","d3"};
		List<String> stringList = Arrays.asList(stringArray);
	//	Thread t = new Thread();
		for(int i =1;i<6;i++) {
			WorkerThread worker = new WorkerThread(Integer.toString(i), stringList);
			worker.startThread();
		}
		WorkerThread worker = new WorkerThread(Integer.toString(6), stringList);
		worker.startThread();
		System.out.println("Finished all threads");
	}
}