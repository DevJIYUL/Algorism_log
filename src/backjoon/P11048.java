package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11048 {
	static int[][] graph,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]=Integer.valueOf(st.nextToken());
			}
		}
		dp = new int[n][m];
		dp[0][0] = graph[0][0];
		for (int i = 1; i < m; i++) {
			dp[0][i]=dp[0][i-1]+graph[0][i];
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0]+graph[i][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+graph[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[n-1][m-1]);
	}

}
