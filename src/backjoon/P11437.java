package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11437 {

	static int[] parent = new int[50001]; 
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		visited = new boolean[n+1];
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited[1] = true;
		makeParent(1);

		int m = Integer.valueOf(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());

			int depa = depth(a, 0);
			int depb = depth(b, 0);
			if(depa<depb) {
				for (int j = 0; j < depb-depa; j++) {
					b = parent[b];
				}
			}else if (depa>depb) {
				for (int j = 0; j < depa-depb; j++) {
					a = parent[a];
				}
			}
			while (true) {
				if(a == b) {
					System.out.println(a);
					break;
				}
				if(parent[a] == parent[b]) {
					System.out.println(parent[a]);
					break;
				}
				a = parent[a];
				b = parent[b];
			}
		}
	}
	private static void makeParent(int i) {
		for (Integer a : graph.get(i)) {
			if(visited[a]) continue;
			parent[a] = i;
			visited[a] = true;
			makeParent(a);
		}
	}
	static int depth(int a,int dep) {
		if(parent[a] == 0)return dep;
		a = parent[a];
		return depth(a,dep+1);
	}

}
