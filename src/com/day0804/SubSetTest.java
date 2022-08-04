package com.day0804;

import java.util.Scanner;

public class SubSetTest {
	static int n,total;
	static int[] input;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		total = 0;
		input = new int[n];
		visited = new boolean[n];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println("총 경우의 수 : "+total);
	}
	
	private static void subset(int index) {
		if (index == n) {
			total++;
			for (int i = 0; i < n; i++) {
				System.out.print(visited[i]?input[i]:"X");
				System.out.print("\t");
			}
			System.out.println();
			return ;
		}
		
		visited[index] = true;
		
		subset(index+1);
		
		visited[index] = false;
		
		subset(index + 1);
	}
	

}
