package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854 {
	static int n,m,k,graph[][];
	static PriorityQueue<Integer>[] pq; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		pq = new PriorityQueue[n];
		for (int i = 0; i < n; i++) {
			pq[i] = new PriorityQueue<>((o1,o2)->o2-o1);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph[a-1][b-1] = c;
		}
		dij(0);
		for (int i = 0; i < n; i++) {
			if(pq[i].size()==k)System.out.println(pq[i].peek());
			else System.out.println(-1);
		}
	}
	public static void dij(int start) {
		 PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		 pqueue.add(new int[] {start,0});
		 pq[start].add(0);
		 while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
			int node = temp[0];
			int cost = temp[1];
			for (int i = 0; i < n; i++) {
				if(graph[node][i] == 0)continue;
				if(pq[i].size() <k) {
					pq[i].add(cost+graph[node][i]);
					pqueue.add(new int[] {i,cost+graph[node][i]});
				}else if(pq[i].peek()>cost+graph[node][i]){
					pq[i].poll();
					pq[i].add(cost+graph[node][i]);
					pqueue.add(new int[] {i,cost+graph[node][i]});
				}
			}
		}
	}

}
