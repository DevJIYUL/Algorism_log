package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
	static char[][] graph;
	static int n,m,result=1;
	static Queue<int[]> fire,jihun;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static boolean flag;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new char[n][m];
		visited = new boolean[n][m];
		fire = new LinkedList<int[]>();
		jihun = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j);
				if(graph[i][j] == 'F')fire.add(new int[] {i,j});
				else if(graph[i][j] == 'J') {
					jihun.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
//		System.out.println(fire);
//		print();
		while (true) {
			fire();
			if(move()) {
				flag = true;
				break;
			}
			result++;
			if(jihun.size() == 0) {
				flag = false;
				break;
			}
//			System.out.println("-------------");
//			print();
		}
		if(!flag) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(result);
		}
	}
	private static boolean move() {
		int j = jihun.size();
		for (int i = 0; i < j; i++) {
			int[] temp = jihun.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0] + dx[k];
				int ny = temp[1] + dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m) return true;
				if(visited[nx][ny]||graph[nx][ny] == '#'||graph[nx][ny] == 'F')continue;
				if(graph[temp[0]][temp[1]] == 'J') graph[temp[0]][temp[1]] ='.';
				if(graph[nx][ny] == '.') {
					graph[nx][ny] = 'J';
					jihun.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		return false;
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
	}
	private static void fire() {
		int size = fire.size();
		for (int i = 0; i < size; i++) {
			int[] temp = fire.poll();
			for (int j = 0; j < 4; j++) {
				int nx = temp[0]+dx[j];
				int ny = temp[1]+dy[j];
				if(nx<0||ny<0||nx>=n||ny>=m)continue;
				if(graph[nx][ny] == '#'||graph[nx][ny] == 'F')continue;
				if(graph[nx][ny] == 'J'||graph[nx][ny] == '.') {
					fire.add(new int[] {nx,ny});
					graph[nx][ny] = 'F';
				}
			}
		}
	}

}
