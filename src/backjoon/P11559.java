package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P11559 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int result;
	static char[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String input =br.readLine();
			for (int j = 0; j < 6; j++) {
				graph[i][j] = input.charAt(j);
			}
		}

		while(check()) {
			remove();
//			System.out.println("---------------------");
//			for (int i = 0; i < 12; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			drop();
//			System.out.println("---------------------");
//			for (int i = 0; i < 12; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			result++;
		}
		System.out.println(result);
	}
	private static void drop() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j > -1; j--) {
				if(graph[j][i] == '.') {
					for (int j2 = j; j2 > -1; j2--) {
						if(graph[j2][i] != '.') {
							graph[j][i] = graph[j2][i];
							graph[j2][i] = '.';
							break;
						}
					}
				}
			}
		}
	}
	private static void remove() {
		visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(graph[i][j]=='.') {
					visited[i][j] =true;
				}else if(!visited[i][j]){
					ArrayList<int[]> r = find(i,j);
					if(r.size()>=4) {
//						result++;
						for (int[] ks : r) {
							graph[ks[0]][ks[1]] = '.';
						}
					}
				}
			}
		}		
	}
	private static boolean check() {
		visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(graph[i][j]=='.') {
					visited[i][j] =true;
				}else if(!visited[i][j]){
					ArrayList<int[]> r = find(i,j);
					if(r.size()>=4)return true;
				}
			}
		}
		return false;
	}
	private static ArrayList<int[]> find(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = temp[0]+dx[k];
				int ny = temp[1]+dy[k];
				if(nx<0||ny<0||nx>=12||ny>=6||visited[nx][ny])continue;
				if(graph[nx][ny] == graph[temp[0]][temp[1]]) {
					queue.add(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		return list;
	}

}
