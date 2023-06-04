package com.day1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5607 {
	static int t,n,r;
	static long[] d;
	static int mod = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			d = new long[n+1];
			d[1] = 1;
			for (int j = 2; j < n+1; j++) {
				d[j] = (j*d[j-1])%mod;
//				System.out.print(d[j]+" ");
//				System.out.print(j+" ");
			}
			long nf = d[n];
			long nmrf = d[n-r];
			long rf = d[r];
			long result = (rf*nmrf)%mod;
			result = f(result,mod-2);
	
			System.out.println("#"+i+" "+(nf*result)%mod);
		}
	}
	private static long f(long result, int m) {
			if(m == 0) {
				return 1;
			}else if(m == 1) {
				return result;
			}
			if(m%2==0) {
				long t = f(result,m/2);
				return (t*t)%mod;
			}
			long temp = f(result,m-1)%mod;
			return (temp*result)%mod;
	}

}
