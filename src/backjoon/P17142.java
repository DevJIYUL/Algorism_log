package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17142 {
	static boolean[] visited;
	static ArrayList<int[]> virus;
	static int[] arr;
	static int[][] graph,elect;
	static int n,m,result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		elect = new int[m][2];
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.valueOf(st.nextToken());
				if(a == 2) {
					virus.add(new int[] {i,j});
				}
				graph[i][j] = -a;
			}
//			System.out.println(Arrays.toString(graph[i]));
		}
		visited = new boolean[virus.size()];
//		System.out.println(virus);
		per(0,0);
		System.out.println(result == Integer.MAX_VALUE?-1:result);
	}
	private static void per(int index, int count) {
		if(count == m) {
//			System.out.println(Arrays.toString(elect[0])+ " "+Arrays.toString(elect[1]));
			go(elect);
			return;
		}
		for (int i = index; i < virus.size(); i++) {
			if(visited[i])continue;
			elect[count] = virus.get(i);
			visited[i] = true;
			per(i+1,count+1);
			visited[i] = false;
		}
		
	}
	private static void go(int[][] elect2) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = graph[i][j];
			}
		}
		boolean[][] v = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int[] i : elect2) {
			v[i[0]][i[1]] = true;
			temp[i[0]][i[1]] = 0;
			queue.add(new int[] {i[0],i[1],0});
		}
		int num = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!v[i][j] && temp[i][j] == 0) {
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		if(!flag) {
			result = Math.min(num, result);
		}
		while (!queue.isEmpty()) {
			int[] t = queue.poll();
//			System.out.println(Arrays.toString(t));
			for (int i = 0; i < 4; i++) {
				int nx = t[0]+dx[i];
				int ny = t[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n||v[nx][ny])continue;
				if(temp[nx][ny] == 0 || temp[nx][ny] == -2) {
					temp[nx][ny] = temp[t[0]][t[1]]+1;
					v[nx][ny] = true;
					queue.add(new int[] {nx,ny,t[2]+1});
					num = Math.max(num, t[2]+1);
				}
			}
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!v[i][j] && temp[i][j] == 0) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(!flag) {
				result = Math.min(num, result);
			}
		}

	}

}
