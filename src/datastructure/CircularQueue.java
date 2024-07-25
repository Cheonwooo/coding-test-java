package datastructure;

public class CircularQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] queueArray;
	
	public CircularQueue(int size) {
		maxSize = size;
		queueArray = new int[maxSize];
		front = 0;
		rear = -1;
	}
	
	public void enqueue(int value) {
		if ((rear + 1) % maxSize == front) {
			throw new RuntimeException("Queue is Full");
		}
		rear = (rear + 1) % maxSize;
		queueArray[rear] = value;
	}
	
	public int dequeue() {
		if (front == (rear + 1) % maxSize) {
			throw new RuntimeException("Queue is Empty");
		}
		int value = queueArray[front];
		front = (rear + 1) % maxSize;
		return value;
	}
	
	public int peek() {
		if (front == (rear + 1) % maxSize) {
			throw new RuntimeException("Queue is Empty");
		}
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return (front == (rear + 1) % maxSize);
	}
}
