package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5567 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		int m = Integer.valueOf(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int answer = 0;
		boolean[] visited = new boolean[n+1];
		visited[1]= true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {1,0});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
//			System.out.println(Arrays.toString(temp));
			for (int i = 0; i < graph.get(temp[0]).size(); i++) {
				if(visited[graph.get(temp[0]).get(i)] || temp[1] == 2)continue;
				visited[graph.get(temp[0]).get(i)] = true;
				queue.add(new int[] {graph.get(temp[0]).get(i),temp[1]+1});
				answer++;
			}
		}
//		System.out.println(Arrays.toString(visited));
		System.out.println(answer);
	}

}
