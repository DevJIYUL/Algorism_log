package com.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class SWEA_5215 {
	static int n,limit,max_happy,kcal,happy;
	static int[] number,ingredient,good;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 1; i <= test_case; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			ingredient = new int[n];
			good= new int[n];
			max_happy = 0;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				good[j] = Integer.parseInt(st.nextToken());
				ingredient[j] = Integer.parseInt(st.nextToken());
			}

			cal(0,0,0);

			System.out.println("#"+i+" "+max_happy);
		}

	}

	static void cal(int count,int kcal,int happy) {
		if (kcal > limit) {
			return;
		}
		max_happy = Math.max(max_happy, happy);				
		if (count == n) {
			if (kcal <= limit) {
				max_happy = Math.max(max_happy, happy);
			}
			return;
		}
		cal(count+1,kcal,happy);
		cal(count+1,kcal+ingredient[count],happy+good[count]);
	}


}

