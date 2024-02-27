package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15653 {
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
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
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
	}
	static class Node{
		Point red,blue;
		char[][] graph;
		int count,prevD;
		public Node(Point red, Point blue, char[][] graph, int count,int prevD) {
			this.red =red ;
			this.blue = blue;
			this.graph = graph;
			this.count = count;
			this.prevD = prevD;
		}
	}
	static int n,m;
	static char[][] graph;
	static Point blue,red;
	static ArrayList<Point[]> visited;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j);
				if(graph[i][j] == 'R')red = new Point(i, j);
				else if (graph[i][j] == 'B') blue = new Point(i, j);
			}
		}
		visited = new ArrayList<>();
//		System.out.println(new Point(1, 2).equals(new Point(1, 2)));
		int result = simul();
		System.out.println(result);
	}
	private static int simul() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(red, blue, graph, 0,-1));
		visited.add(new Point[] {red,blue});
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
//			if(temp.count >6)break;
			for (int i = 0; i < 4; i++) {
				if(temp.prevD == 0 && i==2)continue;
				if(temp.prevD == 1 && i==3)continue;
				if(temp.prevD == 2 && i==0)continue;
				if(temp.prevD == 3 && i==1)continue;
				Node chaged = graphMove(i,temp);
				if(chaged.red.equals(chaged.blue))continue;
				if(chaged.graph[chaged.red.x][chaged.red.y] == 'O')return chaged.count;
				boolean flag = false;
				for (int j = 0; j < visited.size(); j++) {
					if(visited.get(j)[0].equals(chaged.red)&&visited.get(j)[1].equals(chaged.blue)) {
//						System.out.println("중복된 데이터");
						flag = true;
						break;
					}
				}
				if(flag)continue;
				visited.add(new Point[] {chaged.red,chaged.blue});
				queue.add(chaged);
//				for (int a = 0; a < n; a++) {
//					System.out.println(Arrays.toString(chaged.graph[a]));
//				}
//				System.out.println("--------------------------");
//				System.out.println(chaged.blue +" "+chaged.red+" "+chaged.count);
			}
		}
		return -1;
	}
	private static Node graphMove(int i, Node temp) {
		Point blue =new Point(temp.blue.x, temp.blue.y);
		Point red = new Point(temp.red.x, temp.red.y);
		char[][] g = new char[n][m];
		for (int j = 0; j < n; j++) {
			for (int j2 = 0; j2 < m; j2++) {
				g[j][j2] = temp.graph[j][j2];
			}
		}
		// 동 남 서 북
		if(i == 0) {
			for (int j = 0; j < n; j++) {
				for (int j2 = m-1; j2 >= 0; j2--) {
					if(g[j][j2] == '.'||g[j][j2] == '#'||g[j][j2] == 'O')continue;
					else if(g[j][j2]=='B'||g[j][j2]=='R') {
						for (int k = j2+1; k < m; k++) {
							if((g[j][k] == 'R'&&g[j][k-1] == 'B')||(g[j][k] == 'B'&&g[j][k-1] == 'R')||g[j][k] == '#')break;
							if(g[j][k-1]=='B') {
								blue.x = j;
								blue.y = k;
							}else if(g[j][k-1] == 'R') {
								red.x=j;
								red.y=k;
							}
							if(g[j][k] == 'O') {
								g[j][k-1] = '.';
								break;
							}else {
								g[j][k] = g[j][k-1];
								g[j][k-1] = '.';								
							}
						}
					}
				}
			}
		}else if(i==1) {
			for (int j = n-1; j >= 0; j--) {
				for (int j2 = 0; j2 <m; j2++) {
					if(g[j][j2] == '.'||g[j][j2] == '#'||g[j][j2] == 'O')continue;
					else if(g[j][j2]=='B'||g[j][j2]=='R') {
						for (int k = j+1; k < n; k++) {
							if((g[k][j2] == 'R'&&g[k-1][j2] == 'B')||(g[k][j2] == 'B'&&g[k-1][j2] == 'R')||g[k][j2] == '#')break;
							if(g[k-1][j2]=='B') {
								blue.x = k;
								blue.y = j2;
							}else if(g[k-1][j2] == 'R') {
								red.x=k;
								red.y=j2;
							}
							if(g[k][j2] == 'O') {
								g[k-1][j2] = '.';
								break;
							}
							else if(g[k][j2] == '.'){
								g[k][j2] = g[k-1][j2];
								g[k-1][j2] = '.';								
							}
						}
					}
				}
			}
		}else if(i==2) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 <m; j2++) {
					if(g[j][j2] == '.'||g[j][j2] == '#'||g[j][j2] == 'O')continue;
					else if(g[j][j2]=='B'||g[j][j2]=='R') {
						for (int k = j2-1; k >= 0; k--) {
							if((g[j][k] == 'R'&&g[j][k+1] == 'B')||(g[j][k] == 'B'&&g[j][k+1] == 'R')||g[j][k] == '#')break;
							if(g[j][k+1]=='B') {
								blue.x = j;
								blue.y = k;
							}else if(g[j][k+1] == 'R') {
								red.x=j;
								red.y=k;
							}
							if(g[j][k] == 'O') {
								g[j][k+1] = '.';
								break;
							}
							else if(g[j][k] == '.'){
								g[j][k] = g[j][k+1];
								g[j][k+1] = '.';								
							}
						}
					}
				}
			}
		}else if(i==3) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 <m; j2++) {
					if(g[j][j2] == '.'||g[j][j2] == '#'||g[j][j2] == 'O')continue;
					else if(g[j][j2]=='B'||g[j][j2]=='R') {
						for (int k = j-1; k >= 0; k--) {
							if((g[k][j2] == 'R'&&g[k+1][j2] == 'B')||(g[k][j2] == 'B'&&g[k+1][j2] == 'R')||g[k][j2] == '#')break;
							if(g[k+1][j2]=='B') {
								blue.x = k;
								blue.y = j2;
							}else if(g[k+1][j2] == 'R') {
								red.x=k;
								red.y=j2;
							}
							if(g[k][j2] == 'O') {
								g[k+1][j2] = '.';
								break;
							}
							else if(g[k][j2] == '.'){
								g[k][j2] = g[k+1][j2];
								g[k+1][j2] = '.';								
							}
						}
					}
				}
			}
		}
		
		return new Node(red, blue, g, temp.count+1,i);
	}

}
