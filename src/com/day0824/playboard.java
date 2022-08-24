package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class playboard {
	// 배열의 크기
	static int r, c;
	// map을 표현할 문자형 2차원 배열
	// 화산탕의 갯수
	static int n;
//	static ArrayList<ArrayList<int[]>> dp;
	static char[][] graph;
	static ArrayList<ArrayList<Integer>> dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new char[r][c];
		dp = new ArrayList<>();
		// graph 입력받기
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);
			}
			// 입력 제대로 받아졋는지 test code
//			System.out.println(Arrays.toString(graph[i]));
		}
		for (int i = 0; i < c; i++) {
			dp.add(new ArrayList<>());
		}
		for (int i = 1; i <= c; i++) {
			rolling(0, i - 1, i - 1);
		}
//		System.out.println(Arrays.toString(dp));
		st = new StringTokenizer(br.readLine());
		// 화산탄 갯수
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			
		}
		
		for (int b = 0; b < r; b++) {
			for (int j = 0; j < c; j++) {
				System.out.print(graph[b][j]);
			}
			System.out.println();
		}
	}

	private static void rolling(int depth, int index, int set) {
//		그다음 떨어질 위치가 map크기 밖이면  return
		if (depth + 1 >= r||(depth == 0)&&graph[depth][index] == 'O') {
			dp[set] = depth;
			return;
		}
		
		if (graph[depth + 1][index] == 'X') {
			dp[set] = depth;
			return ;
		}// 화산탄이 가야할 위치가 비어있으면
		else if (graph[depth + 1][index] == '.') {
//			graph[depth][index]='.';
//			graph[depth+1][index]='O';
			rolling(depth + 1, index, set);
			// 화산탄이 가야할 위치가 막혀있으면
		} else if (graph[depth + 1][index] == 'O') {
			// 왼쪽
			if ((index - 1 >= 0) && (graph[depth][index - 1] == '.' && graph[depth + 1][index - 1] == '.')) {
//				graph[depth+1][index-1] ='O';
//				graph[depth][index] = '.';
				rolling(depth + 1, index - 1, set);
				// 오른쪽
			} else if ((index + 1 < c) && (graph[depth][index + 1] == '.' && graph[depth + 1][index + 1] == '.')) {
//				graph[depth+1][index+1] ='O';
//				graph[depth][index] = '.';
				rolling(depth + 1, index + 1, set);
			}
			// 화산탄의 다음위치에 장애물을 만나면 더 이상 진행 x
		} 

	}

}
