package com.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
class Edge{
	int a;
	int b;
	int c;
	public Edge(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
//	public int compareTo(Edge e1, Edge e2) {
//		return e1.c - e2.c;
//	}
}
public class SWEA_3124 {
	static int v,e;
	static long result;
	static int[] parents;
	static ArrayList<Edge> node;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine().trim());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			parents = new int[v+1];
			node = new ArrayList<>();
			
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b  = Integer.parseInt(st.nextToken());
				int c  = Integer.parseInt(st.nextToken());
				node.add(new Edge(c, a, b));
			}
			Collections.sort(node, (o1, o2) -> o1.c-o2.c );;
			for (int j = 0; j < v+1; j++) {
				parents[j] = j;
			}
			for (int j = 0; j < e; j++) {
				System.out.println(node.get(j).a+" "+node.get(j).b+" "+node.get(j).c);
				System.out.println(Arrays.toString(parents));
				if (findparents(node.get(j).a) == findparents(node.get(j).b)) {
					
				}else {
					union(node.get(j).a,node.get(j).b);
					result += node.get(j).c;
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
	private static void union(int a, int b) {
		a = findparents(a);
		b = findparents(b);
		if (a<b) {
			parents[b] =a;
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
