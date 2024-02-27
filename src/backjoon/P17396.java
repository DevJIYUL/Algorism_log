package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17396 {
	static int n,m;
	static long[] distance;
	static boolean[] ward;
	static ArrayList<ArrayList<int[]>> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		ward = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ward[i] = Integer.valueOf(st.nextToken())==1?true:false;
		}
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
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
		distance = new long[n];
		Arrays.fill(distance, (long) 100000*300000+1);
		dij(0);

		System.out.println(distance[n-1] == (long) 100000*300000+1?-1:distance[n-1]);
	}
	private static void dij(int i) {
		PriorityQueue<long[]> pqueue = new PriorityQueue<>((o1,o2)->(int)o1[1]-(int)o2[1]);
		pqueue.add(new long[] {i,0});
		distance[i] = 0;
		while (!pqueue.isEmpty()) {
			long[] temp = pqueue.poll();
			long node = temp[0];
			long cost = temp[1];
			if(distance[(int) node]<cost)continue;
			for (int j = 0; j < graph.get((int) node).size(); j++) {
				int[] t = graph.get((int) node).get(j);
				if(t[0] != n-1 && ward[t[0]])continue;
				if(cost+t[1] <distance[t[0]]) {
					distance[t[0]] = cost+t[1];
					pqueue.add(new long[] {t[0],distance[t[0]]});
				}
			}
		}
	}

}
