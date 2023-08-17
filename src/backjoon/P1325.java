package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {
	static int n,m;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		list = new int[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
		}
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
//		System.out.println(Arrays.toString(list));
		int m = 0;
		for (int i = 1; i < n+1; i++) {
			m = Math.max(m, list[i]);
		}
//		System.out.println(m);
		for (int i = 0; i < n+1; i++) {
			if(list[i] == m)System.out.print(i+" ");
		}
	}
	private static void bfs(int i) {
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		list[i]++;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int j = 0; j < graph.get(temp).size(); j++) {
//				if(graph == 0)continue;
				if(visited[graph.get(temp).get(j)])continue;
				queue.add(graph.get(temp).get(j));
				visited[graph.get(temp).get(j)] = true;
				list[graph.get(temp).get(j)]++;
			}
		}
	}

}
