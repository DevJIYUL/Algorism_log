package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {
	static int t,v,e,result;
	static ArrayList<ArrayList<Integer>> line;
	static ArrayList<ArrayList<Integer>> reverseline;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine().trim());
			v = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			e = Integer.parseInt(st.nextToken());
			line = new ArrayList<>();
			reverseline= new ArrayList<>();
			for (int j = 0; j < v+1; j++) {
				line.add(new ArrayList<>());
				reverseline.add(new ArrayList<>());
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				line.get(a).add(b);
				reverseline.get(b).add(a);
			}
			for (int j = 1; j < v+1; j++) {
				boolean[] check = new boolean[v+1];
				Queue<Integer> queue = new ArrayDeque<Integer>();
				queue.add(j);
				check[j] = true;
				while (!queue.isEmpty()) {
					int temp = queue.poll();
					for (Integer integer : line.get(temp)) {
						if(check[integer]) continue;
						check[integer] = true;
						queue.add(integer);
					}
				}
				System.out.println(j+" 에서 1단계 : "+Arrays.toString(check));
				for (int k = 1; k < check.length; k++) {
					if(!check[k]) {
						queue.add(k);
						System.out.print(k+" ");
					}
				}
				System.out.println();
				while (!queue.isEmpty()) {
					int temp = queue.poll();
					for (Integer integer : line.get(temp)) {
						if(integer == j) {
							check[temp] = true;
						}
						queue.add(integer);
					}
				}
				System.out.println(j+" 에서 최종 : "+Arrays.toString(check));
				System.out.println();
			}
		}
	}

}

