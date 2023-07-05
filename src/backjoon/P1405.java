package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 미친 로봇
public class P1405 {
	static int n,E,W,S,N;
	static double[] per;
	static boolean[][] visited;
	static int x;
	static int y;
	static int[] com;
	static double ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		per = new double[] {E*0.01,W*0.01,S*0.01,N*0.01};
		com = new int[n];
		visited = new boolean[30][30];
		visited[15][15] = true;
		cal(0,visited,15,15,1);
		System.out.println(ans);
//		System.out.println(Arrays.toString(per));
	}
	private static void cal(int count, boolean[][] visited,int x,int y,double res) {
		if(count == n) {
			ans += res;
			return;
		}
//		System.out.println("x : "+x +" y : "+y);
//		for (int i = 0; i < visited.length; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		for (int i = 0; i < 4; i++) {
			int nx = x,ny = y;
			if(i==0) {
				ny = y+1;
			}else if(i == 1) {
				ny = y-1;
			}else if(i == 2) {
				nx = x+1;
			}else if(i == 3) {
				nx = x-1;
			}
//			System.out.println(nx+" "+ny);
			if(visited[nx][ny])continue;
			visited[nx][ny] = true;
			cal(count+1,visited,nx,ny,res*per[i]);
			visited[nx][ny] =false;
		}
	}
}
