package com.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs(n);
	}
	public static void bfs(int v) {
		Queue<int[]> queue;
		queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {0,v});
		
		boolean[] visited;
		visited =new boolean[100001];
		while (!queue.isEmpty()) {
			int[] x= queue.poll();
			if (x[1] == k) {
				System.out.println(x[0]);
				return;
			}
			if (x[1] + 1 <= 100000 && !visited[x[1]+1]) {
				queue.offer(new int[] {x[0]+1,x[1]+1});
				visited[x[1]+1] = true;
			}
			if (x[1] * 2 <= 100000 && !visited[x[1]*2]) {
				queue.offer(new int[] {x[0]+1,x[1]*2});
				visited[x[1]*2] = true;
			}
			if (x[1] - 1 >= 0 && !visited[x[1]-1]) {
				queue.offer(new int[] {x[0]+1,x[1]-1});
				visited[x[1]-1] = true;
			}
			
		}
	}

}
