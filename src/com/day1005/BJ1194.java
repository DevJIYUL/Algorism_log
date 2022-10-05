package com.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1194 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static class Minsik{
		int x,y,count;
		int bit;
		public Minsik(int x, int y, int count, int bit) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.bit = bit;
		}
		
	}
	static int n,m;
	static char[][] graph;
	static boolean[][][] visited;
	static Point zero;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new char[n][m];
		visited = new boolean[n][m][1<<6];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j);
				if(graph[i][j] == '0') zero = new Point(i, j);
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
		System.out.println(travel());
		// x,y,keys,count
	
	}
	private static int travel() {
		PriorityQueue<Minsik> pqueue = new PriorityQueue<>((o1,o2)->o1.count!=o2.count?o1.count-o2.count:o2.bit-o1.bit);
		pqueue.add(new Minsik(zero.x, zero.y, 0, 0));
		visited[zero.x][zero.y][0] = true;
//		System.out.println("시작");
		while (!pqueue.isEmpty()) {
			Minsik temp = pqueue.poll();
			if(graph[temp.x][temp.y]== '1') {
//				System.out.println("출구 찾음!!!!!!");
				return temp.count;
			}
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				int nk = temp.bit;
				if(nx<0||ny<0||nx>=n||ny>=m||graph[nx][ny] == '#'||visited[nx][ny][nk]) continue;
				if(graph[nx][ny]>='a' && graph[nx][ny] <= 'f') {
					int shift = graph[nx][ny] -'a';
					int key = 1<<shift;
					nk = temp.bit | key;
				}else if(graph[nx][ny]>='A' && graph[nx][ny] <= 'F') {
					int key = 1<<(graph[nx][ny]-'A');
					if((temp.bit & key)==0)continue;
				}
				pqueue.add(new Minsik(nx, ny, temp.count+1, nk));
				visited[nx][ny][nk] = true;
			}
		}
		return -1;
		
	}

}
