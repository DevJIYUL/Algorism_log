package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24479 {
	static int n,m,r,count=1;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (int i = 0; i <= n; i++) {
			Collections.sort(graph.get(i));
//			System.out.println(graph.get(i));
		}
		visited = new int[n+1];
//		visited[r] = true;
		dfs(r);
//		System.out.println(count);
		for (int i = 1; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}
	private static void dfs(int r2) {
		visited[r2] = count++;
		for (int next : graph.get(r2)) {
			if(visited[next] == 0)dfs(next);
		}
	}

}
