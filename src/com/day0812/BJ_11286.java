package com.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		Comparator<int[]> compare = new Comparator<int[]>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]);
//		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				if (o1[0]>o2[0]) {
//					return 1;
//				}else if (o1[0]==o2[0]) {
//					if (o1[1]>o2[1]) {
//						return 1;
//					}
//				}
//				return -1;
//					
//			}
//		});
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine().trim());
			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int[] y = pq.poll();
					System.out.println(y[1]);
				}
			} else {
				pq.add(new int[] {Math.abs(x),x});
			}
		}

	}

}
