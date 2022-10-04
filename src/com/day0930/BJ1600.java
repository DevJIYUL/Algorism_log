package com.day0930;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class BJ1600 {
	static class Point{
		int x,y,count,kth;

		public Point(int x, int y, int count, int kth) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.kth = kth;
		}
		
	}
	static int k,w,h;
	static int[][] graph;
	static boolean[][][] d;
	static int[] mondx = {1,0,-1,0};
	static int[] mondy = {0,-1,0,1};
	static int[] hordx = {-1,-1,-2,-2,1,1,2,2};
	static int[] hordy = {-2,2,-1,1,-2,2,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		graph = new int[h][w];
		d = new boolean[h][w][k+1];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < w; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
		
	}
	private static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0, 0));
		d[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			int count = temp.count;
			int kdx = temp.kth;
			if(x == h-1 && y == w-1) {
				return count;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + mondx[i];
				int ny = y + mondy[i];
				if(nx<0||ny<0||nx>=h||ny>=w||graph[nx][ny] == 1||d[nx][ny][kdx])continue;
				d[nx][ny][kdx] = true;
				queue.add(new Point(nx, ny, count+1, kdx));
			}
			if(k<=kdx)continue;
			for (int i = 0; i < 8; i++) {
				int nx = x + hordx[i];
				int ny = y + hordy[i];
				if(nx<0||ny<0||nx>=h||ny>=w||graph[nx][ny] == 1||d[nx][ny][kdx+1])continue;
				d[nx][ny][kdx+1] = true;
				queue.add(new Point(nx, ny, count+1, kdx+1));
			}
		}
		return -1;		
	}
}