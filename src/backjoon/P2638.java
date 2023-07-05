package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P2638 {
	static int n,m,result;
	static int[][] graph;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static ArrayList<int[]> cheese = new ArrayList<>(), eli = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				if(graph[i][j] == 1)cheese.add(new int[] {i,j});
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println(i + " "+ j);
				if(i == 0 || i == n-1) {
					if(graph[i][j] != 1) makebg(i, j);
				}
				else if(j == 0 || j == m-1) {
					if(graph[i][j] != 1) makebg(i, j);
				}
				
				
				
				
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		while (!check(graph)) {
			result++;
			for (int i = 0; i < cheese.size(); i++) {
				System.out.print(Arrays.toString(cheese.get(i))+" ");
			}
			System.out.println();
			for (int i = 0; i < cheese.size(); i++) {
				int[] temp = cheese.get(i);
				System.out.println("temp : "+Arrays.toString(temp));
				int count = 0;
				for (int j = 0; j < 4; j++) {
					int nx = temp[0] +dx[j];
					int ny = temp[1]+dy[j];
					if(nx<0||ny<0||nx>=n|ny>=m)continue;
					if(graph[nx][ny] == -1)count++;
				}
				System.out.println("count : "+count);
				if(count <= 1) {					
					System.out.println(Arrays.toString(temp)+" 이거 엘리 추가");
					eli.add(temp);
				}
			}
			for (int i = 0; i < eli.size(); i++) {
				System.out.print(Arrays.toString(eli.get(i))+" ");
			}
			System.out.println();
			for (int i = 0; i < cheese.size(); i++) {
				graph[cheese.get(i)[0]][cheese.get(i)[1]] = -1;
			}
			for (int i = 0; i < eli.size(); i++) {
				graph[eli.get(i)[0]][eli.get(i)[1]] = 1;
			}
			cheese.clear();
			for (int i = 0; i < eli.size(); i++) {
				cheese.add(eli.get(i));
			}
			eli.clear();
			makebg(0, 0);
			System.out.println("-------------------------------");
			for (int i = 0; i < n; i++) {
				System.out.println(Arrays.toString(graph[i]));
			}
		}
		System.out.println(result);
	}
	private static void makebg(int a,int b) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {a,b});
		boolean[][] visited = new boolean[n][m];
		visited[a][b] = true;
		graph[a][b] = -1;
		while (!queue.isEmpty()) {
			int[] temp= queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx<0||ny<0||nx>=n|ny>=m||visited[nx][ny])continue;
//				if(graph[nx][ny] != 1 || graph[nx][ny] != -1)continue;
				if(graph[nx][ny] != 1) {
					queue.add(new int[] { nx,ny});
					graph[nx][ny] = -1;
					visited[nx][ny] = true;
				}
			}
		}
	}
	private static boolean check(int[][] graph2) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph2[i][j] == 1) {
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		return flag;
	}

}
