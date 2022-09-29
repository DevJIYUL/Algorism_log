package com.CodeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

// Shuffle-O-Matic
public class No3 {
	static int test_case, n;
	static int[] a, b, temp, x;
	static boolean[] visited;
	static int orderCnt, disorderCnt;
	static boolean isMakeorder,isMakereverseorder;
	static ArrayList<HashSet<Integer>> swapIndex;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
//			a= new int[n];
			a = new int[n / 2];
			b = new int[n / 2];
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n / 2; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < n / 2; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			temp = new int[n];
			for (int j = 0; j < n; j++) {
				if (j < n / 2)
					temp[j] = a[j];
				if (j >= n / 2)
					temp[j] = b[j - n / 2];
			}
			swapIndex = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				swapIndex.add(new HashSet<>());
			}
			swapIndex.get(1).add(n/2);
			for (int j = 2; j < n; j++) {
				if(j <= n/2) {
					for (Integer k : swapIndex.get(j-1)) {
						swapIndex.get(j).add(k-1);
						swapIndex.get(j).add(k+1);
					}
				}else {
					swapIndex.get(j).addAll(swapIndex.get(n-j));
				}
			}
//			for (int j = 0; j < swapIndex.size(); j++) {
//				for (Integer string : swapIndex.get(j)) {
//					System.out.print(string+" ");
//				}
//				System.out.println();
//			}

			orderCnt = Integer.MAX_VALUE;
			disorderCnt = Integer.MAX_VALUE;
			dfs(0, temp);
			if(disorderCnt == Integer.MAX_VALUE && orderCnt == Integer.MAX_VALUE) {
				System.out.println("#"+i+" "+-1);
			}else {
//				System.out.println(disorderCnt);
//				System.out.println(orderCnt);
				System.out.println("#"+i+" "+(Math.min(disorderCnt, orderCnt)));
			}
		}
	}

	private static void dfs(int count, int[] temp) {
//		if(isMakeorder && isMakereverseorder) return;
		boolean order = true;
		for (int i = 1; i < temp.length; i++) {
			if(temp[i-1] > temp[i]) {
				order = false;
			}
		}
		if(order) {
			orderCnt = Math.min(orderCnt, count);
//			System.out.println("오름차순 발생 count : "+count);
//			System.out.println("countcnt : "+ orderCnt);
//			isMakeorder = true;
			return;
		}
		boolean reverseorder = true;
		for (int i = 1; i < temp.length; i++) {
			if(temp[i-1] < temp[i]) {
				reverseorder = false;
			}
		}
		if(reverseorder) {
			disorderCnt = Math.min(disorderCnt, count);
//			System.out.println("내림 차순 발생 count : "+count);
//			isMakereverseorder = true;
			return;
		}
		if(count == 5) {
			return;
		}

		for (int i = 0; i < n; i++) {
			int[] change = temp.clone();
			temp = dial(i, change);
//			System.out.println(Arrays.toString(temp)+" count :"+ count);
			dfs(count +1,change);
		}

	}

	private static int[] dial(int i, int[] temp2) {
		for (int j : swapIndex.get(i)) {
			swap(temp2, j-1, j);
		}
		return temp2;
	}

	private static void swap(int[] a2, int index, int index2) {
		int temp = a2[index];
		a2[index] = a2[index2];
		a2[index2] = temp;

	}

}
