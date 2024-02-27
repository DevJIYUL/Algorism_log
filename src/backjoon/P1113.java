package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1113 {
	static int n,m,answer,dx[] = {0,1,0,-1},dy[] = {1,0,-1,0};
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j)-'0';
			}
		}
		for(int k = 2; k < 10 ; k++) {
			visited = new boolean[n][m];
			for(int i = 0; i < n;i++) {
				for(int j = 0; j<m;j++) {
					if(graph[i][j] >= k||visited[i][j])continue;
					go(i,j,k);
				}
			}
		}

		System.out.println(answer);
	}
	public static void go(int i,int j,int k) {
//		System.out.println(i+" "+j+" "+k);
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int [] {i,j});
		LinkedList<int[]> nextUpdate = new LinkedList<>();
		nextUpdate.add(new int[] {i,j});
		visited[i][j] = true;
		boolean flood = false;
		while (!queue.isEmpty()) {
			int[] t= queue.poll();
			for (int l = 0; l < 4; l++) {
				int nx = t[0]+dx[l];
				int ny = t[1]+dy[l];
				if(nx<0||ny<0||nx>=n||ny>=m) {
					flood = true;
					continue;
				}
				if(visited[nx][ny])continue;
				if(graph[nx][ny]<k) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					nextUpdate.add(new int[] {nx,ny});
				}
			}
		}
//		System.out.println("flood : "+flood);
		if(!flood) {
			for (int[] ls : nextUpdate) {
				graph[ls[0]][ls[1]]++;
				answer++;
			}
//			for (int l = 0; l < n; l++) {
//				System.out.println(Arrays.toString(graph[l]));
//			}
		}
	}
}


