package com.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int input[][] = new int[n][n];
		boolean[] visited = new boolean[n];
		visited[0] = true; // 정점 0이 mst에 포함되었다.
		int[] minEdge = new int[n]; // 각 정점별 다른 정점과의 연결 간선 중 최소 비용.
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		minEdge[0] = 0;
		
		int minValue; // 매 회차 찾아내는 최소 비용
		int minVertex;// 매 회차 찾아내는 최소 비용으로 연결되는 상대 정점. mst에 포함되게 함
		int result = 0;// 누적 비용
		for (int i = 0; i < n; i++) {
			minValue = Integer.MAX_VALUE;
			minVertex = 0;
			
			for (int j = 0; j < n; j++) {
				// visited[j] : 정점j가 아직 mst에 포함되어 있지 않고
				if (!visited[j] && minValue > minEdge[i]) {
					minValue = minEdge[j];
					minVertex = j;// 최소 비용을 갖는 정점
					System.out.println("정점번호:"+minVertex+"최소비용 : "+minVertex);
				}
			}
			// 최소 비용과 최소 비용을 갖는 정점이 결정됨
			result += minValue;
			// mst에 포함시
			visited[minVertex] = true;
			// 방금 찾은 최소비용의 정점 기준으로 이 정점과 연결되어 있으면서 신장 트리에는 아직 포함되어 있지 않은 다른 정점들과의 최소 간선 비용 업데이트
			for (int j = 0; j < n; j++) {
				if (!visited[j] && input[minVertex][j] != 0 && input[minVertex][j] < minEdge[j]) {
					minEdge[j] = input[minVertex][j];
				}
			}
			System.out.println("MST : "+Arrays.toString(minEdge));
		}
	}
}
