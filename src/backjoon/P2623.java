package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2623 {
	static int n,m;
	static int[] indegree;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		indegree = new int[n+1];
		graph = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			for (int j = 0; j < a-1; j++) {
				int c = Integer.valueOf(st.nextToken());
				if(graph[b][c] == 1) {
					b = c;
					continue;
				}
				graph[b][c] = 1;
				b = c;
				indegree[b]++;
			}
		}
//		System.out.println(Arrays.toString(indegree));
//		System.out.println("--------------------");
//		for (int i = 1; i < n+1; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			if(indegree[i] == 0)queue.add(i);
		}
		ArrayList<Integer> arr = new ArrayList<>();
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			arr.add(temp);
			for (int i = 1; i < n+1; i++) {
				if(graph[temp][i] == 0)continue;
				indegree[i]--;
				if(indegree[i] == 0)queue.add(i);
			}
		}
		if(arr.size()==n) {
			for (Integer integer : arr) {
				System.out.println(integer);
			}
		}else {
			System.out.println(0);
		}
	}

}
