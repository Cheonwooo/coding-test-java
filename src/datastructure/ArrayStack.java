package datastructure;

import java.util.EmptyStackException;

public class ArrayStack {
	int maxSize;
	int top;
	int[] arrayStack;
	
	public ArrayStack(int size) {
		maxSize = size;
		top = -1;
		arrayStack = new int[maxSize];
	}
	
	public void push(int value) {
		if (top == maxSize - 1) {
			throw new StackOverflowError("Stack is Full");
		}
		arrayStack[++top] = value;
	}
	
	public int pop() {
		if (top == -1) {
			throw new EmptyStackException();
		}
		return arrayStack[top--];
	}
	
	public int peek() {
		if (top == -1) {
			throw new EmptyStackException();
		}
		return arrayStack[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	public int search(int value) {
		for (int i = 0; i <= top; i++) {
			if (arrayStack[i] == value) {
				return (top - i) + 1;
			}
		}
		return -1;
	}
}
