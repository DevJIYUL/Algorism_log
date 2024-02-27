package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1162 {
	static int n,m,k;
	static ArrayList<ArrayList<Node>> graph;
	static long[][] distance;
	static class Node{
		int node;
		int cost;
		public Node(int node,int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [node=" + node + ", cost=" + cost + "]";
		}
		
	}
	static class Path{
		int node,pakageCount;
		long cost;
		public Path(int node,long cost,int pakageCount) {
			this.node = node;
			this.cost = cost;
			this.pakageCount = pakageCount;
		}
		@Override
		public String toString() {
			return "Path [node=" + node + ", pakageCount=" + pakageCount + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a,c));
		}
		distance = new long[k+1][n+1];
		for (int i = 0; i < k+1; i++) {
			Arrays.fill(distance[i], Long.MAX_VALUE);
		}
		dij(1);
//		for (int i = 0; i < k+1; i++) {
//			System.out.println(Arrays.toString(distance[i]));
//		}
		long result = Long.MAX_VALUE;
		for (int i = 0; i < k+1; i++) {
			result = Math.min(result, distance[i][n]);
		}
		System.out.println(result);
	}
	public static void dij(int start) {
		PriorityQueue<Path> pqueue  = new PriorityQueue<>((o1,o2)->(int)o1.cost-(int) o2.cost);
		pqueue.add(new Path(start, 0, 0));
		distance[0][start] = 0;
		while (!pqueue.isEmpty()) {
			Path path = pqueue.poll();
			if(distance[path.pakageCount][path.node]<path.cost)continue;
//			System.out.println("Path => "+path);
			for (Node node : graph.get(path.node)) {
				long cost = path.cost+node.cost;
//				System.out.println("Node : "+node);
//				System.out.println("cost : "+cost);
//				System.out.println("distance : "+distance[path.pakageCount][node.node]);
				if(cost < distance[path.pakageCount][node.node]) {
					distance[path.pakageCount][node.node] = cost;
					pqueue.add(new Path(node.node, distance[path.pakageCount][node.node], path.pakageCount));
				}
				if(path.pakageCount<k && path.cost < distance[path.pakageCount+1][node.node]) {
					distance[path.pakageCount+1][node.node]= Math.min(distance[path.pakageCount+1][node.node],path.cost);
					pqueue.add(new Path(node.node, path.cost, path.pakageCount+1));
				}
			}
		}
	}

}
