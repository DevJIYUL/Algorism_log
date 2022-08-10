package com.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 돌리기 1
public class BJ_16926 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int[] is : graph) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println("---------------------------------------------------------------");
		int count = Math.min(n, m)/2;
//		System.out.println("count :" + count);
		for (int z = 0; z < r; z++) {
			for (int i = 0; i < count; i++) {
				int temp = graph[i][i];
				for (int j = i; j < m-i-1; j++) {
					graph[i][j] = graph[i][j+1];
				}
				for (int j = i; j < n-i-1; j++) {
					graph[j][m-i-1] = graph[j+1][m-i-1];
				}
				for (int j = m-i-1; j > i; j--) {
					graph[n-i-1][j] = graph[n-i-1][j-1];
				}
				for (int j = n-i-1; j > i; j--) {
					graph[j][i] =  graph[j-1][i];
				}
				graph[i+1][i] = temp;
			}
		}
		for (int[] is : graph) {
			for (int j = 0; j < is.length; j++) {
				sb.append(is[j]);
				if (j == is.length-1) continue;
				sb.append(' ');
			} 
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
