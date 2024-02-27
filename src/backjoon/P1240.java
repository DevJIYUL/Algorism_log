package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1240 {
	static int n,m;
	static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a  = Integer.valueOf(st.nextToken());
			int b  = Integer.valueOf(st.nextToken());
			int c  = Integer.valueOf(st.nextToken());
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			boolean[] visited = new boolean[n+1];
			visited[a] = true;
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {a,0});
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				if(temp[0]==b) {
					System.out.println(temp[1]);
					break;
				}
				for (int j = 0; j < graph.get(temp[0]).size(); j++) {
					if(visited[graph.get(temp[0]).get(j)[0]])continue;
					visited[graph.get(temp[0]).get(j)[0]] = true;
					queue.add(new int[] {graph.get(temp[0]).get(j)[0],temp[1]+graph.get(temp[0]).get(j)[1]});
				}
			}
		}
	}

}
