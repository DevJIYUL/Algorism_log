package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1939 {
	static int n,m;
	static ArrayList<ArrayList<int[]>> graph;
	static long distance[];
	static class Node{
		int node;
		long cost;
		public Node(int node,long cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		distance = new long[n+1];
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.valueOf(st.nextToken());
		int end = Integer.valueOf(st.nextToken());
		Arrays.fill(distance, Long.MAX_VALUE);
		d(start);
		System.out.println(distance[end]);
//		System.out.println(Arrays.toString(distance));
	}
	private static void d(int start) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->(int)o1.cost-(int)o2.cost);
		pqueue.add(new Node(start, 0));

	}

}
