package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 행렬 제곱 */
public class Bj10830 {
	static int[][] basic;
	static int n;
	static long b;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		b = Long.valueOf(st.nextToken());
		basic = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				basic[i][j] = Integer.valueOf(st.nextToken())%1000;
			}
		}
		int[][] result = pow(basic,b);
		for (int[] is : result) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	private static int[][] pow(int[][] b, long b2) {
		if(b2 == 1l)return b;
		
		int[][] r = pow(b,b2/2);
		
		r = multi(r,r);
		
		if(b2 % 2 == 1l) {
			r = multi(r, basic);
		}
		return r;
	}
	private static int[][] multi(int[][] r, int[][] s) {
		int[][] ret = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k< n; k++) {
					ret[i][j] += r[i][k]*s[k][j];
					ret[i][j] = ret[i][j]%1000;
				}
			}
		}
		return ret;
	}

}
