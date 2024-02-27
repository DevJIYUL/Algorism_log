package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import backjoon.P9376.Node;
import backjoon.P9376.Point;

public class P9375second {
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	static class Node{
		Point point;
		int count;
		@Override
		public String toString() {
			return "Node [point=" + point + ", count=" + count + ", set=" + set + "]";
		}
		HashSet<Point> set;
		public Node(Point point, int count, HashSet<Point> set) {
			super();
			this.point = point;
			this.count = count;
			this.set = set;
		}
		
	}
	static int test,n,m;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static char[][] graph;
	static boolean[][] visited;
	static ArrayList<Point> persons;
	static ArrayList<HashSet<Point>> p1,p2;
	static HashSet<Point>[][] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		test = Integer.valueOf(st.nextToken());
		for (int i = 0; i < test; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			distance = new HashSet[n+2][m+2];
			p1 = new ArrayList<>();
			p2 = new ArrayList<>();
			persons = new ArrayList<>();
			graph = new char[n+2][m+2];
			for (int j = 0; j < distance.length; j++) {
				for (int j2 = 0; j2 < distance[j].length; j2++) {
					distance[j][j2] = new HashSet<>();
				}
			}
			Arrays.fill(graph[0], '.');
			Arrays.fill(graph[n+1], '.');
			for (int j = 1; j <= n; j++) {
				String input = br.readLine();
				Arrays.fill(graph[j], '.');
				for (int k = 0; k < m; k++) {
					graph[j][k+1] = input.charAt(k);
					if(graph[j][k+1] == '$') {
						persons.add(new Point(j, k+1));
					}
				}
			}
			
			dij(new Point(0, 0));
			System.out.println(p1);
			System.out.println(p2);
			HashSet<Point> result = new HashSet<>();
			result.addAll(distance[persons.get(0).x][persons.get(0).y]);
			result.addAll(distance[persons.get(1).x][persons.get(1).y]);
			System.out.println(result.size());
		}
	}
	private static void dij(Point point) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o1.count-o2.count);
		pqueue.add(new Node(point, 0, new HashSet<>()));
		//pqueue.add(new Node(point.get(1), 0	, new HashSet<>()));
		boolean[][] visited = new boolean[n+2][m+2];
		visited[point.x][point.y]= true;
		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();
			//System.out.println(node);
			for (int i = 0; i < 4; i++) {
				int nx = node.point.x+dx[i];
				int ny = node.point.y+dy[i];
				if(nx<0||ny<0||nx>=n+2||ny>=m+2||visited[nx][ny]||graph[nx][ny]=='*')continue;
				//System.out.println(nx+" "+ny);
				visited[nx][ny] = true;
				if(graph[nx][ny] == '#') {
					distance[nx][ny].add(new Point(nx, ny));
					distance[nx][ny].addAll(node.set);
					pqueue.add(new Node(new Point(nx, ny), node.count+1, distance[nx][ny]));
				}else {
					if(nx == persons.get(0).x && ny == persons.get(0).y) {
						p1.add(node.set);
					}
					if(nx == persons.get(1).x && ny == persons.get(1).y) {
						p2.add(node.set);
					}
					distance[nx][ny].addAll(node.set);
					pqueue.add(new Node(new Point(nx, ny), node.count, distance[nx][ny]));
				}
			}
		}
	}

}
