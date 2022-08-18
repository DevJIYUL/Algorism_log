package com.day0818;

import java.util.Scanner;

public class SubSetTest {
	static int n,s,total;
	static int[] input;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		total = 0;
		input = new int[n];
		visited = new boolean[n];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0,0);
		System.out.println("총 경우의 수 : "+total);
	}
	
	private static void subset(int index,int sum) {
		if (sum == s) {
			total++;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
			return ;
		}
		if (sum>s) {
			return;
		}
		if (index == n) {
			return;
		}
		visited[index] = true;
		
		subset(index+1,sum+input[index]);
		
		visited[index] = false;
		
		subset(index + 1,sum+input[index]);
	}
	

}
