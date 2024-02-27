package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P16988 {
	static int n,m;
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1},dy= {0,-1,-1,0,1,1,1,0,-1};
	static int[] dr = {1,1,-1,-1},dc = {1,-1,1,-1};
	static int[][] graph;
	static LinkedList<int[]> clould;
	static boolean[][] clouldVisted;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		clould = new LinkedList();
		clould.add(new int[] {n,1});
		clould.add(new int[] {n,2});
		clould.add(new int[] {n-1,1});
		clould.add(new int[] {n-1,2});
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.valueOf(st.nextToken());
			int s = Integer.valueOf(st.nextToken());
			int size = clould.size();
			for (int j = 0; j < s; j++) {
				for (int k = 0; k < size; k++) {
					int[] temp = clould.poll();
//					System.out.println(Arrays.toString(temp));
					int nx = temp[0]+dx[d];
					int ny = temp[1]+dy[d];
					nx = nx==0?n:nx==n+1?1:nx;
					ny = ny==0?n:ny==n+1?1:ny;
					clould.add(new int[] {nx,ny});
				}
			}
			clouldVisted = new boolean[n+1][n+1];
			for (int j = 0; j < size; j++) {
				int[] temp = clould.poll();
				// System.out.println(Arrays.toString(temp));
				clouldVisted[temp[0]][temp[1]] = true;
				graph[temp[0]][temp[1]]++;
				clould.add(temp);
			}
			for (int a = 0; a < size; a++) {
				int[] temp = clould.poll();
				for (int j = 0; j < 4; j++) {
					int nx = temp[0]+dr[j];
					int ny = temp[1]+dc[j];
					if(nx==0||ny==0||nx==n+1||ny==n+1||graph[nx][ny]==0)continue;
					graph[temp[0]][temp[1]]++;
				}
			}
			for (int j = 1; j <= n; j++) {
				for (int q = 1; q <= n; q++) {
					if(clouldVisted[j][q])continue;
					if(graph[j][q]>=2) {
						clould.add(new int[] {j,q});
						graph[j][q] -=2;
					}
				}
			}
	
		}
		int result = 0;
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				result += graph[a][b];
			}
		}
		System.out.println(result);
	}

}
