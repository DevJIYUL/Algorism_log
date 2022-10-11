package com.day1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4014 {
	static int t,n,x,result;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			result = 0;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < n; j++) {
				check(graph[j]);
				int[] temp = new int[n];
				for (int j2 = 0; j2 < n; j2++) {
					temp[j2] = graph[j2][j];
				}
				check(temp);
			}
			System.out.println("#"+i+" "+result);
		}
	}
	private static void check(int[] temp) {
//		System.out.println(Arrays.toString(temp));
		int before = temp[0];
		int size = 0;
		int j=0;
		while (j<n) {
			if(before == temp[j]) {
				size++;
				j++;
			}else if(before+1==temp[j]) {
				if(size<x) return ;
				before++;
				size=1;
				j++;
			}else if(before-1 == temp[j]) {
				int count = 0;
				for (int i = j; i < n; i++) {
					if(temp[i] != before-1) return;
					
					if(++count == x) break;
				}
				if(count<x)return ;
				before--;
				j+=x;
				size = 0;
			}else {
				return ;
			}
		}
		result++;
		return ;
	}

}
