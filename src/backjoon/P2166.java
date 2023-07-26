package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2166 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		long[] x = new long[n+1],y = new long[n+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.valueOf(st.nextToken());
			y[i] = Integer.valueOf(st.nextToken());
		}
		x[n] = x[0];y[n] = y[0];
		long plus = 0,minus = 0;
		for (int i = 0; i < n; i++) {
			plus += x[i]*y[i+1];
		}
		for (int i = 1; i <= n; i++) {
			minus -= x[i]*y[i-1];
		}
		System.out.printf("%.1f",Math.abs((plus+minus)/2.0));
	}

}

