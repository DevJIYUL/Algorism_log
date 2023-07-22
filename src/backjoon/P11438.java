package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11438 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[][] parent;
	static int[] depth;
	static boolean[] visited;
	static int size = 0 ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int q = 1;
		while(q<=n) {
			q <<= 1;
			size++;
		}
		parent = new int[n + 1][size];
		depth = new int[n + 1];
		visited = new boolean[n + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited[1] = true;
		makeParent(1,0);
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < n+1; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
		System.out.println(Arrays.toString(depth));
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(parent[i]));
		}
		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			System.out.println(lca(a,b));
		}
	}
	private static int lca(int a, int b) {
//		System.out.println("basic a :"+a+" b : "+b);
		if(depth[a]>depth[b]) {
			int temp = b;
			b = a;
			a = temp;
		}
		for (int i = size-1; i > -1; i--) {
			if(depth[b]-depth[a] >= (1<<i)) {
				b = parent[b][i];
			}
		}
//		System.out.println("changed a :"+a+" b : "+b);
		if(a == b) {
//			System.out.println(b);
			return b;
		}
		for (int i = size-1; i >-1; i--) {
//			System.out.println(parent[a][0]+" "+parent[b][0]);
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
//			System.out.println("a : "+a+" b : "+b);
		}
		return parent[b][0];

	}
	public static void makeParent(int a,int d) {
		depth[a] = d;
		for(Integer i : graph.get(a)) {
			if(visited[i])continue;
			visited[i] = true;
			parent[i][0] = a;
			makeParent(i,d+1);
		}
	}
}
