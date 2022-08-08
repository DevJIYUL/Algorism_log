package com.day0808;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			ArrayList<Integer> secret = new ArrayList<>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				secret.add(sc.nextInt());
			}
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String c = sc.next();
				int num = sc.nextInt();
				int many = sc.nextInt();
				for (int j = 0; j < many; j++) {
					secret.add(num+j, sc.nextInt());
				}
			}
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+secret.get(i));
			}
			System.out.println();
		}
	}

}
