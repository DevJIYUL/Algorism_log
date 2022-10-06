package com.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9205 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int t,n;
	static Queue<Point> queue;
	static ArrayList<Point> convin;
	static Point destination,house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			convin = new ArrayList<>();
			queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				convin.add(new Point(a, b));
			}
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			destination = new Point(a, b);
			System.out.println(bfs(house));
		}
	}
	private static String bfs(Point h) {
		HashSet<Point> visited= new HashSet<>();
		queue.add(h);
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			visited.add(temp);
			if(Math.abs(temp.x - destination.x)+Math.abs(temp.y - destination.y)<=1000) {
				return "happy";
			}
			for (int i = 0; i < n; i++) {
				if(visited.contains(convin.get(i)))continue;
				int a = convin.get(i).x;
				int b = convin.get(i).y;
				if(Math.abs(temp.x-a)+Math.abs(temp.y-b)<=1000) {
//					house = convin.get(i);
					visited.add(convin.get(i));
					queue.add(convin.get(i));
				}
			}
		}
		return "sad";
	}

}
