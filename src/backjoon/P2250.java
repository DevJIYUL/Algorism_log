package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P2250 {
	static int[] parent;
	static LinkedList<Integer>[] index;
	static int[][] graph; 
	static int count = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.valueOf(br.readLine());
		parent = new int[n+1];
		index = new LinkedList[n+1];
		graph = new int[n+1][1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.valueOf(st.nextToken());
			int l = Integer.valueOf(st.nextToken());
			int r = Integer.valueOf(st.nextToken());
			graph[p] = new int[] {l,r};
			if(l != -1)parent[l] = p;
			if(r != -1)parent[r] = p;
		}
		int root = -1;
		for (int i = 1; i < parent.length; i++) {
			if(parent[i] == 0) {
				root = i;
				break;
			}
		}
		
		for (int i = 0; i < n+1; i++) {
			index[i] = new LinkedList<>();
		}
		preOrder(root,1);
		int q = 0;
		int a = 0;
		for (int i = 0; i < n+1; i++) {
//			System.out.println(index[i]);
			if(index[i].size() == 0)continue;
			if(a<index[i].getLast() - index[i].getFirst() + 1) {
				q = i;
				a = index[i].getLast() - index[i].getFirst() + 1;
			}
		}
		System.out.println(q+" "+a);
	}
	private static void preOrder(int root, int depth) {
		if(graph[root][0] != -1) {
			preOrder(graph[root][0], depth+1);
		}
		index[depth].add(count++);
		if(graph[root][1] != -1) {
			preOrder(graph[root][1], depth+1);
		}
	}

}
