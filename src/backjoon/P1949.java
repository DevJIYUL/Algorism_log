package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1949 {
	static int n,cost[],dp[][];
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		cost = new int[n+1];
		dp = new int[n+1][2];
		visited= new boolean[n+1];
		graph = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			cost[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	private static void dfs(int i) {
		if(visited[i]) return;
		visited[i] = true;
		dp[i][1] = cost[i];
		for (int j = 0; j < graph.get(i).size(); j++) {
			if(visited[graph.get(i).get(j)]) continue;
			dfs(graph.get(i).get(j));
			dp[i][1] += dp[graph.get(i).get(j)][0];
			dp[i][0] += Math.max(dp[graph.get(i).get(j)][0], dp[graph.get(i).get(j)][1]);
		}
	}

}
