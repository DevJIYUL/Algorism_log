package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3584 {
	/* 가장 가까운 공통 조상*/
	static int test,parent;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] p,d;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		test = Integer.valueOf(st.nextToken());
		for (int i = 0; i < test; i++) {
			st = new StringTokenizer(br.readLine());
			parent = Integer.valueOf(st.nextToken());
			graph = new ArrayList<>();
			for (int j = 0; j <= parent; j++) {
				graph.add(new ArrayList<>());
			}
			p = new int[parent+1];
			d = new int[parent+1];
			for (int j = 0; j < parent-1; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				graph.get(a).add(b);
				p[b] = a;
			}
			//			boolean[] visited = new boolean[parent+1];
			Queue<int[]> queue = new LinkedList<int[]>();
			int king = 0;
			for (int j = 1; j < parent+1; j++) {
				if(p[j] == 0) {
					king = j;
					break;
				}
			}
			queue.add(new int[] {king,0});
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				d[temp[0]] = temp[1];
				for (int j = 0; j < graph.get(temp[0]).size(); j++) {
					queue.add(new int[] {graph.get(temp[0]).get(j),temp[1]+1});
				}
			}
//			System.out.println(graph);
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(d));
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			//a 가 높이가 작게 맞춘다.
//			System.out.println(a);
//			System.out.println(b);
			if(d[a]>d[b]) {
				int t = a;
				a = b;
				b = t;
			}
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println("before : "+d[a]+" "+d[b]);
			int c = d[b]-d[a];
			if(d[a]<d[b]) {
				for (int j = 0; j < c; j++) {
					b = p[b];
//					System.out.println(a+ " "+b);
//					System.out.println("after : "+d[a]+" "+d[b]);
				}
			}
//			System.out.println(p[a]+" "+p[b]);
//			System.out.println("after : "+d[a]+" "+d[b]);
			if(a==b)System.out.println(a);
			else {

				while(p[a] != p[b]) {
					a= p[a];
					b=p[b];
				}
				System.out.println(p[a]);
			}
		}
	}

}
