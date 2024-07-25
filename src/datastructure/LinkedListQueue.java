package datastructure;

public class LinkedListQueue {
	private class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data =data;
		}
	}
	
	private Node front;
	private Node rear;
	
	public LinkedListQueue() {
		front = null;
		rear = null;
	}
	
	public void enqueue(int value) {
		Node newNode = new Node(value);
		
		if (rear != null) {
			rear.next = newNode;
		}
		rear = newNode;
		if (front == null) {
			front = newNode;
		}
	}
	
	public int dequeue() {
		if (front == null) {
			throw new RuntimeException("Queue is Empty");
		}
		
		int value = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		return value;
	}
	
	public int peek() {
		if (front == null) {
			throw new RuntimeException("Queue is Empty");
		}
		return front.data;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
}
