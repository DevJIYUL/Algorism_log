package com.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13023 {
	static int n,m;
	static boolean flag;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		flag = false;
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i,0);
			if (flag) {
				break;
			}
		}
		if (flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	public static void dfs(int index, int v) {
		if (v ==4) {
			flag = true;
			return ;
		}
		for (Integer i : graph.get(index)) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(i,v+1);
		}
		
	}

}
