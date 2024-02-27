package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3184 {
	static int n,m,wolf,sheep;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new char[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j] == '#'||visited[i][j])continue;
				int[] result = bfs(i,j);
				if(result[0] == 0 && result[1] == 0)continue;
				else if(result[0]>result[1]) sheep+=result[0];
				else wolf+=result[1];
//				System.out.println("["+i+","+j+"] 좌표");
//				System.out.println(Arrays.toString(result));
			}
		}
		System.out.println(sheep+" "+wolf);
	}
	private static int[] bfs(int i,int j) {
		int[] result = new int[2];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		if(graph[i][j]=='o')result[0]++;
		else if(graph[i][j]=='v')result[1]++;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m||graph[nx][ny] == '#'||visited[nx][ny])continue;
				if(graph[nx][ny] == 'o')result[0]++;
				else if(graph[nx][ny] == 'v')result[1]++;
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny});
			}
		}
		return result;
	}

}
