package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {
	static int n,m,num,size;
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					size = Math.max(size,GO(i,j));
					num++;
				}
			}
		}
		System.out.println(num);
		System.out.println(size);
	}
	private static int GO(int i, int j) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int count = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||graph[nx][ny] == 0) continue;
				queue.add(new int[] {nx,ny});
				visited[nx][ny] = true;
				count++;
			}
		}
		return count;
	}

}
