package com.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1로 만들기
public class BJ1435 {
	static int n ;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		d = new int[(n+1)*3];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[1] = 1;
		d[0] = 0;
		for (int i = 1; i < n+1; i++) {
			d[i*3] = Math.min(d[i*3], d[i]+1);
			d[i*2] = Math.min(d[i*2], d[i]+1);
			d[i+1] = Math.min(d[i+1], d[i]+1);
		}
//		System.out.println(Arrays.toString(d));
		System.out.println(d[n]-1);
	}

}
