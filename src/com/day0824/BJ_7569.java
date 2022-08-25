package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {
	static int m,n,h;
	static int[][][] graph;
	static boolean[][][] visited;
	static Queue<int[]> queue;
	static int[] dz = {0,0,0,0,1,-1};
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dy = {1,0,-1,0,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		m = Integer.parseInt(st.nextToken());//5
		n = Integer.parseInt(st.nextToken());//3
		h = Integer.parseInt(st.nextToken());
		queue = new LinkedList<int[]>();
		graph = new int[h][n][m];
		visited = new boolean[h][n][m];
		boolean fresh = false;
		for (int z = 0; z < h; z++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < m; j++) {
					graph[z][i][j] = Integer.parseInt(st.nextToken());
					if (graph[z][i][j] == 1) {
						queue.offer(new int[] {z,i,j});
						visited[z][i][j] = true;

					}
					if (graph[z][i][j] == 0) {
						fresh = true;
					}
				}
			}
		}
		if (!fresh) {
			System.out.println(0);
			return;
		}
		bfs();
		int value = -100;
		boolean isZero = false;
		for (int z = 0; z < h; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					value = Math.max(value, (graph[z][x][y]));
					if (graph[z][x][y] == 0) {
						isZero = true;
					}
				}
			}
		}
		if (isZero) {
			System.out.println(-1);
		}else {
			System.out.println(value-1);
		}
	}
	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int i = 0; i < 6; i++) {
				int nz = temp[0] + dz[i];
				int nx = temp[1] + dx[i];
				int ny = temp[2] + dy[i];
				if (0>nz||0>nx||0>ny||nz>=h||nx>=n||ny>=m||visited[nz][nx][ny]||graph[nz][nx][ny] != 0) {
					continue;
				}
				visited[nz][nx][ny] = true;
				graph[nz][nx][ny] = graph[temp[0]][temp[1]][temp[2]] + 1;
				queue.offer(new int[] {nz,nx,ny});
			}
			
		}
		
	}

}
