package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1035 {
//	static char[][] graph;
	final static int N = 5;
	static ArrayList<int[]> crum = new ArrayList<>();
	static boolean[][] visited;
	static int answer = 25;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				if(input.charAt(j) == '*') crum.add(new int[] {i,j});
			}
		}
		visited = new boolean[N][N];
		bf(0,0);
		System.out.println(answer);
	}
	public static void bf(int index, int distance) {
		if(distance>=answer)return;
		if(index == crum.size()) {
			if(check()) {
				answer = distance;
//				System.out.println(index + " "+distance);
//				for (int i = 0; i < visited.length; i++) {
//					System.out.println(Arrays.toString(visited[i]));
//				}
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j])continue;
				visited[i][j] = true;
				int dist = Math.abs(crum.get(index)[0]-i)+Math.abs(crum.get(index)[1]-j);
				bf(index+1,distance+dist);
				visited[i][j] = false;
			}
		}
	}
	private static boolean check() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int x = 0,y = 0;
		for (int i = 0; i < N; i++) {
			loop :
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) {
					x = i; y = j;
					break loop;
				}
			}
		}
		queue.add(new int[] {x,y});
		int count = 1;
		int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
		boolean[][] v = new boolean[N][N];
		v[x][y]=true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N||v[nx][ny])continue;
				if(!visited[nx][ny])continue;
				v[nx][ny] = true;
				count++;
				queue.add(new int[] {nx,ny});
			}
		}
		return count==crum.size()?true:false;
	}
}
