package com.day0823;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n];
			for (int j = 1; j <= n; j++) {
				parents[j] = j;
			}
			System.out.print("#"+i+" ");
			for (int j = 0; j < m; j++) {
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (command == 0) {
					union(a,b);
				}else {
					System.out.print(check(a,b));
				}
			}
			System.out.println();
		}
	}
	private static int check(int a, int b) {
		a = findparents(a);
		b = findparents(b);
		if (a==b) {
			return 1;
		}else {
			return 0;
		}
	}
	private static void union(int a, int b) {
		a = findparents(a);
		b = findparents(b);
		if (a<b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}
	private static int findparents(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findparents(parents[x]);
	}

}
