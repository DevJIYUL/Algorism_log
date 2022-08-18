package com.day0818;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	
	static int[][] adjMatrix;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int e = sc.nextInt();
		adjMatrix = new int[n][n]; // 0으로 초기화 됨
		for (int i = 0; i < e; i++) { // 간선 정보에 해당하는 부분만 덮어 씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
//		bfs();
		boolean[] visited = new boolean[n]; // 방문 관리 배열
		dfs(0,visited);
//		7
//		8
//		0 1
//		0 2
//		1 3
//		1 4
//		3 5
//		4 5
//		5 6
//		2 6
	}
	public static void dfs(int cur,boolean[] visited) {
		visited[cur] = true;
		System.out.print((char)(cur+'A'));
		for (int i = 0; i < n; i++) {
			if (!visited[i] && adjMatrix[cur][i] == 1) {
				dfs(i,visited);
			}
		}
	}
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[n]; // 방문 관리 배열
		
		visited[0] = true;
		queue.offer(0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print((char)(cur+'A'));
			
			for (int i = 0; i < adjMatrix[cur].length; i++) {
				if (!visited[i] && adjMatrix[cur][i] == 1) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}
}
