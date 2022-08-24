package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236 {
	static int n,sharSize,time,experience;
	static int[][] graph;
	static boolean[][] visited;
	static int[] sharkPosition;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<int[]> queue;
	static PriorityQueue<int[]> pqueue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 9) {
					sharkPosition = new int[] {i,j};
				}
			}
		}
		
		// 반복되어야함
		sharSize = 2;
		experience = 0;
		while(true) {
			pqueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						if (o1[1] == o2[1]) {
							return o1[2]-o2[2];
						}else {
							return o1[1]-o2[1];
						}
					}else {
						return o1[0]- o2[0];
					}
				}
			});
			visited = new boolean[n][n];
			bfs(sharkPosition[0],sharkPosition[1],0);
			while (!pqueue.isEmpty() && graph[pqueue.peek()[1]][pqueue.peek()[2]] >= sharSize) {
				pqueue.poll();
			}
			
			if (!pqueue.isEmpty()) {
				// count,x,y
				int[] result = pqueue.poll();
//				System.out.println(Arrays.toString(result));
				experience++;
				graph[result[1]][result[2]] = 0;
				time+=result[0];
				graph[sharkPosition[0]][sharkPosition[1]] = 0;
				sharkPosition[0] = result[1];
				sharkPosition[1] = result[2];
				graph[sharkPosition[0]][sharkPosition[1]] = 9;
				if (sharSize <= experience) {
//					System.out.println("상어 사이즈"+sharSize +" 경험치 :"+experience);
					experience =0;
					sharSize++;
				}
				
			}else {
				break;
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(graph[i][j] +" ");
//				}
//				System.out.println();
//			}
//			System.out.println("상어 위치"+Arrays.toString(sharkPosition)+" 경험치"+experience+" 상어 사이즈"+sharSize);
		}
		System.out.println(time);
	}
	private static void bfs(int i, int j,int count) {
		queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j,count});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
//			System.out.println(Arrays.toString(temp));
			if (graph[temp[0]][temp[1]] != 0 && graph[temp[0]][temp[1]] != 9) {
				pqueue.offer(new int[] {temp[2],temp[0],temp[1]});
			}
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if (nx<0 || ny <0 || nx>=n||ny>=n) {
					continue;
				}
				if (graph[nx][ny] > sharSize || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny,temp[2]+1});
			}
			
		}
	}

}
