package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1799 {
	static int n;
	static int[] answer = new int[2];
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		visited = new boolean[n][n]; 
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				visited[i][j] = (i%2==0 && j%2==0)||(i%2==1&&j%2==1);
			}
		}
		chess(0,true,0);
		chess(0,false,0);

		System.out.println(answer[0]+answer[1]);
//		System.out.println(total);
	}
	private static void chess(int i, boolean j, int bishop) {
		for (int k = i; k < n*n; k++) {
			int x = k/n;
			int y = k%n;
			
			if(graph[x][y] == 0||visited[x][y] != j||!check(x, y))
				continue;
			graph[x][y] = -1;
			chess(k+1, j, bishop+1);
			graph[x][y] = 1;
		}
		answer[j?0:1] = Math.max(answer[j?0:1], bishop);
	}
	private static boolean check(int i, int j) {
		int[] dx = {-1,-1,1,1};
		int[] dy = {1,-1,1,-1};
		for (int k = 0; k < 2; k++) {
			for (int q = 1; q <= n; q++) {
				int nx = i + dx[k]*q;
				int ny = j + dy[k]*q;
				if(nx<0||ny<0||nx>=n||ny>=n)break;
				if(graph[nx][ny] == -1)return false;
			}
		}
		return true;
	}

}

