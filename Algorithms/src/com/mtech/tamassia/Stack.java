package com.mtech.tamassia;

import java.util.Random;

public class Stack {
	private static final int ARRAY_MAX_SIZE = 100;
	int[] data;
	int top;
	int size;
	
	public Stack() {
		data = new int[ARRAY_MAX_SIZE];
		top = -1;
		size = 0;
	}
	
	public void push(int o) {
		if (top == data.length-1) {
			System.out.println("The stack is Full!");
		} else {
			data[++top] = o;
			++size;
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("The stack is empty!!");
			return -1;
		}
		--size;
		return data[top--];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
	
	public int top() {
		if (isEmpty()) {
			System.out.println("The stack is Empty!");
			return -1;
		}
		return data[top];
	}
	
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		int[] data = new int[10];
		Stack s = new Stack();
		s.pop();
		s.top();
		Thread.sleep(30000);
		System.out.println("size of the stack is "+s.size());
		for (int i=0;i<data.length;++i) {
			data[i] = r.nextInt(10);
			System.out.println("pushing the data "+data[i]+" into the stack");
			s.push(data[i]);
		}
		while (true) {
			int dat = s.pop();
			if (dat == -1)
				break;
			System.out.println("popped the data "+dat+" from the stack");
		} 
	}

}
