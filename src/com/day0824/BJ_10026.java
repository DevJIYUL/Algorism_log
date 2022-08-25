package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BJ_10026 {
	static int n;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		graph = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			graph[i] = st.nextToken().toCharArray();
		}
		visited = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (!visited[i][j]) {
					rgb(i,j,graph[i][j]);
					count++;
					
				}
			}
		}
		visited = new boolean[n][n];
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 'B' && !visited[i][j]) {
					rgb(i,j,'B');
					count2++;
				}else if (!visited[i][j]) {
					errrgb(i,j);
					count2++;
				}
		
			}
		}
		
		System.out.println(count+" "+count2);
	}
	
	private static void errrgb(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0] + dx[k];
				int ny = temp[1] + dy[k];
				if (nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]||graph[nx][ny] =='B') {
					continue;
				}
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
			}
		}
	}

	private static void rgb(int i,int j,char stand) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0] + dx[k];
				int ny = temp[1] + dy[k];
				if (0>nx||0>ny||nx>=n||ny>=n||graph[nx][ny] != stand||visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
			}
		}
	}

}
