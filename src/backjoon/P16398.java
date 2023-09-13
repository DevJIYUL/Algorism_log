package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16398 {
	static int n;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		long answer = 0;
		boolean[] visited = new boolean[n];
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {0,0});
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			int w = temp[0];
			int cost = temp[1];
//			System.out.println(w+" "+cost);
			if(visited[w])continue;
			visited[w] = true;
			answer +=cost;
			for (int i = 0; i < n; i++) {
				if(graph[w][i] == 0)continue;
				if(visited[i])continue;
				pqueue.add(new int[] {i,graph[w][i]});
			}
		}
		System.out.println(answer);
	}

}
