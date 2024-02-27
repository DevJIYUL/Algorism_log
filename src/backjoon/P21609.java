package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P21609 {
	static int n,m,answer,dx[]= {0,1,0,-1},dy[] = {1,0,-1,0};
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		while (true) {
			PriorityQueue<int[]> pqueue = choose();
			if(pqueue.size() == 0)break;
			int[] delete = pqueue.poll();
			int present = graph[delete[0]][delete[1]];
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] v = new boolean[n][n];
			v[delete[0]][delete[1]] = true;
			queue.add(new int[] {delete[0],delete[1]});
//			System.out.println("delete => "+Arrays.toString(delete));
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			while (!queue.isEmpty()) {
				int[] t= queue.poll();
				graph[t[0]][t[1]] = -2;
				for (int i = 0; i < 4; i++) {
					int nx = t[0]+dx[i];
					int ny = t[1]+dy[i];
					if(nx<0||ny<0||nx>=n||ny>=n||v[nx][ny])continue;
					if(graph[nx][ny] == 0||graph[nx][ny] == present) {
						v[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
			answer += delete[2]*delete[2];
//			System.out.println("----- -2 작업후 -------");
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
//			System.out.println("------중력 작업후-----");
			gravity();
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
//			System.out.println("------돌리고 후-----");
			turn();
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			gravity();
//			System.out.println("------중력 후-----");
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
		}
		System.out.println(answer);
	}
	private static void turn() {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = graph[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = temp[j][n-i-1];
			}
		}
	}
	private static void gravity() {
		for (int i =0; i < n; i++) {
			for (int j =  n-1; j >-1; j--) {
				if(graph[j][i] == -1||graph[j][i] == -2)continue;
				for (int j2 = j+1; j2 < n; j2++) {
					if(graph[j2][i] == -2) {
						graph[j2][i] = graph[j2-1][i];
						graph[j2-1][i] = -2;
					}else {
						break;
					}
				}
			}
		}
	}
	public static PriorityQueue<int[]> choose(){
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o2[2]!=o1[2]?o2[2]-o1[2]:o1[3]!=o2[3]?o2[3]-o1[3]:o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1]);
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j]||graph[i][j] == -1||graph[i][j] == -2||graph[i][j] == 0)continue;
				int[] info = bfs(i,j,visited);
//				System.out.println(i+" "+j+ " "+info[2]);
				if(info[2] > 1)pq.offer(info);
				for (int k = 0; k < n; k++) {
					for (int k2 = 0; k2 < n; k2++) {
						if(graph[k][k2] == 0&&visited[k][k2])visited[k][k2] = false;
					}
				}
			}
		}
//		for (int i = 0; i < pq.size(); i++) {
//			if(pq.peek()[2] == 1)pq.poll();
//		}
		return pq;
	}
	public static int[] bfs(int i,int j,boolean[][] v) {
		Queue<int[]> queue = new LinkedList<int[]>();
		v[i][j] = true;
		int count = 1;
		int rainbow = 0;
		queue.add(new int[] {i,j});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n||v[nx][ny])continue;
				if(graph[nx][ny] == 0||graph[nx][ny] == graph[i][j]) {
					v[nx][ny] = true;
					count++;
					if(graph[nx][ny] == 0)rainbow++;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		return new int[] {i,j,count,rainbow};
	}
}
