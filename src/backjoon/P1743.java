package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1743 {
	static int n,m,k;
	static char[][] graph;
	static int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], '.');
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			graph[a-1][b-1] = '*';
		}

		int result = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && graph[i][j] == '*') {
					Queue<int[]> queue = new LinkedList<int[]>();
					visited[i][j] = true;
					queue.add(new int[] {i,j});
					int size = 1;
					while (!queue.isEmpty()) {
						int[] temp = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nx = temp[0]+dx[k];
							int ny = temp[1]+dy[k];
							if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||graph[nx][ny] == '.')continue;
							visited[nx][ny] = true;
							queue.add(new int[] {nx,ny});
							size++;
						}
					}
					result = Math.max(result, size);
				}
			}
		}
		System.out.println(result);
	}

}
