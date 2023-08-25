package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1774 {
	static class Edge implements Comparable<Edge>{
		int from,to;
		double cost;
		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	static int n,m;
	static int[][] graph;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n+1][2];
		parent = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		visited = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());

			graph[i] = new int[] {a,b};
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
//			if(a>b) {
//				int temp = a;
//				a = b;
//				b= temp;
//			}
			union(a,b);
		}
		PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>();
//		ArrayList<Edge> edge = new ArrayList<>();
		for (int i = 1; i < n+1; i++) {
			for (int j = i+1; j < n+1; j++) {
				if(i==j)continue;
				int[] a = graph[i];
				int[] b = graph[j];
				pqueue.add(new Edge(i, j, Math.sqrt(Math.pow((a[0]-b[0]), 2)+Math.pow((a[1]-b[1]), 2))));
//				edge.add(new Edge(i, j, Math.sqrt(Math.pow((a[0]-b[0]), 2)+Math.pow((a[1]-b[1]), 2))));
			}
		}
//		Collections.sort(edge);
		double sum=0;
//		for (int i = 0; i < edge.size(); i++) {
//			Edge temp = edge.get(i);
		while (!pqueue.isEmpty()) {
			Edge temp = pqueue.poll();
//			if(visited[temp.from]&&visited[temp.to])continue;
//			System.out.println(Arrays.toString(parent));
//			System.out.println(temp);
			if(findParent(temp.from) != findParent(temp.to)) {
				sum+=temp.cost;
				union(temp.from, temp.to);
//				visited[temp.from] = true;
//				visited[temp.to] = true;
			}
		}
		System.out.println(String.format("%.2f", sum));
	}
	private static boolean union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a != b) {
			parent[a] = b;
			return true;
		}
		return false;
	}
	private static int findParent(int a) {
		if(parent[a] == a)return a;
		else return parent[a] = findParent(parent[a]);
	}

}
