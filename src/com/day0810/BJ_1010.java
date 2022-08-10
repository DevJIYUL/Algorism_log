package com.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리 놓기
public class BJ_1010 {
	static int t,n,m,total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());


			double result = 1;
			for (int j = 1; j <= n; j++) {
				result = result*(double)(m+1-j)/j;
			}
			System.out.println((int)result);
		}
	}



}
