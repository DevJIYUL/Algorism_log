package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P9376 {
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
		public Node(Point point, int count) {
			super();
			this.point = point;
			this.count = count;
		}
	}

	static int test,n,m,result;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static char[][] graph;
	static int[][] distanceA,distanceB,distanceC;
	static boolean[][] visited;
	static ArrayList<Point> persons;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		test = Integer.valueOf(st.nextToken());
		for (int i = 0; i < test; i++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			persons = new ArrayList<>();
			graph = new char[n+2][m+2];
			distanceA = new int[n+2][m+2];
			distanceB = new int[n+2][m+2];
			distanceC = new int[n+2][m+2];
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
			visited = new boolean[n+2][m+2];
			dfs(persons.get(0),distanceA);
			visited = new boolean[n+2][m+2];
			dfs(persons.get(1),distanceB);
			visited = new boolean[n+2][m+2];
			dfs(new Point(0, 0),distanceC);
//			for (int j = 0; j < n+2; j++) {
//				System.out.println(Arrays.toString(graph[j]));
//			}
//			System.out.println("-----------------");
//			for (int j = 0; j < n+2; j++) {
//				System.out.println(Arrays.toString(distanceA[j]));
//			}
//			System.out.println("-----------------");
//			for (int j = 0; j < n+2; j++) {
//				System.out.println(Arrays.toString(distanceB[j]));
//			}
//			System.out.println("-----------------");
//			for (int j = 0; j < n+2; j++) {
//				System.out.println(Arrays.toString(distanceC[j]));
//			}
//			System.out.println("---------------------------");
			
			for (int j = 0; j < distanceA.length; j++) {
				for (int j2 = 0; j2 < distanceA[j].length; j2++) {
					if(graph[j][j2] == '*'||!visited[j][j2])continue;
					distanceC[j][j2]+=(distanceA[j][j2]+distanceB[j][j2]);
					//if(distanceC[j][j2] == 0)continue;
					if(graph[j][j2] == '#') distanceC[j][j2]+= -2;
					result = Math.min(result, distanceC[j][j2]);
				}
			}
//			for (int j = 0; j < n+2; j++) {
//				System.out.println(Arrays.toString(distanceC[j]));
//			}
//			System.out.println("---------------------------");
			System.out.println(result);
		}

	}
	private static void dfs(Point point, int[][] distance) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o1.count-o2.count);
		
		pqueue.add(new Node(point, 0));
		visited[point.x][point.y]= true;
		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.point.x+dx[i];
				int ny = node.point.y+dy[i];
				if(nx<0||ny<0||nx>=n+2||ny>=m+2||visited[nx][ny]||graph[nx][ny] == '*')continue;
				visited[nx][ny] = true;
				if(graph[nx][ny] == '#') {
					distance[nx][ny] = node.count+1;
					pqueue.add(new Node(new Point(nx, ny), node.count+1));
				}else {
					distance[nx][ny] = node.count;
					pqueue.add(new Node(new Point(nx, ny), node.count));
				}
			}
		}
		
	}
	
	
}
