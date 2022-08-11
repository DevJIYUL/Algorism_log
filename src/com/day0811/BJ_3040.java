package com.day0811;

import java.util.Arrays;
import java.util.Scanner;

// 백설 공주와 일곱 난쟁이
public class BJ_3040 {
	static int[] seven,mans,result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mans = new int[9];
		seven = new int[7];
		for (int i = 0; i < 9; i++) {
			mans[i] = sc.nextInt();
		}
		cal(0,0);
	}
	
	
	static void cal(int index,int count) {
		
		if (count == 7) {
			int sum = 0;
			for (int i = 0; i < seven.length; i++) {
				sum += mans[seven[i]];
			}

			if (sum == 100) {
				for (int i = 0; i < seven.length; i++) {
					System.out.println(mans[seven[i]]);
				}
				System.exit(0);
			}
			return ;
		}
		
		for (int i = index; i < 9; i++) {
			seven[count] = i;
			cal(i+1,count+1);
		}
		
	}
}
