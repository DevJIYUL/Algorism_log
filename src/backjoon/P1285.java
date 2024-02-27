package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1285 {
	static int n,answer = Integer.MAX_VALUE;
	static char[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		graph = new char[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = input.charAt(j);
			}
		}

		for (int bit = 0; bit < (1<<n); bit++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int back = 0;
				for (int j = 0; j < n; j++) {
					char cur = graph[j][i];
					if((bit & (1<<j)) > 0) {
						cur = cur == 'T'?'H':'T';
						
					}
					if(cur == 'T')back++;
				}
				sum += Math.min(back, n-back);
			}
			answer = Math.min(answer, sum);
		}
		System.out.println(answer);
	}

}
