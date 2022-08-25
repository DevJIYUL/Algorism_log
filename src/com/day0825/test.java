package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test {
	static class Node implements Comparable<Node>{
		int to,cost;
		
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}
	
	static int v,e,start;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		start = Integer.parseInt(st.nextToken());
		graph= new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		distance = new int[v+1];
		visited = new boolean[v+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
		}
		
		djst(start);
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
	private static void djst(int start) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		distance[start] = 0;
		pqueue.offer(new Node(start, 0));
		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();
			int dist = node.cost;
			int now = node.to;
//			if(distance[now]<dist) continue;
			if(visited[now]) continue;
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = distance[now] + graph.get(now).get(i).cost;
				if (!visited[graph.get(now).get(i).to] && cost < distance[graph.get(now).get(i).to]) {
					distance[graph.get(now).get(i).to] = cost;
					pqueue.offer(new Node(graph.get(now).get(i).to,cost));
				}
			}
		}
	}

}
