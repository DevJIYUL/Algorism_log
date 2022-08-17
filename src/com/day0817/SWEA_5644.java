package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static int test_case,m,a,result;
	static int[] scoreA,scoreB,userA,userB,dx = {0,-1,0,1,0},dy = {0,0,1,0,-1};
	static int[][] A;
	static int[][] graph;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= test_case; test++) {
			st = new StringTokenizer(br.readLine().trim());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			userA = new int[m];
			userB = new int[m];
			graph = new int[10][10];
			visited = new int[10][10];
			scoreA = new int[m+1];
			scoreB = new int[m+1];
			result = 0;
			for (int i = 0; i < 10; i++) {
				Arrays.fill(graph[i], 0);
			}
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
			A = new int[a][4];
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 4; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.toString(userA));
//			System.out.println(Arrays.toString(userB));
			// graph info
			for (int i = 0; i < A.length; i++) {
				int x =A[i][0];
				int y =A[i][1];
				visited[y-1][x-1] = i+1;
				graph[y-1][x-1] |= (1<<(i+1));
				bfs(i+1,y-1,x-1,y-1,x-1,A[i][2]);
			}
			
//			for (int[] string : graph) {
//				System.out.println(Arrays.toString(string));
//			}
			
			int ax=0,ay=0,bx = 9,by=9;
			// 제자리
			cal(ax,ay,bx,by,0);
			walk(ax,ay,bx,by,0);
			System.out.println("#"+test+" "+result);
			
		
		}
	}
	private static void walk(int ax, int ay, int bx, int by, int count) {
		while(true) {
			if (count == m) {
				return;
			}
			ax = ax + dx[userA[count]];
			ay = ay + dy[userA[count]];
			bx = bx + dx[userB[count]];
			by = by + dy[userB[count]];
//			System.out.println(graph[ax][ay]+" "+graph[bx][by]);
			cal(ax,ay,bx,by,count++);
		}
		
	}
	private static void cal(int ax, int ay, int bx, int by,int cnt) {
		boolean[][] isOn = new boolean[2][a];
		
//		System.out.println("d : "+cnt+" "+graph[ax][ay]+" "+graph[bx][by]);
		for (int i = 0; i < isOn[0].length; i++) {
			if ((graph[ax][ay] & (1<<i+1)) != 0) {
				isOn[0][i] = true;
			}
			if ((graph[bx][by] &(1<<i+1)) != 0) {
				isOn[1][i] = true;
			}
		}
//		for (int i = 0; i < isOn.length; i++) {
//			for (int j = 0; j < isOn[i].length; j++) {
//				System.out.print(isOn[i][j]+" ");
//			}
//			System.out.println();
//		}
		int value = 0;
		for (int i = 0; i < isOn[0].length; i++) {
			for (int j = 0; j < isOn[1].length; j++) {
				if(isOn[0][i] && isOn[1][j]) {
					if (i == j) {
						value = Math.max(value, A[i][3]);
					}else {
						value = Math.max(value, A[i][3]+A[j][3]);
					}
				}else if (isOn[0][i]) {
					value = Math.max(value, A[i][3]);
				}else if (isOn[1][j]) {
					value = Math.max(value, A[j][3]);
				}
			}
		}
//		System.out.println("value : "+value);
		result += value;
		
	}

	static void bfs(int num,int setX,int setY,int x,int y,int count) {
		if (Math.abs(x-setX)+Math.abs(y-setY)>=count) {
//			System.out.println("over");
			return;
		}
		for (int i = 1; i < 5; i++) {
			int nx = x + dx[i];
			int ny = y +dy[i];
			if (0>nx || 10<=nx || 0 >ny || 10<=ny) {
				continue;
			}
			if (visited[nx][ny] == num) {
				continue;
			}
			if (graph[nx][ny] == 0) {
				graph[nx][ny] = 1 << num;
			}
			else {
				graph[nx][ny] |= (1<<num);
				
			}
			visited[nx][ny]= num;
			bfs(num,setX,setY,nx,ny,count);
		}
	}
}
