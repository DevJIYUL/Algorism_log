package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4803 {
	static int[][] graph;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
//			if(b == 4950)continue;
			if(a == 0 && b == 0) break;
//			if(test == 12)System.out.println(a+ " "+b);
			graph = new int[a+1][a+1];
			parent = new int[a+1];
			for (int i = 0; i < b; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.valueOf(st.nextToken());
				int m = Integer.valueOf(st.nextToken());
				graph[n][m] = 1;
				graph[m][n] = 1;
//				if(test == 12)System.out.println(n+" "+m);
			}
//			for (int i = 0; i < a; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			int count = 0;
			boolean[] visited = new boolean[a+1];
			for (int i = 1; i < a+1; i++) {
				if(visited[i])continue;
				boolean result = bfs(i,visited);
				if(result) count++;
//				System.out.println(i+" "+count+" "+Arrays.toString(visited));
			}
			System.out.println(count==0?"Case "+test+": No trees.":count==1?"Case "+test+": There is one tree.":"Case "+test+": A forest of "+count+" trees.");
			test++;
		}
	}


	private static boolean bfs(int i,boolean[] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,0});
		visited[i] = true;
//		System.out.println(i+" 들어옴");
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
//			System.out.println("temp : "+Arrays.toString(temp));
			for (int k = 1; k < graph[temp[0]].length; k++) {
				if(graph[temp[0]][k] == 0 )continue;
				if(temp[1]==k)continue;
//				System.out.println(k+" 번째 "+graph[temp[0]][k]+" 검사중");
				if(visited[k]) {
//					System.out.println("겹침");
					return false;
				}
//				System.out.println(k+ " 검사할것");
				queue.add(new int[] {k,temp[0]});
				visited[k] = true;
			}
		}
		return true;
	}

}
