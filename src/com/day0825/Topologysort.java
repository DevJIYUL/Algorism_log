package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.day0825.PrimTest2.Node;

public class Topologysort {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	static int V,E;
	static int[] inDegree;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1];
		inDegree = new int[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			// 무향처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		ArrayList<Integer> list = topologySort();
		if (list.size() == V) { // 위상 정렬 완성
			for (Integer integer : list) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}else { // 사이클 발생
			System.out.println("cycle...");
		}
	}
	
	private static ArrayList<Integer> topologySort(){
		
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);
			
		}
		while (!queue.isEmpty()) {
			
			int cur = queue.poll();
			list.add(cur);
			
			for (Node temp = adjList[cur]; temp !=null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		return list;
	}

}
