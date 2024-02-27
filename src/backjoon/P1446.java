package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1446 {
	static int n,d;
	static int[] dp;
	static HashMap<Integer, ArrayList<int[]>> map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		map = new HashMap<>();
		dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			if(map.containsKey(a)) {
				map.get(a).add(new int[] {b,c});
			}else {
				map.put(a, new ArrayList<>(Arrays.asList(new int[] {b,c})));
			}
		}
		for (int i = 0; i <= d; i++) {
			if(i>0)dp[i] = Math.min(dp[i-1]+1, dp[i]);
			if(map.containsKey(i)) {				
				for (int[] in : map.get(i)) {
//					System.out.println(i+" => "+in[0]+" "+dp[in[0]]+ " "+(dp[i]+in[1]));
					dp[in[0]] = Math.min(dp[in[0]], dp[i]+in[1]);
				}
			}
		}
//		for (int i = 0; i <= 150; i++) {
//			System.out.println(i+" "+dp[i]);
//		}
		System.out.println(dp[d]);
	}

}
