package com.day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	static int n,m,result;
	static int[][] graph;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static ArrayList<int[]> zero;
	static Queue<int[]> virus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		zero = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 0) zero.add(new int[] {i,j});
			}
		}
		per(0,0);
		System.out.println(result);
	}
	private static void per(int count, int index) {
		if(count == 3) {
			visited = new boolean[n][m];
			spread();
			result = Math.max(result, find());
			return;
		}
		for (int i = index; i < zero.size(); i++) {
			graph[zero.get(i)[0]][zero.get(i)[1]] = 1;
			per(count+1,i+1);
			graph[zero.get(i)[0]][zero.get(i)[1]] = 0;
		}
	}
	private static int find() {
		int r = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j] == 0&&!visited[i][j]) r++;
			}
		}
		return r;
	}
	private static void spread() {
		virus = new ArrayDeque<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		visited[virus.peek()[0]][virus.peek()[1]] = true;
		while (!virus.isEmpty()) {
			int[] temp = virus.poll();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m||graph[nx][ny] == 1||graph[nx][ny] == 2||visited[nx][ny]) continue;
				visited[nx][ny] = true;
				virus.offer(new int[] {nx,ny});
			}
		}
	}

}
