package com.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BJ_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[101][101];
		int count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int maxX = x+10;
			int maxY = y + 10;
			if (maxX > 100) {
				maxX = 100;
			}
			if (maxY > 100) {
				maxY = 100;
			}
	
			for (int j = x; j < maxX; j++) {
				for (int j2 = y; j2 < maxY; j2++) {
					graph[j][j2] = true;
				}
			}
		}
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
