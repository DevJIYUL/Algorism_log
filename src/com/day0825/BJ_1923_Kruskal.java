package com.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1923_Kruskal {

	static int v,e,result;
	static int[] parents;
	
	static ArrayList<int[]> edge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		v =Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		e =Integer.parseInt(st.nextToken());
		parents= new int[v+1];
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		edge = new ArrayList<>();
	
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge.add(new int[] {from,to,cost});
		}
		
		Collections.sort(edge,(o1,o2)->o1[2]-o2[2]);
		
		for (int[] e : edge) {
			if(findParents(e[0]) != findParents(e[1])) {
				union(e[0],e[1]);
				result+= e[2];
				
			}
		}
		System.out.println(result);
	}
	private static void union(int a, int b) {
		a = findParents(a);
		b = findParents(b);
		if (a<b) {
			parents[b] =a;
		}else {
			parents[a] = b;
		}
	}
	private static int findParents(int x) {
		if(parents[x] ==x ) return x;
		return parents[x] = findParents(parents[x]);
	}
	

}
