package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17779 {
	static int[][] graph,map;
	static int n,answer = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0},dy = {0,1,0,-1},arr;
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

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				for (int d1 = 1; d1 < n; d1++) {
					for (int d2 = 1; d2 < n; d2++) {
						if(x+d1+d2>=n || y-d1<0 || y+d2>=n)continue;
						map = new int[n][n];
						border(x,y,d1,d2);
						divide(x,y,d1,d2);
						fifth(x,y);

						arr = new int[5];
						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) {
								arr[map[i][j]-1]+=graph[i][j];
							}
						}
						int max = -1;
						int min = Integer.MAX_VALUE;
						for (int i = 0; i < 5; i++) {
							max = Math.max(max, arr[i]);
							min = Math.min(min, arr[i]);
						}
						answer = Math.min(answer, max-min);
					}
				}
			}
		}
		System.out.println(answer);
	}
	private static void fifth(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		boolean[][] visited = new boolean[n][n];
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny])continue;
				if(map[nx][ny] == 0 || map[nx][ny] == 5) {
					map[nx][ny] = 5;
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});					
				}
			}
		}
	}
	private static void divide(int x, int y, int d1, int d2) {
		for (int r = 0; r < x+d1; r++) {
			for (int c = 0; c <= y; c++) {
				if(map[r][c] == 5)break;
				map[r][c] = 1;
			}
		}
		for (int r = 0; r <= x+d2; r++) {
			for (int c = n-1; c > y; c--) {
				if(map[r][c] == 5)break;
				map[r][c] = 2;
			}
		}
		for (int r = x+d1; r < n; r++) {
			for (int c = 0; c < y-d1+d2; c++) {
				if(map[r][c] == 5)break;
				map[r][c]=3;
			}
		}
		for (int r = x+d2+1; r < n; r++) {
			for (int c = n-1; c >=y-d1+d2; c--) {
				if(map[r][c] == 5)break;
				map[r][c]=4;
			}
		}
	}
	private static void border(int x, int y, int d1, int d2) {
		for (int a = 0; a <= d1; a++) {
			map[x+a][y-a] = 5;
			map[x+d2+a][y+d2-a]=5;
		}
		for (int a = 0; a <= d2; a++) {
			map[x+a][y+a] = 5;
			map[x+d1+a][y-d1+a]=5;
		}
		
	}

}
