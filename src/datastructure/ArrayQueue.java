package datastructure;

public class ArrayQueue {
	int maxSize;
	int[] arrayQueue = new int[maxSize];
	int front = 0;
	int rear = -1;
	
	public void enqueue(int value) {
		if (rear == maxSize - 1) {
			throw new RuntimeException("Queue is Full");
		}
		arrayQueue[++rear] = value;
	}
	
	public int dequeue() {
		if (front > rear) {
			throw new RuntimeException("Queue is Empty");
		}
		return arrayQueue[front++];
	}
	
	public int peek() {
		if (front > rear) {
			throw new RuntimeException("Queue is Empty");
		}
		return arrayQueue[front];
	}
	
	public boolean isEmpty() {
		return (front > rear);
	}
}
