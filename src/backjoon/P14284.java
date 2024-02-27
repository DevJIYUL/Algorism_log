package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14284 {
	static int n,m,s,t;
	static ArrayList<ArrayList<int[]>> graph;
	static int[] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m=Integer.valueOf(st.nextToken());
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.valueOf(st.nextToken());
		t = Integer.valueOf(st.nextToken());
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {s,0});
		distance[s] = 0;
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			for (int[] in : graph.get(temp[0])) {
				if(distance[in[0]]<=distance[temp[0]]+in[1])continue;
				distance[in[0]] = distance[temp[0]]+in[1];
				pqueue.add(new int[] {in[0],distance[in[0]]});
			}
		}
//		System.out.println(Arrays.toString(distance));
		System.out.println(distance[t]);
	}

}
