package com.day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2239 {
	static int[][] graph;
	static ArrayList<int[]> zero;
	static boolean flag;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		graph = new int[9][9];
		zero = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
//			st = new StringTokenizer(br.readLine().trim());
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				graph[i][j] = str.charAt(j)-'0';
				if(graph[i][j] == 0) zero.add(new int[] {i,j});
			}
		}
		per(0);
	}
	private static void per(int count) {
//		System.out.println("------------------------");
		if(flag) return;
		if(count == zero.size()) {
//			if(isGood()) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
//			}
			return;
		}
		boolean[] can = valid(zero.get(count)[0],zero.get(count)[1]);
		for (int i = 1; i < 10; i++) {
			if(can[i])continue;
			graph[zero.get(count)[0]][zero.get(count)[1]] = i;
			per(count+1);
			graph[zero.get(count)[0]][zero.get(count)[1]] = 0;
		}
	}
	private static boolean[] valid(int i, int j) {
		boolean[] good = new boolean[10];
		// 가로
		for (int k = 0; k < 9; k++) {
			if(graph[i][k]==0)continue;
//			if(good[graph[i][k]]) return false;
			good[graph[i][k]] = true;
		}
		// 세로
//		good = new boolean[10];
		for (int k = 0; k < 9; k++) {
			if(graph[k][j]==0) continue;
//			if(good[graph[k][j]]) return false;
			good[graph[k][j]] = true;
		}
//		good = new boolean[10];
		int a = (i/3)*3+j/3;
		int x = (a/3)*3;
		int y = (a%3)*3;
		for (int k = x; k < x+3; k++) {
			for (int k2 = y; k2 < y+3; k2++) {
				if(graph[k][k2] == 0)continue;
//				if(good[graph[k][k2]]) return false;
				good[graph[k][k2]] = true;
			}
		}
		return good;
	}
	private static boolean isGood() {
		boolean[] good = new boolean[10];
		
		//가로
		for (int i = 0; i < 9; i++) {
			good = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if(good[graph[i][j]]) return false;
				good[graph[i][j]] = true;
			}
		}
		//세로
		for (int i = 0; i < 9; i++) {
			good = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if(good[graph[j][i]]) return false;
				good[graph[j][i]] = true;
			}
		}
		//cell
		for (int i = 0; i < 9; i++) {
			good = new boolean[10];
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					if(good[graph[(i%3)*3+j][(i/3)*3+j2]]) return false;
					good[graph[(i%3)*3+j][(i/3)*3+j2]] = true;
				}
			}
		}
		return true;
	}

}
