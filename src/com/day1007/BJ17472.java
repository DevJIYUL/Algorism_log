package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17472 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+x+" "+y+"]";
		}

	}
	static int n,m,island,bridgeCount;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static HashMap<Integer, ArrayList<Point>> islandInfo;
	static HashSet<Integer> islandVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		islandInfo = new HashMap<>();
		islandVisited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		island = 0;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j] != 0 && !visited[i][j]) {
					island++;
					islandInfo.put(island, new ArrayList<>());
					islandInfo.get(island).add(new Point(i, j));
					draw(i,j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println(islandInfo);
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
		for (Entry<Integer, ArrayList<Point>> info : islandInfo.entrySet()) {
			// q 0번째가 다리 길이 1번쨰가 시작섬 ,2번쨰가 도착섬
			for (Point point : info.getValue()) {
				// 섬하나를 4방 탐색한다 한방향으로 쭉 나아가 본다 섬에 도착하면 거리와 섬이름을 pq에 넣어준다.
				int x = point.x;
				int y = point.y;
				for (int i = 0; i < 4; i++) {
					int count = 0;
					for (int j = 1; j < 20; j++) {
						int nx = x + dx[i]*j;
						int ny = y + dy[i]*j;
						if(nx<0||ny<0||nx>=n||ny>=m||graph[x][y] == graph[nx][ny]) break;
						if(graph[nx][ny] != 0 && count != 1) {
							pqueue.add(new int[] {count,graph[x][y],graph[nx][ny]});
							break;
						}else if(graph[nx][ny] != 0 && count == 1) {
							break;
						}
						count++;
					}
				}
			}
		}
		System.out.println(pqueue.size());
		System.out.println(island);
		boolean arrival = false;
		int edge = 0;
		while (!pqueue.isEmpty()) {
			int[] bridge = pqueue.poll();
			int cnt = bridge[0];
			int start = bridge[1];
			int end = bridge[2];
			if(islandVisited.contains(start) && islandVisited.contains(end))continue;
			if(!islandVisited.contains(start) || !islandVisited.contains(end)) {
				islandVisited.add(start);
				islandVisited.add(end);
				bridgeCount += cnt;
				edge++;
				System.out.println(start+" 섬과 "+end+" 섬 연결 다리 수는 : "+cnt+"  지금 까지 길이 : "+bridgeCount );
			}
			if(edge == island-1) {
				arrival = true;
				break;
			}
		}
		if(!arrival) {
			System.out.println(-1);
		}else {
			System.out.println(bridgeCount);
		}
	}






	private static void draw(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {i,j});
		visited[i][j] = true;
		graph[i][j] = island;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||graph[nx][ny] == 0) continue;
				graph[nx][ny] = island;
				islandInfo.get(island).add(new Point(nx, ny));
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny});
			}
		}
	}

}
