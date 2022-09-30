package com.day0829;

import java.util.Arrays;
import java.util.Scanner;

public class PCSTest {
	static int n,r,input[],number[];
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		input = new int[n];
		visited = new boolean[n];
		number = new int[r];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		permutate(0);
		
		combinate(0, 0);
		
		subset(0);
		
	}
	
	public static void permutate(int count) {
		if(count == r) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i])continue;
			number[count] = input[i];
			visited[i] = true;
			permutate(count+1);
			visited[i] = false;
		}
	}
	
	public static void combinate(int index, int count) {
		if(count == r) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = index; i < n; i++) {
			number[count] = input[i];
			combinate(i+1, count+1);
		}
	}
	
	public static void subset(int count) {
		if(count == n) {
			for (int i = 0; i < visited.length; i++) {
				System.out.print(visited[i]?input[i]+" ":"x ");
			}
			System.out.println();
			return;
		}
		visited[count] = true;
		subset(count+1);
		visited[count] = false;
		subset(count+1);
	}
	

}
