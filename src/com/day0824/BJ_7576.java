package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
	static int n,m,count;
	static int[][] graph;
	static boolean[][] visited;
	static Queue<int[]> matured;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[m][n];
		visited= new boolean[m][n];
		matured = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					matured.offer(new int[] {i,j,0});
					visited[i][j] = true;
				}
			}
		}
		bfs();
		int result = -1;
		boolean flag= true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0) {
					flag = false;
					break;
				}
				result = Math.max(result, graph[i][j]);
			}
			if (!flag) {
				break;
			}
		}
		if (flag) {
			if (result == 1) {
				System.out.println(0);
			}else {
				System.out.println(result);
			}
		}else {
			System.out.println(-1);
		}
	}
	private static void bfs() {
		while (!matured.isEmpty()) {
			int[] temp = matured.poll();
//			System.out.println(Arrays.toString(temp));
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (0>nx||0>ny||m<=nx||n<=ny||visited[nx][ny]||
						graph[nx][ny]!= 0) {
					continue;
				}
				graph[nx][ny] = temp[2]+1;
				visited[nx][ny] = true;
				matured.offer(new int[] {nx,ny,temp[2]+1});
				
			}
		
		}
	}

}
