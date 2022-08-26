package com.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 게리맨더링
public class BJ_17471 {
	static int n, result;
	static int[] population, sub;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		// 도시 수
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		// 인구수 초기화
		population = new int[n + 1];
		sub = new int[n + 1];
		for (int i = 0; i < n; i++) {
			population[i + 1] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		// 그래프 초기화
		graph = new int[n + 1][n + 1];
//		System.out.println(Arrays.toString(graph[0]));
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int cityCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cityCnt; j++) {
				graph[i][Integer.parseInt(st.nextToken())] = 1;
			}
//			System.out.println(Arrays.toString(graph[i]));
		}
//		System.out.println(Arrays.toString(population));
		subset(0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);

		}
	}

	private static void subset(int count) {
		if (count == n) {
//			System.out.println(Arrays.toString(sub));
			first(sub);
			return;
		}
		sub[count + 1] = 1;
		subset(count + 1);
		sub[count + 1] = 0;
		subset(count + 1);

	}

	private static void first(int[] sub) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 1; i < sub.length; i++) {
			if (sub[i] == 1) {
				a.add(i);
			} else {
				b.add(i);
			}
		}
//		System.out.println(a.toString() + " " + b.toString());
		if (a.size() == 0 || b.size() == 0)
			return;

		ArrayList<Integer> tempA = new ArrayList<>();
		boolean flaga = bfs(b.get(0), tempA, b);
		tempA = new ArrayList<>();
		boolean flagb = bfs(a.get(0), tempA, a);
		if (flaga && flagb) {

//			System.out.println("성공");
			int sumA = 0, sumB = 0;
			for (int i = 0; i < a.size(); i++) {
				sumA += population[a.get(i)];
			}
			for (int i = 0; i < b.size(); i++) {
				sumB += population[b.get(i)];
			}
//			System.out.println(sumA + " " + sumB);
			result = Math.min(result, Math.abs(sumA - sumB));
//			System.out.println("result : " + result);
		}

	}

	private static boolean bfs(Integer integer, ArrayList<Integer> tempA, ArrayList<Integer> a) {
		Collections.sort(a);
		if (a.size() == 1)
			return true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(integer);
		while (!queue.isEmpty()) {
			Collections.sort(tempA);
			int temp = queue.poll();
//			System.out.println(a.toString() + " " + tempA.toString());
			if (tempA.equals(a)) {
//				System.out.println("같다");
				return true;
			}
			if (tempA.contains(temp))
				continue;
			tempA.add(temp);
			for (int i = 1; i < graph[temp].length; i++) {
				if (graph[temp][i] == 0)
					continue;
				if (!a.contains(i))
					continue;
				queue.offer(i);
			}
		}
		return false;

	}

}
