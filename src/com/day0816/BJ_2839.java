package com.day0816;

import java.util.Scanner;

// 설탕 배달
public class BJ_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int five = n / 5; 
		int three;
		while (true) {
			if (five > 0) {
				n -= five*5;
				three = n / 3;
				if (n%3 == 0) {
					System.out.println(five + three);
					break;
				}else {
					n += five*5;
					five -= 1;
					continue;
				}
			}else {
				three = n/3;
				if (n % 3 == 0) {
					System.out.println(three);
					break;
				}else {
					System.out.println(-1);
					break;
				}
			}
		}
	}

}
