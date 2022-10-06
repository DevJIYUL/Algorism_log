package com.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최장 증가 부분 수열
public class SWEA3307 {
	static int t,n;
	static int[] lis;
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			lis = new int[n];
			input = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				lis[j] = 1;
				input[j] = num;
			}
			int m= -1;
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < j; j2++) {
					if(input[j2]<input[j]) lis[j] = Math.max(lis[j], lis[j2]+1);
				}
				m = Math.max(m, lis[j]);
			}
			System.out.println("#"+i+" "+m);
			
			
			
		}
	}

}
