package com.phonepe.consumer;

import com.phonepe.queue.Worker;

public class Consumer implements Runnable {

	private Worker worker;
	private String consumeType;

	public Consumer(Worker worker, String consumeType) {
		this.worker = worker;
		this.consumeType = consumeType;
	}

	public void consume() {
		try {
			worker.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getConsumeType() {
		return consumeType;
	}

	public void setConsumeType(String consumeType) {
		this.consumeType = consumeType;
	}

	public void run() {
		while (true) {
			consume();
		}

	}

}
