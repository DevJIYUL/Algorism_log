package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
	static int n,result,height;
	static int[][] graph;
	static boolean[][] visited;
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
		
		for (int index = 0; index < 101; index++) {
			int count = 0;
			visited= new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i][j]>index && !visited[i][j]) {
						bfs(i,j,index);
						count++;
					}
				}
				
			}
//			System.out.println("---index----"+index+"----count------"+count);
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			if(result <= count) {
				result = count;
				height = index;
			}
		}
		System.out.println(result);
	}
	private static void bfs(int i, int j, int index) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		visited[i][j] = true;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {i,j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1] + dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n)continue;
				if(graph[nx][ny]<=index || visited[nx][ny])continue;
				queue.add(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}
	}

}
