package com.day0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164 {
	static int x;
	static boolean flag = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while (q.size()>1) {
			if (flag) {
				x = q.poll();
				flag = false;
			}else if (!flag) {
				q.offer(q.poll());
				flag = true;
			}
		}
		System.out.println(q.poll());
	}

}
