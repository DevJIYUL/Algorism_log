package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1509 {
	static String sentance;
	static int[] dp;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sentance = " "+br.readLine();
//		sentance = str.toCharArray();
		dp = new int[sentance.length()];
		visited = new boolean[sentance.length()][sentance.length()];
		Arrays.fill(dp, Integer.MAX_VALUE); 
		dp[0] = 0;
		for (int i = 1; i < sentance.length(); i++) {
			for (int j = 1; j <= i; j++) {
				if(pad(j,i)) {
					visited[j][i] = true;
				}else {
				}
			}
			
		}
		for (int i = 1; i < sentance.length(); i++) {
			for (int j = 1; j <= i; j++) {
				if(visited[j][i]) {
					dp[i] = Math.min(dp[i], (dp[j-1]+1));
				}
			}
		}
		System.out.println(dp[dp.length-1]);
	}
	private static boolean pad(int j, int i) {
		int from = j,to = i;
		while (from <= to) {
			if(sentance.charAt(from++) != sentance.charAt(to--)) {
				return false;
			}
		}
		return true;
	}

}
