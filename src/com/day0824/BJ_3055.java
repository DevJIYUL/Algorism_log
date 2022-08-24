package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055 {
	static int r, c, count;
	static char[][] graph;
	static boolean[][] visited, waterVisited;
	static int[] destination, docci;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<int[]> water;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new char[r][c];
		visited = new boolean[r][c];
		waterVisited = new boolean[r][c];
		water = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			graph[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (graph[i][j] == 'D') {
					destination = new int[] { i, j };
				} else if (graph[i][j] == 'S') {
					docci = new int[] { i, j };
				} else if (graph[i][j] == '*') {
					water.offer(new int[] { i, j, 0 });
					waterVisited[i][j] = true;
				}
			}
		}

		if (bfs(docci)) {
			System.out.println(++count);
		} else {
			System.out.println("KAKTUS");
		}

	}

	private static boolean bfs(int[] docci) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { docci[0], docci[1], 0 });
		visited[docci[0]][docci[1]] = true;
		boolean flag = false;
		// 물 이동
		while (true) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(graph[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("-----------------");
			if (flag) {
				return true;
			} else if (queue.isEmpty()) {
				return false;
			}
			moveWater();
			while (!queue.isEmpty()) {
//				for (int i = 0; i < queue.size(); i++) {
//					System.out.print(queue.peek()[0] + " " + queue.peek()[1] + " " + queue.peek()[2] + " | ");
//				}
//				System.out.println();
				if (queue.peek()[2] > count) {
					break;
				}
				int[] temp = queue.poll();
				System.out.println(Arrays.toString(temp));
				
				for (int i = 0; i < 4; i++) {
					int nx = temp[0] + dx[i];
					int ny = temp[1] + dy[i];
					if (0 > nx || 0 > ny || r <= nx || c <= ny || visited[nx][ny]||graph[nx][ny] == 'X') {
						continue;
					}
					if (graph[nx][ny] == '*') {
						continue;
					}
					if (graph[nx][ny] == 'D') {
						System.out.println("도착");
						flag = true;
						break;
					}
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, temp[2] + 1 });
					graph[nx][ny] = 'S';
				}
			}
			if (flag) {
				break;
			}
			count++;
		}
		return flag;

	}

	private static void moveWater() {
		while (!water.isEmpty()) {
//			System.out.println("-----------------------");
//			System.out.println(water.peek()[2] + " " + count);
			if (water.peek()[2] > count) {
				break;
			}
			int[] temp = water.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (0 > nx || 0 > ny || r <= nx || c <= ny || graph[nx][ny] == 'X' || graph[nx][ny] == 'D'
						|| waterVisited[nx][ny]||graph[nx][ny] == 'S') {
					continue;
				}
				waterVisited[nx][ny] = true;
				graph[nx][ny] = '*';
				water.offer(new int[] { nx, ny, temp[2] + 1 });
			}
		}
	}

}
