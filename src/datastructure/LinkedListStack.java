package datastructure;

import java.util.EmptyStackException;

public class LinkedListStack {
	private class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public LinkedListStack() {
		top = null;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
	public int pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		int value = top.data;
		top = top.next;
		return value;
	}
	
	public int peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public int search(int value) {
		Node searchNode = top;
		int index = 1;
		while (true) {
			if (searchNode.data == value) {
				return index;
			} else {
				searchNode = searchNode.next;
				index++;
				if (searchNode == null) break;
			}
		}
		return -1;
	}
}
