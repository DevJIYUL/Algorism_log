package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_5644_CoordinateList {
	static int test_case, m, a, result;
	static int[] scoreA, scoreB, userA, userB, dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };
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
			scoreA = new int[m + 1];
			scoreB = new int[m + 1];
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
//			System.out.println(Arrays.toString(userA));
//			System.out.println(Arrays.toString(userB));
			int ax = 0, ay = 0, bx = 9, by = 9;
			cal(ax, ay, bx, by, m);

			for (int i = 0; i < m; i++) {
				ax = ax + dx[userA[i]];
				ay = ay + dy[userA[i]];
				bx = bx + dx[userB[i]];
				by = by + dy[userB[i]];
//				System.out.println("ax : "+ax+" ay : "+ay+" bx : "+bx+" by : "+by);
				cal(ax, ay, bx, by, i);
			}
			System.out.println("#" + test + " " + result);

		}

	}

	private static void cal(int ax, int ay, int bx, int by, int d) {
		isOn = new boolean[2][a];
		// 베터리의 영향력에 있는 지 확인
		for (int i = 0; i < a; i++) {
			int e = Math.abs(A[i][1]-1 - ax) + Math.abs(A[i][0]-1 - ay);
			int w = Math.abs(A[i][1]-1 - bx) + Math.abs(A[i][0]-1 - by);
//			System.out.println("e : "+e+" w : "+w );
			
			int distance = A[i][2];
			if (e <= distance) {
				isOn[0][i] = true;
			}
			if (w <= distance) {
				isOn[1][i] = true;
			}
		}
//		for (int j = 0; j < isOn.length; j++) {
//			for (int j2 = 0; j2 < isOn[j].length; j2++) {
//				System.out.print(isOn[j][j2] + " ");
//			}
//			System.out.println();
//		}
		int value = 0;
		for (int i = 0; i < isOn[0].length; i++) {
			for (int j = 0; j < isOn[1].length; j++) {
				if (isOn[0][i] && isOn[1][j]) {
					if (i == j) {
						value = Math.max(value, A[i][3]);
					}else {
						value = Math.max(value, A[i][3]+A[j][3]);
					}
				}else if (isOn[0][i]) {
					value = Math.max(value, A[i][3]);
				}else if (isOn[1][j]) {
					value = Math.max(value, A[j][3]);
				}
			}
		}
		result += value;
	}

}
