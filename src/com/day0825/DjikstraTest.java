package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DjikstraTest {
	static int v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[v][v];
		
		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < v; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// start -> end 최단 경로
		int start = 0; // 시작 정점
		int end = v-1; // 도착 정졈
		
		// 다익스트라 알고리즘에 필요한 자료구죠
		int[] distance = new int[v];
		boolean[] visited = new boolean[v];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		// 출발 정점 처리
		distance[start] = 0;
		
		int min,minVertex;
		
		for (int i = 0; i < v; i++) {
			// step1 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택(방문해야하는 정점 중 출발지에서 가장 가까운 정점 찾기)
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < v; j++) {
				if (!visited[j] && min>distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}
			// step2 방문 처리
			visited[minVertex] = true;
			if(minVertex == end) break; // 문제가 start 에서 end까지 최단거리일때 그만둔다
			// step3 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for (int j = 0; j < v; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] >0 &&adjMatrix[minVertex][j]+distance[minVertex]<distance[j]) {
					distance[j] = adjMatrix[minVertex][j] + distance[minVertex];
				}
			}
		}
		System.out.println(distance[end]);
	}

}
