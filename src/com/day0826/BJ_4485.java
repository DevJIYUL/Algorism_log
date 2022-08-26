package com.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//색 옷 입은 애가 젤다지?
public class BJ_4485 {
	static int n,result;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int index = 1;
		StringTokenizer st;
		while (true) {
			int[][] graph;
			boolean[][] visited;
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			graph = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(graph[i]));
			}
			result = 0;
			bfs(0,0,graph,visited);
			System.out.println("Problem "+index+++": "+result);
			
			
			
			
		}
		
		
	}
	private static void bfs(int i, int j, int[][] graph, boolean[][] visited) {
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
		pqueue.offer(new int[] {graph[0][0],i,j});
		visited[i][j] = true;
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			int cost = temp[0];
			int x = temp[1];
			int y = temp[2];
			if (x == n-1 && y == n-1) {
				result = cost;
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nx = x +dx[k];
				int ny = y+dy[k];
				if(0>nx||0>ny||n<=nx||n<=ny||visited[nx][ny]) continue;
				visited[nx][ny] = true;
				pqueue.offer(new int[] {cost+graph[nx][ny],nx,ny});
			}
			
		}
	}

}
