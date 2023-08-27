package backjoon;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14938 {
	static int n,m,r,answer = 0;
	static int[] items;
	static ArrayList<ArrayList<int[]>> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		items = new int[n+1];
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			items[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
		}
//		dij(2);
		for (int i = 1; i < n+1; i++) {
			dij(i);
		}
		System.out.println(answer);
	}
	private static void dij(int i) {
//		System.out.println(i+"번째");
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		queue.add(new int[] {i,0});
		int sum = 0;
		boolean[] visited= new boolean[n+1];
		visited[i] = true;
		distance[i] = 0;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
//			System.out.println(Arrays.toString(temp));
			for (int j = 0; j < graph.get(temp[0]).size(); j++) {
				int[] w = graph.get(temp[0]).get(j);
				if(temp[1]+w[1]>m)continue;
//				if(visited[w[0]])continue;
				if(temp[1]+w[1]<distance[w[0]]) {
					distance[w[0]] = temp[1]+w[1];
//					visited[w[0]] = true;
//					sum+= items[w[0]];
					queue.add(new int[] {w[0],temp[1]+w[1]});
				}
			}
		}
		for (int j = 0; j < n+1; j++) {
			if(distance[j] != Integer.MAX_VALUE)sum+=items[j];
		}
//		System.out.println(Arrays.toString(distance));
//		System.out.println("sum : "+sum);
		answer = Math.max(answer, sum);
	}

}
