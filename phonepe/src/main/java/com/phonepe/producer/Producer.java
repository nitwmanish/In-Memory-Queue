package com.phonepe.producer;

import java.util.HashMap;
import java.util.Map;

import com.phonepe.model.Message;
import com.phonepe.queue.Worker;

public class Producer implements Runnable {
	private Worker worker;

	public Producer(Worker worker) {
		this.worker = worker;
	}

	public void produce(Message msg) {
		try {
			worker.produce(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			int[] table = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					't', 'u', 'v', 'w', 'x', 'y', 'z' };
			for (int i = 0; i < 23; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = i; j < 3; j++) {
					sb.append((char) table[j]);
				}
				Map<String, String> data = new HashMap<String, String>();
				Message msg = new Message(sb.toString(), data);
				produce(msg);
			}
		}

	}

}
