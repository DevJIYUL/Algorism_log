package com.day0811;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;

	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size + 1];
	}

	public boolean add(char e) {// 완전 이진 트리에 맞게 추가
		if (lastIndex == SIZE) {
			return false;
		}
		nodes[++lastIndex] = e;
		return true;
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		System.out.println(queue.size());
		queue.offer(1); // 루트노드 인덱스 부터
		
		while (!queue.isEmpty()) { // 방문 대상이 있을때 까지 반복
			int current = queue.poll(); // 방문 차례 대상꺼내기
			System.out.print(nodes[current]+" ");
			
			// 현재 방문노드의 자식 노드들을 대기열에 넣기
			if (current*2 <= lastIndex) queue.offer(current*2);// 왼쪽 자식
			if (current*2+1 <= lastIndex) queue.offer(current*2+1);// 오른쪽 자식
			
		}
		System.out.println();
	}
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 루트노드 인덱스 부터
		
		while (!queue.isEmpty()) { // 방문 대상이 있을때 까지 반복
			int size = queue.size(); // 큐 크기 확인
			
			while (--size >= 0) {// 반복 진입 전 구한 큐 크기 만큼만 반복
				int current = queue.poll(); // 방문 차례 대상꺼내기
				System.out.print(nodes[current]+" ");
				
				// 현재 방문노드의 자식 노드들을 대기열에 넣기
				if (current*2 <= lastIndex) queue.offer(current*2);// 왼쪽 자식
				if (current*2+1 <= lastIndex) queue.offer(current*2+1);// 오른쪽 자식
			}
			System.out.println();
		}
		System.out.println();
	}
	public void dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1); // 루트노드 인덱스 부터
		
		while (!stack.isEmpty()) { // 방문 대상이 있을때 까지 반복
			int current = stack.pop(); // 방문 차례 대상꺼내기
			System.out.print(nodes[current]+" ");
			
			// 현재 방문노드의 자식 노드들을 대기열에 넣기
			if (current*2 <= lastIndex) stack.push(current*2);// 왼쪽 자식
			if (current*2+1 <= lastIndex) stack.push(current*2+1);// 오른쪽 자식
			
		}
		System.out.println();
	}
	public void dfsByPreOrder(int current) {
		System.out.print(nodes[current]+" ");
		if (current*2 <= lastIndex) dfsByPreOrder(current*2);
		if (current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
	}

	public void dfsByInOrder(int current) {
		if (current*2 <= lastIndex) dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		if (current*2+1 <= lastIndex) dfsByInOrder(current*2+1);
	}
	public void dfsByPostOrder(int current) {
		if (current*2 <= lastIndex) dfsByPostOrder(current*2);
		if (current*2+1 <= lastIndex) dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
	}
		
}
