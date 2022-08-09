package com.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<int[]> list;
	static int count,n;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 1; i <= test_case; i++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			visited = new boolean[n][n];
			list = new ArrayList<>();
			StringTokenizer st;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					count = 1;
					if (visited[j][j2]) continue;
					int before = count;
					bfs(j,j2);
					int after = count;
					if (before != after) {
						list.add(new int [] {count,graph[j][j2]});
					}

				}
			}

			Collections.sort(list,new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o2[0]!=o1[0] ? o2[0]-o1[0]:o1[1]-o2[1];
				}
			});
//			Collections.sort(list,(o1,o2)->{
//				return o2[0]!=o1[0] ? o2[0]-o1[0]:o1[1]-o2[1];
//			});
			System.out.println("#"+i+" "+list.get(0)[1]+" "+list.get(0)[0]);
			
		}

	}
	
	static void bfs(int x,int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0>nx || 0>ny||n<=nx||n<=ny) continue;
			if (graph[nx][ny] == graph[x][y] + 1) {
				visited[nx][ny] = true;
				count++;
				bfs(nx,ny);
			}
		}
	}
}
