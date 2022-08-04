package com.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 4
public class BJ_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] line = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < line.length; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < line.length; i++) {
			line[i] += line[i-1];
		}
//		System.out.println(Arrays.toString(line));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(line[end] - line[start-1]);
		}
		
		
	}

}
