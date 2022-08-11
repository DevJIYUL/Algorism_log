package com.day0811;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskingTest {
	static int n,r;
	static int[] numbers,input;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		permutate(0,0);
		System.out.println("총 경우의 수 : "+total);
	}
	// flag 선택된 수들의 상태를 비트로 표현하고 있는 비트열 (정수)
	static void permutate(int count,int flag) {
		if (count == n) {
			total++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			numbers[count] = i;
			permutate(count+1,flag | (1<<i));
		}
	}

}
