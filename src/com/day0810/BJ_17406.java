package com.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_17406 {
	static int n,m,k,s,c,r;
	static int[][] graph,temp_a;
	static int[] number;
	static boolean[] visited;
	static ArrayList<Integer> lst;
	static ArrayList<Integer> result = new ArrayList<>();
	static ArrayList<int[]> command = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			
			int [] te = {r-s,c-s,r+s,c+s};
			command.add(te);
		}
		number = new int[k];
		visited = new boolean[k];
		combi(0);
		Collections.sort(result);
		System.out.println(result.get(0));
//		for (Integer inte : result) {
//			System.out.print(inte+" ");
//		}

	}
	static void combi(int count) {
		if (count == k) {
//			System.out.println(Arrays.toString(number));
			temp_a = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp_a[i][j] = graph[i][j];
				}
			}

			for (int num : number) {
				int[] tar = command.get(num);
				turn(tar[0],tar[1],tar[2],tar[3],temp_a);

			}

			lst = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int inte : temp_a[j]) {
					sum += inte;
				}
				lst.add(sum);
			}
			Collections.sort(lst);
			result.add(lst.get(0));
			return;
		}
		for (int i = 0; i < k; i++) {
			if (visited[i]) continue;
			number[count] = i;
			visited[i] = true;
			combi(count+1);
			visited[i] = false;
		}
	}
	static void turn(int leftTopX, int leftTopY,int rightBotX,int rightBotY,int[][] graph) {
		int count = Math.min(rightBotX-leftTopX+1, rightBotY-leftTopY+1)/2;
		
		for (int i = 0; i < count; i++) {
			int temp = graph[leftTopX+i][rightBotY-i];
			// 왼쪽에서 오른쪽
			for (int j = rightBotY-i; j > leftTopY+i; j--) {
				graph[leftTopX+i][j] = graph[leftTopX+i][j-1];
			}
			// 아래에서 위
			for (int j = leftTopX+i; j < rightBotX-i; j++) {
				graph[j][leftTopY+i] = graph[j+1][leftTopY+i];
			}
			// 오른쪽에서 왼쪽
			for (int j = leftTopY+i; j < rightBotY-i; j++) {
				graph[rightBotX-i][j] = graph[rightBotX-i][j+1];
			}

			// 위에서 아래
			for (int j = rightBotX-i; j > leftTopX+i; j--) {
				graph[j][rightBotY-i] =  graph[j-1][rightBotY-i];
			}
			
			graph[leftTopX+i+1][rightBotY-i] = temp;

		}
	}
}
