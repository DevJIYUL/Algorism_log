package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1753 {
	static class Edge implements Comparable<Edge>{
		int u,w;
		public Edge(int u, int w) {
			super();
			this.u = u;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	static int v,e;
	static int start;
	static ArrayList<ArrayList<Edge>> edge;
	static int[] distance;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		start = Integer.parseInt(st.nextToken());
		distance = new int[v+1];
		visited = new boolean[v+1];
		edge = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			distance[i] = Integer.MAX_VALUE;
			edge.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge.get(a).add(new Edge(b, w));
		}
		distance[0] = 0;
		dijstra();
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
	private static void dijstra() {
		PriorityQueue<Edge> pqueue = new PriorityQueue<>();
		distance[start] = 0;
		pqueue.offer(new Edge(start, distance[start]));
		while (!pqueue.isEmpty()) {
			Edge temp = pqueue.poll();
			
			int dist = temp.w;
			int now = temp.u;
//			if(visited[now]) continue;
			if(distance[now] < dist) continue;
			
			for (int i = 0; i < edge.get(now).size(); i++) {
				int cost = distance[now]+ edge.get(now).get(i).w;
				if (cost < distance[edge.get(now).get(i).u]) {
					distance[edge.get(now).get(i).u] = cost;
					pqueue.offer(new Edge(edge.get(now).get(i).u ,cost));
				}
			}
		
		
		}
		
	}

}
