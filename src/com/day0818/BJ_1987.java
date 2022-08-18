package com.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1987 {
	static int n,m,answer;
	static char[][] graph;
	static ArrayList<Character> data;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new char[n][m];
		answer = 0;
		data = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		data.add(graph[0][0]);
		dfs(0,0,data);
		System.out.println(answer);
	}
	private static void dfs(int x, int y, ArrayList<Character> data2) {
//		System.out.println(x+" "+y);
//		System.out.print("지금까지 들린 알파벳");
//		for (int i = 0; i < data2.size(); i++) {
//			System.out.print(data2.get(i)+" ");
//		}
//		System.out.println();
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y +dy[i];
			if (0>nx|| nx>=n || 0 > ny || ny >=m) {
				continue;
			}
			if (data.contains(graph[nx][ny])) {
				answer = Math.max(answer, data2.size());
				continue ;
			}
			data2.add(graph[nx][ny]);
			dfs(nx,ny,data2);
			data2.remove(data2.size()-1);
		}
		
	}

}
