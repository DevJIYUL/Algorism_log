package com.day0816;

import java.util.Scanner;

// 설탕 배달
public class BJ_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		int bag = 0;
		while (true) {
			if (weight % 5 == 0) {
				bag += weight / 5;
				System.out.println(bag);
				break;
			}
			weight -= 3;
			bag++;
			if (weight < 0) {
				System.out.println(-1);
				break;
			}
		}
	}

}
