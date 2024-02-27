package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P5972 {
	static ArrayList<ArrayList<int[]>> graph;
	static int[] distance;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		distance = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken())-1;
			int b = Integer.valueOf(st.nextToken())-1;
			int c = Integer.valueOf(st.nextToken());
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {0,0});
		distance[0] = 0;
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			visited[temp[0]] = true;
			for (int i = 0; i < graph.get(temp[0]).size(); i++) {
				int[] t = graph.get(temp[0]).get(i);
				int w = t[0];
				int cost = t[1];
				if(visited[w])continue;
				if(distance[temp[0]]+cost<distance[w]) {
					distance[w] = distance[temp[0]]+cost;
					pqueue.add(new int[] {w,distance[w]});
				}
			}
		}
		System.out.println(distance[n-1]);
	}

}
