package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10971_permutate {
	static int n,result;
	static int[][] graph;
	static int[] number;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		number = new int[n];
		result = Integer.MAX_VALUE;
		permutate(0,visited);
		System.out.println(result);
	}
	private static void permutate(int count,boolean[] visited) {
		if(count == n) {
//			System.out.println(Arrays.toString(number));
			int sum = 0;
			for (int i = 0; i < number.length-1; i++) {
				if(graph[number[i]][number[i+1]] == 0) return;
				sum+=graph[number[i]][number[i+1]];
			}
			if(graph[number[number.length-1]][number[0]] == 0) return;
			sum+= graph[number[number.length-1]][number[0]];
			result = Math.min(result, sum);
//			System.out.println("result : "+result);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			number[count] = i;
			visited[i] = true;
			permutate(count+1, visited);
			visited[i] = false;
		}
	}

}
