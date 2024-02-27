package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11060 {
	static int n;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		dp = new int[n+1][n];
		dp[0][0] = 1;
//		System.out.println(Arrays.toString(arr));
		boolean flag = false;
		int answer = -1;
		for (int i = 0; i <= n; i++) {
			if(flag) break;
			for (int j = 0; j < n; j++) {
				if(flag) break;
				if(dp[i][j] == 0)continue;
//				System.out.println(j+"번쨰 "+arr[j]);
				for (int j2 = 1; j2 <= arr[j]; j2++) {
//					System.out.println((i+1)+" "+(j2+j)+"번쨰");
					dp[i+1][j+j2] = 1;
					if(flag) break;
					if(j+j2 == n-1) {
						answer = i+1;
						flag = true;
						break;
					}
				}
			}
		}
		System.out.println(n==1?0:answer);


	}

}
