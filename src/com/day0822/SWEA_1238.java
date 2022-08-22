package com.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	static int n,start;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new ArrayList[n];
			visited = new boolean[n];
			for (int j = 0; j < n; j++) {
				graph[j] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n/2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}

			System.out.println("#"+i+" "+bfs(start));
		}
	}
	private static int bfs(int v) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {v,0});
		visited[v] = true;
		int level = 0;
		ArrayList<Integer> theLast = new ArrayList<>();
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if (temp[1] > level) {
				theLast = new ArrayList<>();
				theLast.add(temp[0]);
				level = temp[1];
			}else if (temp[1] == level) {
				theLast.add(temp[0]);
			}
			for (Integer integer : graph[temp[0]]) {
				if (visited[integer]) {
					continue;
				}
				visited[integer] = true;
				queue.offer(new int[] {integer,temp[1]+1});
			}
//			System.out.println(theLast);
			
		}
		return Collections.max(theLast);
	}

}
