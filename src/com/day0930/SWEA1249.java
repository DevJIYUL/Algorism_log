package com.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 보급로
public class SWEA1249 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int t,n;
	static int[][] graph,visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			visited = new int[n][n];
			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = str.charAt(j2)-'0';
					visited[j][j2] = Integer.MAX_VALUE;
				}
			}
			bfs();
			System.out.println("#"+i+" "+visited[n-1][n-1]);
			
			
			
		}
	}
	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0));
		visited[0][0] = 0;
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n)continue;
				if(visited[nx][ny]>visited[x][y]+graph[x][y]) {
					visited[nx][ny] = visited[x][y]+graph[x][y];
					queue.add(new Point(nx, ny));
				}
			}
		}
	}

}
