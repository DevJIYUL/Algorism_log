package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15681 {
	static int n,r,q;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] size;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		q = Integer.valueOf(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		size = new int[n+1];
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited = new boolean[n+1];
		visited[r] = true;
		make(r);
//		System.out.println(Arrays.toString(size));
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(size[Integer.valueOf(st.nextToken())]);
		}
	}
	private static void make(int root) {
		size[root]=1;
		for (int i = 0; i < graph.get(root).size(); i++) {
			int temp = graph.get(root).get(i);
			if(visited[temp])continue;
			visited[temp] = true;
			make(temp);
			size[root] += size[temp];
		}
	}

}
