package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1562 {
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		int[][][] d = new int[n+1][10][1024];
		for (int i = 1; i < 10; i++) {
			d[1][i][1<<i] = 1;
			
		}
//		a = a|(1<<1);
//		a = a|(1<<2);
//		a = a|(1<<3);
//		a = a|64|0|128;
//		System.out.println(Integer.toBinaryString(~a));
//		System.out.println(a);
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k | (1<<j);
					if(j == 0) {
						d[i][j][bit] += d[i-1][j+1][k]%1000000000;
					}else if(j==9) {
						d[i][j][bit] += d[i-1][j-1][k]%1000000000;
					}else {
						d[i][j][bit] += d[i-1][j-1][k]%1000000000 + d[i-1][j+1][k]%1000000000; 
					}
					d[i][j][bit] %= 1000000000;
				}
			}
		}
		long sum = 0;
//		for (int i = 1; i <= n; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(d[i][j][1023]+" ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < 10; i++) {
			sum+= d[n][i][1023]%1000000000;
			sum %= 1000000000;
//			System.out.println(d[n][i][1023]);
		}
		System.out.println(sum);
	}

}
