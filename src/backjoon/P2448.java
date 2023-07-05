package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2448 {
	static int n;
	static char[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		graph = new char[n][(2*n)-1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = ' ';
			}
		}
		recur(0,n-1,n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(graph[i]));
			for (int j = 0; j < graph[i].length; j++) {
				sb.append(graph[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void recur(int a, int b, int c) {
//		System.out.println("a : "+a +" b : "+b+ "c : "+c);
		if(c == 3) {
			draw(a,b);
			return ;
		}
		int s = c/2;
		recur(a+s, b-s, s);
		recur(a+s, b+s, s);
		recur(a, b, s);
	}
	private static void draw(int a, int b) {
		graph[a][b] = '*';
		graph[a+1][b-1] = '*';
		graph[a+1][b+1] = '*';
		graph[a+2][b-2] = '*';
		graph[a+2][b-1] = '*';
		graph[a+2][b] = '*';
		graph[a+2][b+1] = '*';
		graph[a+2][b+2] = '*';
		
		
	}

}
