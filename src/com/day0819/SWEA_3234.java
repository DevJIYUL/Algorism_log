package com.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234 {
	static int test_case,n,result;
	static int[] number,weights;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			number = new int[n];
			visited = new boolean[n];
			weights = new int[n];
			for (int j = 0; j < n; j++) {
				number[j] = Integer.parseInt(st.nextToken());
			}
			permu(0,0);
			System.out.println("#"+i+" "+result);
		}
	}
	private static void permu(int count,int index) {
		if (count == n) {
			cal(weights);
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((index & 1<<i)!=0) {
				continue;
			}
			weights[count] = number[i];
			permu(count+1,index | (1<<i));
		}
	}
	private static void subset(int count,int[] weights,int left,int right) {
		if (left < right) {
			return ;
		}
		if (count == n) {
			result++;
			return;
		}
		subset(count+1,weights,left+weights[count],right);
		subset(count+1,weights,left,right+weights[count]);
	}
	private static boolean cal(int[] weights) {
		subset(0,weights,0,0);
		return true;
		
	}

}
