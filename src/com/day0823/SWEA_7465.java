package com.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.omg.CORBA.UnionMember;

// 창용 마을 무리의 개수
public class SWEA_7465 {
	static int n,m;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			for (int j = 0; j < n+1; j++) {
				parents[j] = j;
			}
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			for (int j = 1; j < parents.length; j++) {
				findparents(j);
			}
//			System.out.println(Arrays.toString(parents));
			HashSet<Integer> team = new HashSet<>();
			for (int j = 1; j < parents.length; j++) {
				team.add(parents[j]);
			}
//			System.out.println(team+" "+findparents(6));
			System.out.println("#"+i+" "+team.size());
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
		}else {
			return parents[x] = findparents(parents[x]);
		}
	}

}
