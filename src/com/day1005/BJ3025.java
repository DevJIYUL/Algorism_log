package com.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ3025 {
	static class Point implements Comparable<Point>{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.x!=o.x?this.x-o.x:this.y-o.y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+x+" "+y+"]";
		}

	}
	static int r,c;
	static char[][] graph;
	static TreeSet<Point> ts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new char[r+1][c];
		ts = new TreeSet<>();
		for (int i = 0; i < r; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);
				if (graph[i][j]=='X') ts.add(new Point(i, j));
			}
		}
		for (int i = 0; i < c; i++) {
			ts.add(new Point(r, i));
		}
		Arrays.fill(graph[r], 'X');
		st = new StringTokenizer(br.readLine().trim());
		int doll = Integer.parseInt(st.nextToken());
		for (int i = 0; i < doll; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int index = Integer.parseInt(st.nextToken());
			Point d = ts.higher(new Point(0, index-1));
			if(d.x == r) {
				
			}
			drop();
		}
	}
	private static void drop(Point point) {
		// 땅바닥에 떨이질경우
				if(point.x == r) {
					
					return;
				}
				// 돌 떨어트려보고
				Point temp = ts.higher(point);
				
				if(temp == null)
		
	}
}
