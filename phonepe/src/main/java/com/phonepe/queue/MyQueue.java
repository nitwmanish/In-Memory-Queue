package com.phonepe.queue;

public class MyQueue {

	private class ListNode {
		private String item;
		private ListNode next;
		private ListNode prev;

		public ListNode(String item) {
			this.item = item;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	private int currentSize;
	private ListNode head = null;
	private ListNode tail = null;

	public MyQueue(int capacity) {

		this.capacity = capacity;
		this.currentSize = 0;
		this.head = new ListNode(null);
		this.tail = new ListNode(null);
		this.head.next = tail;
		this.tail.prev = head;

	}

	private void addToTail(ListNode node) {
		node.next = tail;
		tail.prev.next = node;
		node.prev = tail.prev;
		tail.prev = node;
	}

	private void removeFromLinkedList(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public boolean isFull() {
		if (this.currentSize == this.capacity) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (this.currentSize == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.currentSize;
	}

	public void enQueue(String item) {
		if (this.currentSize < this.capacity) {
			ListNode node = new ListNode(item);
			addToTail(node);
			this.currentSize++;

		}
	}

	public String deQueue() throws InterruptedException {
		if (this.currentSize > 0) {
			String item = head.next.item;
			removeFromLinkedList(head.next);
			this.currentSize--;
			return item;
		}
		return null;
	}
}
