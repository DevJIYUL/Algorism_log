package com.day0818;

import java.util.Scanner;

public class AdjListTest {
	static class Node{
		int to;
		Node next;
		//가중이 있다면 가중치 정의
		public Node(int to,Node next) {
			this.to = to;
			this.next = next;
		}
	}
	static Node[] adjList;
	static int[][] adjMatrix;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int e = sc.nextInt();
		
		adjList = new Node[n];
		
		for (int i = 0; i < e; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		boolean[] visited = new boolean[n]; // 방문 관리 배열

		dfs(0,visited);
	}

	private static void dfs(int cur,boolean[] visited) {
		visited[cur] = true;
		System.out.print((char)(cur+'A'));
		for (Node temp = adjList[cur];temp != null;temp = temp.next) {
			if (!visited[temp.to]) {
				dfs(temp.to,visited);
			}
		}
		
	}

}
