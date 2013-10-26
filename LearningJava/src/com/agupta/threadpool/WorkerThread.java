package com.agupta.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerThread implements Runnable{
	private List<String> stringList = new ArrayList<>();
	private static volatile int count = -1;
	private String command;
	private Thread t;
	
	public WorkerThread(String s, List<String> stringList2) {
		this.command = s;
		this.stringList = stringList2;
		t = new Thread(this,"Dummy thread " + s);
	}
	
	public void startThread() {
		t.start();
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" Start. Command = "+command);
		processCommand();
		System.out.println(threadName+" End. Command = "+command);
	}
	
	private void processCommand() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int index = ++count;
			if( index >= stringList.size()) {
				t.stop();
			}
			System.out.println("String list value : " + stringList.get(index));
			
		}
	}
	
	public String toString() {
		return this.command;
	}

}
