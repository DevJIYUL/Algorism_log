package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_5645 {
	static int test_case,m,a,result;
	static int[] scoreA,scoreB,userA,userB,dx = {0,-1,0,1,0},dy = {0,0,1,0,-1};
	static int[][] A;
	static boolean[][] isOn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= test_case; test++) {
			st = new StringTokenizer(br.readLine().trim());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			userA = new int[m];
			userB = new int[m];
			scoreA = new int[m+1];
			scoreB = new int[m+1];
			result = 0;
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
			A = new int[a][4];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 4; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(Arrays.toString(userA));
			System.out.println(Arrays.toString(userB));
			int ax = 0,ay = 0,bx =9,by = 9;
			cal(ax,ay,bx,by);
			
			for (int i = 0; i < m; i++) {
				ax = ax +dx[userA[i]];
				ay = ay +dy[userA[i]];
				bx = bx +dx[userB[i]];
				by = by +dy[userB[i]];
				cal(ax,ay,bx,by);
			}
			System.out.println("#"+test+" "+result);
			
		}
		
		
	}
	private static void cal(int ax, int ay, int bx, int by) {
		isOn = new boolean[2][a];
		for (int i = 0; i < a; i++) {
			int e = Math.abs(A[i][0]-ax) + Math.abs(A[i][1] - ay); 
			int w = Math.abs(A[i][0]-bx) + Math.abs(A[i][1] - by); 
			int distance = A[i][2];
			if (e <= distance) {
				isOn[0][i] = true;
			}
			if (w <= distance) {
				isOn[1][i] = true;
			}
			int tempA = 0;
			int tempB = 0;
			for (int j = 0; j < a; j++) {
				if (isOn[0][j] && isOn[1][j]) {
					continue;
				}
				if (isOn[0][j]) {
					tempA = Math.max(tempA, A[j][3]);
				}else if (isOn[1][j]) {
					tempB = Math.max(tempB, A[j][3]);
				}
			}
			int value = 0;
			for (int j = 0; j < a; j++) {
				if (isOn[0][j] && isOn[1][j]) {
					value = Math.max(tempA+tempB, tempA+A[j][3]);
					value = Math.max(value, tempB+A[j][3]);
				}
			}
			result += value;
			System.out.println(result);
		}
		
	}
}
