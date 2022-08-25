package com.Node;

public class StackTest {

	public static void main(String[] args) {
		SsafyStack<Integer> s = new SsafyStack<>();
		s.push(5);
		s.push(10);
		System.out.println(s.peek());
	}

}
