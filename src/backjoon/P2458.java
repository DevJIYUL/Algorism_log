package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2458 {
	static int[][] graph;
	static int n,m,result;
	static boolean[] visited;
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
			graph[a][b] = 1;
			graph[b][a] = -1;
		}
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			visited[i]= true;
			dfs(i,1);
			dfs(i,-1);
//			System.out.println(i+" 친구");
//			System.out.println(Arrays.toString(visited));
			int count = 0;
			for (int j = 1; j < n+1; j++) {
				if(visited[j])count++;
			}
			if(count==n)result++;
		}
		System.out.println(result);
	}
	private static void dfs(int i,int target) {
		// TODO Auto-generated method stub
		for (int j = 1; j < n+1; j++) {
			if(graph[i][j] == 0 || visited[j])continue;
			if(graph[i][j] == target) {
				visited[j] = true;
				dfs(j,target);
			}
		}
	}

}
