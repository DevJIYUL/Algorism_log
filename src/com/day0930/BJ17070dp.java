package com.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 파이프 옮기기 2
public class BJ17070dp {
	static int n,result;
	static int[][] graph;
	static int[][][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		graph  = new int[n+1][n+1];
		d = new int[n+1][n+1][3];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j < n+1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < n+1; i++) {
			if(graph[1][i] == 1)break;
			d[1][i][0] = 1;
		}
		d[1][2][0] = 1;
		for (int i = 1; i < n+1; i++) {
			for (int j = 3; j < n+1; j++) {
				if(graph[i][j] == 1)continue;
				int left = d[i][j-1][0]+ d[i][j-1][2];
				int leftup = d[i-1][j-1][0]+ d[i-1][j-1][1]+d[i-1][j-1][2];
				int up= d[i-1][j][1] + d[i-1][j][2];
				d[i][j][0] = left;
				d[i][j][1] = up;
				if(graph[i-1][j-1] == 1||graph[i-1][j] == 1||graph[i][j-1] == 1)continue;
				d[i][j][2] = leftup;
			}
		}
		System.out.println(d[n][n][0]+d[n][n][1]+d[n][n][2]);

	}
}
