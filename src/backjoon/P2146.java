package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2146 {
	static int[][] graph;
	static int land = 2,n,result = Integer.MAX_VALUE;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(graph[i][j] == 1) {
					makeLand(i,j);
					land++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(graph[i][j]>=2) {
					makeBridge(i,j,graph[i][j]);
				}
			}
		}
		System.out.println(result);
	}
	private static void makeBridge(int i, int j, int w) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		visited[i][j] = true;
		queue.add(new int[] {i,j,0});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny])continue;
				if(graph[nx][ny]==0||graph[nx][ny] == w) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny,temp[2]+1});
				}else {
					result = Math.min(result, temp[2]);
				}
			}
		}
	}
	private static void makeLand(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][n];
		visited[i][j] = true;
		graph[i][j] = land;
		queue.add(new int[] {i,j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n||graph[nx][ny] ==0||visited[nx][ny])continue;
				graph[nx][ny] = land;
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny});
			}
		}
		
	}

}
