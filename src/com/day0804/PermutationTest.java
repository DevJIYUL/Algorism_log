package com.day0804;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {
	static int n;
	static boolean[] visited;
	static int[] numbers;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1];
		numbers = new int[n];
		
		permutate(0);
		System.out.println("총 경우의 수 : "+total);
	}
	static void permutate(int count) {
		if (count == n) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			
			numbers[count] = i;
			visited[i] = true;
			permutate(count+1);
			visited[i] = false;
		}
	}

}
