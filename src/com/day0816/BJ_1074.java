package com.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074 {
	static int n,r,c,count = 0;
	static int[][] graph;
	static boolean flag= false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		if (r == 0 && c == 0) {
			System.out.println(0);
			return;
		}
		int size = (int) Math.pow(2, n);

		divide(0,0,size,size);
		System.out.println(count-1);
		
	}
	private static void divide(int x, int y, int a, int b) {
		if (flag) return;
		if (!((a>r)&& (r>=x) && (b>c) && (c >= y))) {
			count += (a-x)*(a-x);
			return ;
		}
		
		if (a-x == 2 && b - y == 2) {
			for (int i = x; i < a; i++) {
				for (int j = y; j < b; j++) {
					count++;
					if (r == i && c == j) {
						flag = true;
						
						return;
					}
				}
			}
			return;
		}
		
		divide(x,y,(x+a)/2,(y+b)/2);
		divide(x,(y+b)/2,(x+a)/2,b);
		divide((x+a)/2,y,a,(y+b)/2);
		divide((x+a)/2,(y+b)/2,a,b);
	}

}
