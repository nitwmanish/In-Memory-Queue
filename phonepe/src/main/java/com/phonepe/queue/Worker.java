package com.phonepe.queue;

import com.google.gson.Gson;
import com.phonepe.model.Message;

public class Worker {
	private Gson gson;
	private MyQueue queue;

	public Worker(int queueSize) {
		this.gson = new Gson();
		this.queue = new MyQueue(queueSize);
	}

	public void produce(Message msg) throws InterruptedException {
		String strMsg = gson.toJson(msg);
		while (true) {
			synchronized (this) {
				while (queue.isFull()) {
					wait();
				}
				System.out.println(Thread.currentThread().getName() + " is going to write message " + strMsg);
				System.out.println("queue size before write is " + queue.size());
				queue.enQueue(strMsg);
				System.out.println("queue size after write is " + queue.size());
				System.out.println(Thread.currentThread().getName() + " completed writing message " + strMsg);
				notifyAll();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (queue.isEmpty()) {
					wait();
				}
				System.out.println(Thread.currentThread().getName() + " is going to read message ");
				System.out.println("queue size before read is " + queue.size());
				String msg = queue.deQueue();
				System.out.println("queue size after read is " + queue.size());
				System.out.println(Thread.currentThread().getName() + " is completed reading message " + msg);
				notify();
				Thread.sleep(1000);
			}
		}
	}
}
