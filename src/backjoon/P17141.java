package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17141 {
	static int n,m,result=Integer.MAX_VALUE;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static int[][] arr;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<int[]> virus;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				if(graph[i][j] == 2) {
					virus.add(new int[] {i,j});
					graph[i][j]=-2;
				}else if(graph[i][j] == 1)graph[i][j] = -1;
			}
		}
		arr = new int[m][];
		per(0,0);
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}
	private static void per(int index,int count) {
		if(count == m) {
			int[][] temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = graph[i][j];
				}
			}
			for (int[] is : arr) {
				temp[is[0]][is[1]] = 0;
			}
			visited = new boolean[n][n];
			temp = make(temp,arr);
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			int r = isDone(temp);
//			System.out.println(r);
			if(r != -1) result = Math.min(result, r);
			return;
		}
		for (int i = index; i < virus.size(); i++) {
			arr[count] = virus.get(i);
			
			per(i+1,count+1);
		}
	}
	private static int isDone(int[][] temp) {
		int ac = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j]) {
//					if(temp[i][j]!=-1)
						ac = Math.max(ac, temp[i][j]);
					continue;
				}
				if(temp[i][j] == 0||temp[i][j]==-2)return -1;
			}
		}
		return ac;
	}
	private static int[][] make(int[][] temp, int[][] arr2) {
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int[] is : arr2) {
			visited[is[0]][is[1]] = true;
			queue.add(new int[] {is[0],is[1]});
		}
		while (!queue.isEmpty()) {
			int[] t = queue.poll();
//			result = Math.max(result, t[2]);
			for (int i = 0; i < 4; i++) {
				int nx = t[0]+dx[i];
				int ny = t[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny])continue;
				if(temp[nx][ny] == 0||temp[nx][ny] == -2) {
					visited[nx][ny] = true;
					temp[nx][ny] = temp[t[0]][t[1]]+1;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		return temp;
	}

}
