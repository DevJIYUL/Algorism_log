package com.day0804;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int n,total;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int mode = sc.nextInt();
		
		total = 0;
		numbers = new int[n];
		
		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			visited = new boolean[7];
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		System.out.println("총 경우의 수 : "+total);
	}
	private static void dice1(int cnt) {
		if(cnt == n){
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
		
	}
	// 순열
	
	private static void dice2(int cnt) {
		if(cnt == n){
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int j = 1; j <= 6; j++) {
			if (visited[j]) continue;
			numbers[cnt] = j;
			visited[j] = true;
			dice2(cnt + 1);
			visited[j] = false;
		}
	}
	// 중복 조합
	private static void dice3(int cnt,int start){
		if (cnt == n) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt +1,i);
		}
		
	}
	// 조합
	private static void dice4(int cnt,int start){
		if (cnt == n) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}
}
