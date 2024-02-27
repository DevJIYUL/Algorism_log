package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9372 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.valueOf(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int nation,plane;
			nation = Integer.valueOf(st.nextToken());
			plane = Integer.valueOf(st.nextToken());
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int j = 0; j < nation+1; j++) {
				graph.add(new ArrayList<>());
			}
			for (int j = 0; j < plane; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			int result = 0;
			boolean[] visited = new boolean[nation+1];
			for (int j = 1; j < nation+1; j++) {
				if(!visited[j]) {
//					System.out.println(Arrays.toString(visited));
					result += bfs(j,visited,graph);
//					System.out.println(Arrays.toString(visited));
				}
			}
			System.out.println(nation-1);
		}

	}

	private static int bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		int count = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int j = 0; j < graph.get(temp).size(); j++) {
				int w = graph.get(temp).get(j);
				if(visited[w]) continue;
				visited[w] = true;
				count++;
				queue.add(w);
			}
		}
		return count;
	}

}
