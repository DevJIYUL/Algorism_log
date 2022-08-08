package com.day0808;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158 {
// 요세푸스 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int count = 1;
		while (!queue.isEmpty()) {
			if (count == k) {
				lst.add(queue.poll());
				count = 1;
			}else {
				queue.add(queue.poll());
				count++;
			}
		}
		System.out.print('<');
		for (int i = 0; i < lst.size(); i++) {
			if (i == lst.size()-1) {
				System.out.print(lst.get(i));
			}else {
				System.out.print(lst.get(i)+", ");
			}
		}
		System.out.print('>');
	}

}
