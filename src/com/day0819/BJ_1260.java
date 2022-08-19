package com.day0819;
// DFS와 BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1260 {
	static int n,m,v;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static Deque<Integer> deque;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new LinkedList[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		for (int i = 1; i < graph.length; i++) {
			if (graph[i].size()>0) {
				Collections.sort(graph[i]);				
			}
		}
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
		System.out.println();
	}
	private static void bfs(int vertex) {
		deque = new ArrayDeque<>();
		deque.offer(vertex);
		visited[vertex] = true;
		
		while (!deque.isEmpty()) {
			int temp = deque.poll();
			System.out.print(temp+" ");
			for (int i = 0; i < graph[temp].size(); i++) {
				if(visited[graph[temp].get(i)]) continue;
				visited[graph[temp].get(i)] = true;
				deque.offer(graph[temp].get(i));
				
			}
		}
		
		
	}
	private static void dfs(int vertex) {
		visited[vertex] = true;
		
		System.out.print(vertex+" ");
		for (int i = 0; i < graph[vertex].size(); i++) {
			if (visited[graph[vertex].get(i)]) continue;
			visited[graph[vertex].get(i)] = true;
			dfs(graph[vertex].get(i));
		}
	}

}
