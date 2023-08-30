package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P11722 {
	static int n,answer=1;
	static int[] arr,dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		arr = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.fill(dp, 1);
		for (int i = n-1; i > -1; i--) {
			for (int j = i; j < n; j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					answer = Math.max(answer, dp[i]);
				}
			}
		}
		System.out.println(answer);

	}

}
