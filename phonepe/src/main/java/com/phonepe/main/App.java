package com.phonepe.main;

import com.phonepe.consumer.Consumer;
import com.phonepe.producer.Producer;
import com.phonepe.queue.Worker;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Worker worker = new Worker(3);
		Consumer consumerA = new Consumer(worker, "200");
		Consumer consumerB = new Consumer(worker, "");
		Producer Producer = new Producer(worker);
		Thread t1 = new Thread(consumerA, "consumer A");
		Thread t2 = new Thread(consumerB, "consumer B");
		Thread t3 = new Thread(Producer, "Producer");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
