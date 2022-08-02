package com.day0802;

import java.awt.font.LineBreakMeasurer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//농작물 수확하기
public class SWEA_2805 {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int limit;
	static int n;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 1; i <= test_case; i++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			visited = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				for (int k = 0; k < n; k++) {
					graph[j][k] = str.charAt(k)-'0';
				}
			}
			limit = n/2;
			sum = graph[limit][limit];
			visited[limit][limit] = true;
			System.out.println("#"+i+" "+dfs(limit,limit));
			
		}
	}
	public static int dfs(int a, int b) {
		for (int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			if (nx<0 || nx >= n || ny < 0 || ny>= n) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if ((Math.abs(nx-limit) + Math.abs(ny-limit)) > limit) {
				continue;
			}
			sum += graph[nx][ny];
			visited[nx][ny] = true;
			dfs(nx,ny);
		}
		return sum;
		
	}

}
