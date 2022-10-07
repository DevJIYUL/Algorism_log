package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Test {
	static int n,m;
	static TreeSet<Integer> t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		t = new TreeSet<>();
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			t.add(input);
		}
		st = new StringTokenizer(br.readLine().trim());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			int val = Integer.parseInt(st.nextToken());
			System.out.println(t.contains(val)?1:0);
		}
	}

}
