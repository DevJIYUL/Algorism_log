package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18809 {
	static int n,m,g,r,liqudSize,result;
	static int[][] graph;
	static int[][] select;
	static boolean[][] greenVisited,redVisited;
	static boolean[] visited;
	static int[][] greenMap,redMap;
	static ArrayList<int[]> liqud;
	static Queue<int[]> green,red;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		g = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		liqud = new ArrayList<>();
		graph = new int[n][m];
		select = new int[g+r][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				if(graph[i][j] == 2)liqud.add(new int[] {i,j});
			}
		}
		liqudSize = liqud.size();
		visited= new boolean[liqudSize];
		com(0,0);
		System.out.println(result);
	}
	public static void com(int index, int count) {
		if(count == g+r) {
			int[][] temp = new int[n][m];
			green = new LinkedList<>();
			red = new LinkedList<>();
			greenVisited = new boolean[n][m];
			redVisited = new boolean[n][m];
			greenMap = new int[n][m];
			redMap = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][j] = graph[i][j];
					if(temp[i][j] == 3) {
						green.add(new int[] {i,j});
						greenVisited[i][j] = true;
					}else if(temp[i][j] == 4) {
						red.add(new int[] {i,j});
						redVisited[i][j] = true;
					}
				}
			}
			
			
//			for (int i = 0; i < g; i++) {
//				temp[select[i][0]][select[i][1]] = 5;
//				green.add(select[i]);
//				v[select[i][0]][select[i][1]] = true;
//			}
//			for (int i = g; i < g+r; i++) {
//				temp[select[i][0]][select[i][1]] = -5;
//				red.add(select[i]);
//				v[select[i][0]][select[i][1]] = true;
//			}
//			System.out.println("---------- 시작 ------------");
//			for (int i = 0; i < temp.length; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
//			System.out.println("green : "+green);
//			System.out.println("red : "+red);
			int c = 0;
			int check = 0;
			while (!green.isEmpty() && !red.isEmpty()) {
				int gSize = green.size();
				for (int i = 0; i < gSize; i++) {
					int[] t = green.poll();
					
					if(temp[t[0]][t[1]] == 7)continue;
					for (int j = 0; j < 4; j++) {
						int nx = t[0]+dx[j];
						int ny = t[1]+dy[j];
						if(nx<0||ny<0||nx>=n||ny>=m||greenVisited[nx][ny]||temp[nx][ny]==0)continue;
//						v[nx][ny] = true;
						if(temp[nx][ny] == 1||temp[nx][ny] == 2) {
//							temp[nx][ny] = 5;
							greenMap[nx][ny] = greenMap[t[0]][t[1]]+1;
							green.add(new int[] {nx,ny});
							greenVisited[nx][ny] = true;
						}
					}
				}

				int rSize = red.size();
				for (int i = 0; i < rSize; i++) {
					int[] t = red.poll();
					if(temp[t[0]][t[1]] == 7)continue;
					for (int j = 0; j < 4; j++) {
						int nx = t[0]+dx[j];
						int ny = t[1]+dy[j];
						if(nx<0||ny<0||nx>=n||ny>=m||temp[nx][ny] == 0||redVisited[nx][ny])continue;
						if(temp[nx][ny] == 1||temp[nx][ny] == 2) {
							redVisited[nx][ny] = true;
							redMap[nx][ny] = redMap[t[0]][t[1]]+1;
							if(redMap[nx][ny] == greenMap[nx][ny]) {
								c++;
								temp[nx][ny] = 7;
							}else {
								red.add(new int[] {nx,ny});								
							}
						}
					}
				}

				
			}
//			System.out.println("---------- 결과 ------------");
//			for (int i = 0; i < temp.length; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			result = Math.max(result, c);
//			System.out.println("c : "+c);
			return;
		}
		for (int i = 0; i < liqudSize; i++) {

		}
	}



}