package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 쿼드 트리
public class BJ_1992 {
	static int n;
	static int[][] graph;
	static String result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < graph.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		for (int[] string : graph) {
			System.out.println(Arrays.toString(string));
		}
		result = "";
		press(0,0,n,n);
		System.out.println(result);
	}
	private static void press(int ax, int ay, int bx, int by) {
		if (ax - bx == 1 && ay - by == 1) {
			for (int i = ax; i < bx; i++) {
				for (int j = ay; j < by; j++) {
					result += graph[i][j]+"";
				}
			}
			return;
		}
		int comparer = graph[ax][ay];
		boolean flag = true;
		for (int i = ax; i < bx; i++) {
			for (int j = ay; j < by; j++) {
				if (graph[i][j] != comparer) {
					flag = false;
				}
			}
		}
		if (flag) {
			result += comparer+"";
			return ;
		}else {
			result += "(";
			press(ax,ay,(ax+bx)/2,(ay+by)/2);
			press(ax,(ay+by)/2,(ax+bx)/2,by);
			press((ax+bx)/2,ay,bx,(ay+by)/2);
			press((ax+bx)/2,(ay+by)/2,bx,by);
			result += ")";
		}
	}

}
