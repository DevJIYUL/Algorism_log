package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2240 {
	static int w,k;
	static int input[],dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		input = new int[w];
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = Integer.valueOf(st.nextToken());
		}
		dp = new int[w+1][k+1];
		int answer = 0;
		for (int r = 1; r <= w; r++) {
			int tree = input[r-1];
			for (int j = 0; j <= k; j++) {
				if(j==0) {
					if(tree == 1)dp[r][j] = dp[r-1][j]+1;
					else dp[r][j] = dp[r-1][j];
				}else if(j%2==0) {
					if(tree == 1)dp[r][j] = Math.max(dp[r-1][j], dp[r-1][j-1])+1;
					else dp[r][j] = Math.max(dp[r-1][j], dp[r-1][j-1]);
				}else if(j%2==1) {
					if(tree == 2)dp[r][j] = Math.max(dp[r-1][j], dp[r-1][j-1])+1;
					else dp[r][j] = Math.max(dp[r-1][j], dp[r-1][j-1]);
				}
			}
			
		}
		for (int i = 0; i <= w; i++) {
			answer = Math.max(answer, dp[i][k]);
			
		}
		System.out.println(answer);
		for (int i = 0; i < w; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

}
