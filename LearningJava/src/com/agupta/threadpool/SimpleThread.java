package com.agupta.threadpool;

public class SimpleThread {
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	private static class MessageLoop implements Runnable{
		public void run() {
			String importantInfo[] = {
					"Mares eat oats",
					"Does eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};
			try {
				for(int i = 0; i< importantInfo.length;i++) {
					Thread.sleep(4000);
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!!");
			}
		}
	}
	
	public static void main(final String arg[]) throws InterruptedException{
		long patience = 10 * 1000;
		threadMessage("Starting MessageLoop Thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		while(t.isAlive()) {
			threadMessage("Still Waiting");
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience)
					&& t.isAlive()){
				threadMessage("Tired of Waiting!!");
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally!! Total Time taken : " + (System.currentTimeMillis() - startTime));
	}
}
