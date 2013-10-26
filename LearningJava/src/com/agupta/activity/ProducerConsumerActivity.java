package com.agupta.activity;

import com.agupta.deadlock.Consumer;
import com.agupta.deadlock.Drop;
import com.agupta.deadlock.Producer;

public class ProducerConsumerActivity {
	public static void main(String args[]) {
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}