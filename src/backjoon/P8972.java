package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P8972 {
	static int n,m,answer,dx[]= {0,1,1,1,0,0,0,-1,-1,-1},dy[] = {0,-1,0,1,-1,0,1,-1,0,1};
	static char graph[][],command[];
	static int[] jong;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new char[n][m];
		jong = new int[2];
		int[][] visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j);
				if(graph[i][j] == 'I')jong = new int[] {i,j};
				if(graph[i][j] == 'R')visited[i][j]++;
			}
		}
		String input = br.readLine();
		command = input.toCharArray();
//		System.out.println(Arrays.toString(command));
		boolean flag =false;
		for (int i = 0; i < command.length; i++) {
			if(flag)break;
			ArrayList<int[]> crazy = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					if(graph[j][j2]!='I'&&visited[j][j2] == 1) {
						graph[j][j2] = 'R';
						crazy.add(new int[] {j,j2});
					}
				}
			}
			if(!jongAduinoMove(command[i]-'0')) {
				answer = i+1;
				break;
			}
//			System.out.println("시작");
//			System.out.println("-------- "+command[i]+" ------------");
//			for (int q = 0; q < n; q++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(graph[q][j]);
//				}
//				System.out.println();
//			}
			visited = new int[n][m];
			for (int j = 0; j < crazy.size(); j++) {
				if(flag) break;
				int x = crazy.get(j)[0];
				int y = crazy.get(j)[1];
				PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
				for (int k = 1; k <= 9; k++) {
					int nx = x+dx[k];
					int ny = y+dy[k];
//					System.out.println(nx+" "+ny);
					if(nx<0||ny<0||nx>=n||ny>=m)continue;
					int d= Math.abs(jong[0]-nx)+Math.abs(jong[1]-ny);
					pqueue.add(new int[] {d,nx,ny});
					graph[x][y] ='.';
				}
				int[] temp = pqueue.poll();
				int nx = temp[1];
				int ny = temp[2];
				if(graph[nx][ny] == 'R'||graph[nx][ny]=='.') {
					visited[nx][ny]++;
				}else if(graph[nx][ny] == 'I') {
					answer = i+1;
					flag = true;
				}
			}
//			for (int j = 0; j < visited.length; j++) {
//				System.out.println(Arrays.toString(visited[j]));
//			}
//			System.out.println("-------- "+i+" ------------");
//			for (int q = 0; q < n; q++) {
//				for (int j = 0; j < m; j++) {
//					if(visited[q][j]==1)System.out.print('R');
//					else System.out.print(graph[q][j]);
//				}
//				System.out.println();
//			}
		}
		if(answer == 0) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					if(visited[j][j2] == 1)graph[j][j2] = 'R';
				}
			}
			for (int q = 0; q < n; q++) {
				for (int j = 0; j < m; j++) {
					System.out.print(graph[q][j]);
				}
				System.out.println();
			}
		}else {
			System.out.println("kraj "+answer);
		}
	}
	private static boolean jongAduinoMove(int i) {
		int x = jong[0];
		int y = jong[1];
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(graph[nx][ny] == 'R') {
//			System.out.println("i r만남");
			return false;
		}
		else {
			graph[x][y] = '.';
			graph[nx][ny] = 'I';
			jong = new int[] {nx,ny};
			return true;
		}
	}

}
