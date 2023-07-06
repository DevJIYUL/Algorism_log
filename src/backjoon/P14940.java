package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14940 {
	static int[][] graph,result;
	static boolean[][] visited;
	static int n,m,a,b;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				if(graph[i][j] == 2) {
					a = i;
					b = j;
				}
			}
		}
		bfs(a,b);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && graph[i][j] == 1)System.out.print(-1+" ");
				else System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	
	}
	private static int bfs(int i, int j) {
	
		visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[i][j] = true;
		queue.add(new int[] {i,j,0});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
//			if(graph[temp[0]][temp[1]] == 2)return temp[2];
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m||graph[nx][ny] == 0||visited[nx][ny])continue;
				queue.add(new int[] {nx,ny,temp[2]+1});
				visited[nx][ny] = true;
				result[nx][ny] = result[temp[0]][temp[1]]+1;
			}
		}
		return -1;
	}

}
