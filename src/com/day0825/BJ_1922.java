package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1922 {
	class Vertex{
		
	}
	static int v,e,result;
	static int[][] graph;
	static boolean[] visited;
	static int[] minEdge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		v =Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		e =Integer.parseInt(st.nextToken());
		graph = new int[v+1][v+1];
		visited = new boolean[v+1];
		minEdge = new int[v+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[x][y] = cost;
			graph[y][x] = cost;
		}
		mst_prim();
		System.out.println(Arrays.toString(minEdge));
		System.out.println(result);
	}
	private static void mst_prim() {
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		minEdge[1] = 0;
		pqueue.offer(new int[] {1,minEdge[1]});
		
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			if(visited[temp[0]]) continue;
			visited[temp[0]] = true;
			result += temp[1];
			for (int i = 1; i <= v; i++) {
				if (graph[temp[0]][i] == 0) {
					continue;
				}
				if (!visited[i] && minEdge[i] > graph[temp[0]][i]) {
					minEdge[i] = graph[temp[0]][i];
					pqueue.offer(new int[] {i,minEdge[i]});
				}
			}
		}
		
	}

}
