package com.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1263 {
	static int t,n,INF = 100000;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine().trim());
			graph = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());
					if(graph[j][j2] == 0 && j2 != j) graph[j][j2] = INF;
				}
			}
			for (int k = 0; k < n; k++) {
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < n; b++) {
						graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
					}
				}
			}
			int max = Integer.MAX_VALUE ;
			for (int j = 0; j < n; j++) {
				int plus = 0;
				for (int k = 0; k < n; k++) {
					plus += graph[j][k];
				}
				max = Math.min(max, plus);
			}
			System.out.println("#"+i+" "+max);
		}

	}

}
