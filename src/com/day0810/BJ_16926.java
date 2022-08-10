package com.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 돌리기 1
public class BJ_16926 {
	static int n,m,r;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		r=1;
		for (int z = 0; z < r; z++) {
			// x 가로 길이, x 세로 길이, y 가로,y 세로
			turn(0, 0, m-1, n-1);
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
	static void turn(int leftTopX, int leftTopY,int rightBotX,int rightBotY) {
		int count = Math.min(rightBotX-leftTopX, rightBotY-leftTopY)/2;

		for (int i = 0; i < count; i++) {
			int temp = graph[leftTopX+i][leftTopY+i];
			System.out.println(temp);
			for (int j = leftTopY+i; j < rightBotX-i; j++) {
				graph[leftTopX+i][j] = graph[leftTopX+i][j+1];
			}
			for (int j = leftTopY+i; j < rightBotY-i; j++) {
				graph[j][rightBotX-i] = graph[j+1][rightBotX-i];
			}
			for (int j = rightBotX-i; j > leftTopX+i; j--) {
				graph[rightBotY-i][j] = graph[rightBotY-i][j-1];
			}
			for (int j = rightBotY-i; j > leftTopX+i; j--) {
//				System.out.println(graph[j][leftTopX+i]+"->"+graph[j-1][leftTopX+i]);
				graph[j][leftTopX+i] =  graph[j-1][leftTopX+i];
			}
			graph[leftTopX+i+1][leftTopY+i] = temp;
		}
	}

}

