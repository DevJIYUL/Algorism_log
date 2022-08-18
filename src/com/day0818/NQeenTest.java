package com.day0818;

import java.util.Scanner;

public class NQeenTest {
	static int n,cols[],answer;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		
		cols = new int[n+1];
		answer = 0;
		setQueen(1);
		System.out.println(answer);
	}
	public static void setQueen(int rowNo) { // 하나의 퀸만 가능한 모든 곳에 놓아보기
		
		if (!isAvailable(rowNo-1)) return; // 직전까지의 상황이 유망하지 않으면 현재 퀸을 놓을 필요가 없으니 백트랙
			
		
		if (rowNo > n) { // 퀸을 다 놓았다면
			answer++;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			cols[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	private static boolean isAvailable(int rowNo) {
		for (int j = 1; j < rowNo; j++) {
			if (cols[j] == cols[rowNo] || rowNo - j == Math.abs(cols[rowNo]-cols[j])) {
				return false;
			}
		}
		return true;
	}
}
