package com.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class BJ_17144 {
	static int r,c,t;
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};
	static int[][] graph;
	static ArrayList<int[]> mechine;
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		graph = new int[r][c];
		mechine = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]!=0 && graph[i][j] != -1) {
					queue.add(new int[] {i,j});
				}else if (graph[i][j] == -1) {
					mechine.add(new int[] {i,j});
				}
			}
			System.out.println(Arrays.toString(graph[i]));
		}
//		System.out.println(queue.size());
		// 미세먼지 확산
		
		for (int i = 0; i < t; i++) {
			graph = spread();
			
		}
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(graph[i][j] <= -1)continue;
				sum+= graph[i][j];
			}
//			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println(sum);
		
	}
	private static int[][] spread() {
		int[][] temp = new int[r][c];
//		// 복사
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = graph[i][j];
			}
		}
		Queue<int[]> temp_q = new LinkedList<>();
		while (!queue.isEmpty()) {
			int[] mon = queue.poll();
			int value = graph[mon[0]][mon[1]];
			int count = 0;
			int spreadValue = value/5;
			for (int i = 0; i < 4; i++) {
				int nx = mon[0] + dx[i];
				int ny = mon[1] + dy[i];
				
				if(nx<0||ny<0||nx >= r|| ny>=c||graph[nx][ny] == -1) continue;
				temp[nx][ny] += spreadValue;
				count++;
				temp_q.offer(new int[] {nx,ny});
			}
			temp[mon[0]][mon[1]] = temp[mon[0]][mon[1]]-spreadValue*count;
			
		}
//		queue.offer(temp_q.poll());
		while (!temp_q.isEmpty()) {
			queue.offer(temp_q.poll());
		}
//		temp[mechine.get(0)[0]][mechine.get(0)[1]] = 0;
//		temp[mechine.get(1)[0]][mechine.get(1)[1]] = 0;
		System.out.println("---------------------");
		for (int j = 0; j < r; j++) {
			System.out.println(Arrays.toString(temp[j]));
		}
		for (int i = mechine.get(0)[0]; i >0 ; i--) {
			temp[i][0] = temp[i-1][0];
		}
		for (int i = 0; i < c-1; i++) {
			temp[0][i] = temp[0][i+1];
		}
		for (int i = 0; i < mechine.get(0)[0]; i++) {
			temp[i][c-1] = temp[i+1][c-1];
		}
		for (int i = r; i >0; i--) {
			temp[mechine.get(0)[0]][i] = temp[mechine.get(0)[0]][i-1];
		}
		temp[mechine.get(0)[0]][mechine.get(0)[1]] = -1;
		
		for (int i = mechine.get(1)[0]; i < r-1; i++) {
			temp[i][0] = temp[i+1][0];
		}
		for (int i = 0; i < c-1; i++) {
			temp[r-1][i] = temp[r-1][i+1];
		}
		for (int i = r-1; i > mechine.get(1)[0]; i--) {
			temp[i][c-1] = temp[i-1][c-1];
		}
		for (int i = r; i >0; i--) {
			temp[mechine.get(1)[0]][i] = temp[mechine.get(1)[0]][i-1];
		}
		temp[mechine.get(1)[0]][mechine.get(1)[1]] = -1;
		System.out.println("---------------------");
		for (int j = 0; j < r; j++) {
			System.out.println(Arrays.toString(temp[j]));
		}
		return temp;
		
		
		
	}

}

