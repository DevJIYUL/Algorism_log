package com.day1006;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
	static int n ,INF =100000;
	static int[][] d;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = sc.nextInt();
				if(d[i][j] == 0 & i != j) d[i][j] = INF;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(d[i]));
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d[i][j] = Math.min(d[i][j],d[i][k]+ d[k][j]);
				}
			}
		}
		System.out.println("--------------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(d[i]));
		}
	}

}
