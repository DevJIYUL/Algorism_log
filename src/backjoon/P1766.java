package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1766 {
	static int n,m;
	static int[] to;
	static ArrayList<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		to = new int[n+1];
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			to[b]++;
		}
		PriorityQueue<Integer> pqueue = new PriorityQueue<>();
		for (int i = 1; i < n+1; i++) {
			if(to[i] == 0) pqueue.add(i);
			
		}
		while (!pqueue.isEmpty()) {
			int now = pqueue.poll();
			sb.append(now+" ");
			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				to[next]--;
				if(to[next] == 0)pqueue.add(next);
			}
		}
		System.out.println(sb);
	}


}
