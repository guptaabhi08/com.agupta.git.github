package com.agupta.activity;

/**
 * @author agupta
 *
 */
public class CounterActivity {
	private static int count = 0;
	
	private static void increment() {
		count++;
	}
	
	private static void decrement() {
		count--;
	}
	
	private static class CounterThread implements Runnable{

		@Override
		public void run() {
			if (count%2 != 0) {
				increment();
				printMessage();
			} else {
				decrement();
				printMessage();
			}
		}
		
		private static void printMessage() {
			System.out.println("Value of counter for thread " + 
					Thread.currentThread().getName() + " is : " + count);
		}
	}
	
	
	
	public static void main(final String args[]) {
		int mb = 1024*1024;
        
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
         
        System.out.println("##### Heap utilization statistics [MB] #####");
         
        //Print used memory
        System.out.println("Used Memory:"
            + (runtime.totalMemory() - runtime.freeMemory()) / mb);
 
        //Print free memory
        System.out.println("Free Memory:"
            + runtime.freeMemory() / mb);
         
        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
 
        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
	}
}