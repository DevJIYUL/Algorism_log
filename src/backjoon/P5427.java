package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5427 {
	static char[][] graph;
	static int n,m;
	static Queue<int[]> fire,sang;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.valueOf(st.nextToken());
		for (int t= 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			graph = new char[m][n];
			fire = new LinkedList<int[]>();
			sang = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				String input = br.readLine();
				for (int j = 0; j < n; j++) {
					graph[i][j] = input.charAt(j);
					if(graph[i][j] == '*')fire.add(new int[] {i,j});
					else if(graph[i][j] == '@')sang.add(new int[] {i,j});
				}
			}
			int time = 1;
			boolean flag = false;
			while (true) {
				fire();
				if(move()) {
					flag = true;
					break;
				}
				time++;
				if(sang.size()==0)break;
//				System.out.println("-----------");
//				for (int i = 0; i < m; i++) {
//					System.out.println(Arrays.toString(graph[i]));
//				}
			}
			System.out.println(flag?time:"IMPOSSIBLE");
		}
	}
	private static boolean move() {
		int size = sang.size();
		for (int i = 0; i < size; i++) {
			int[] temp = sang.poll();
			for (int j = 0; j < 4; j++) {
				int nx = temp[0]+dx[j];
				int ny = temp[1]+dy[j];
				if(nx<0||ny<0||nx>=m||ny>=n)return true;
				if(graph[nx][ny] == '#'||graph[nx][ny] == '*')continue;
				if(graph[nx][ny] == '.') {
					graph[nx][ny] = '@';
					sang.add(new int[] {nx,ny});
				}
			}
		}
		return false;
	}
	private static void fire() {
		int s = fire.size();
		for (int i = 0; i < s; i++) {
			int[] temp = fire.poll();
			for (int j = 0; j < 4; j++) {
				int nx = temp[0]+dx[j];
				int ny = temp[1]+dy[j];
				if(nx<0||ny<0||nx>=m||ny>=n)continue;
				if(graph[nx][ny] == '#')continue;
				if(graph[nx][ny] == '.') {
					graph[nx][ny] = '*';
					fire.add(new int[] {nx,ny});
					
				}
			}
		}
	}

}
