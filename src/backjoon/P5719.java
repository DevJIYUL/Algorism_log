package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P5719 {
	static int n,m,s,d,min = Integer.MAX_VALUE;
	static ArrayList<ArrayList<int[]>> graph,reGraph;
	static int[] distance;
	static boolean[][] visited;
	static class Node{
		int node,cost;
		public Node(int node,int cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [node=" + node + ", cost=" + cost + "]";
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			if(n==0 && m==0)break;
			st = new StringTokenizer(br.readLine());
			s = Integer.valueOf(st.nextToken());
			d = Integer.valueOf(st.nextToken());
			reGraph = new ArrayList<>();
			graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<>());
				reGraph.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				graph.get(a).add(new int[] {b,c});
				reGraph.get(b).add(new int[] {a,c});
			}
			visited = new boolean[n][n];
			distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			dij(s);
//			System.out.println(Arrays.toString(distance));
			dfs(d);
			Arrays.fill(distance, Integer.MAX_VALUE);
			dij(s);
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			System.out.println(distance[d]==Integer.MAX_VALUE?-1:distance[d]);
		}

	}
	public static void dij(int start) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		pqueue.add(new Node(start,0));
		distance[start] = 0;
		while (!pqueue.isEmpty()) {
			Node temp = pqueue.poll();
			if(distance[temp.node]<temp.cost)continue;
			for (int[] n : graph.get(temp.node)) {
				int cost = temp.cost+n[1];
				if(distance[n[0]]>cost && !visited[temp.node][n[0]]) {
					distance[n[0]] = cost;
					pqueue.add(new Node(n[0],cost));
				}
			}
		}
	}
	public static void dfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			for (int[] n : reGraph.get(temp.node)) {
				if(temp.cost+n[1]+distance[n[0]] != distance[d]||visited[n[0]][temp.node])continue;
				visited[n[0]][temp.node]=true;
				queue.add(new Node(n[0], temp.cost+n[1]));
			}
		}
	}
}
