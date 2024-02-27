package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1719 {
	static int n,m;
	static int[][] graph,result;
	static int[] distance,parent;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n+1][n+1];
		result = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph[a][b] = c;
			graph[b][a] = c;
		}
		for (int i = 1; i < n+1; i++) {
			distance = new int[n+1];
			parent = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			dij(i);
//			result[i] = parent;
		}
//		for (int i = 1; i < n+1; i++) {
//			System.out.println(Arrays.toString(result[i]));
//		}
		System.out.println(sb.toString());
	}
	public static void dij(int i) {
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {i,0});
		distance[i] = 0;
//		parent[i] = i;
		boolean[] visited = new boolean[n+1];
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			int w = temp[0];
			int cost = temp[1];
			if(visited[w])continue;
			visited[w] = true;
			if(distance[w]<cost)continue;
			for (int j = 0; j < graph[w].length; j++) {
				if(graph[w][j] == 0)continue;
				if(distance[w]+graph[w][j]<distance[j]) {
					parent[j] = w;
					distance[j] = distance[w]+graph[w][j];
					pqueue.add(new int[] {j,distance[j]});
				}
			}
		}
		for (int j = 1; j < n+1; j++) {
			if(j == i)sb.append("- ");
			else {
				int ans = findP(j,i);
				sb.append(ans+" ");
			}
		}
		sb.append("\n");
	}
	private static int findP(int j, int i) {
		if(parent[j] == i)return j;
		return findP(parent[j], i);
	}

}
