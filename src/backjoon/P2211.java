package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2211 {
	static int n,m;
	static int[][] graph;
	static boolean[][] visited;
	static int[] distance,parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph[a][b] = c;
			graph[b][a] = c;
		}
		distance= new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		parent = new int[n+1];
		visited = new boolean[n+1][n+1];
		dij(1);
		System.out.println(n-1);
		for (int i = 2; i < n+1; i++) {
			System.out.println(i+" "+parent[i]);
		}
	}
	public static void dij(int start) {
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {start,0});
		distance[start] = 0;
		boolean[] v = new boolean[n+1];
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			if(v[temp[0]])continue;
			v[temp[0]] = true;
			for (int i = 0; i < n+1; i++) {
				if(graph[temp[0]][i]==0)continue;
				if(v[i])continue;
				if(distance[i]<temp[1]+graph[temp[0]][i])continue;
				parent[i] = temp[0];
				distance[i] = temp[1]+graph[temp[0]][i];
				pqueue.add(new int[] {i,distance[i]});
			}
		}
	}

}
