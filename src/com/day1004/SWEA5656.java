package com.day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {
	static int t,n,w,h,wall;
	static int[] number;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			graph = new int[h][w];
			number = new int[n];
			wall = Integer.MAX_VALUE;
			for (int j = 0; j < h; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < w; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());

				}
			}
			per(0);
			System.out.println("#"+i+" "+wall);
		}
	}
	private static void per(int count) {
		//		System.out.println(Arrays.toString(number));
		if(count >= n) {
			int[][] temp = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					temp[i][j] = graph[i][j];
				}
			}
			wall = Math.min(wall, drop(number,temp));
			return;
		}
		for (int i = 0; i < w; i++) {
			number[count] = i;
			per(count+1);
		}
	}
	private static int drop(int[] number2, int[][] temp) {
		for (int i : number2) {
			//			System.out.println(i);
			for (int j = 0; j < h; j++) {
				if(temp[j][i] != 0) {
					if(temp[j][i] == 1) {
						temp[j][i] = 0;
					}else {
						distroy(j,i,temp);
						setting(temp);
//						System.out.println("----------------------------------------------");
//						for (int k = 0; k < h; k++) {
//							System.out.println(Arrays.toString(temp[k]));
//						}
					}
					break;
				}
			}
		}
		// 남은벽돌 세어서 리턴

		int count = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if(temp[j][i] >0) count++;
			}
		}
		return count;
	}
	private static void setting(int[][] temp) {
		for (int i = 0; i < w; i++) {
			for (int j = h-1; j > -1; j--) {
				if(temp[j][i] == 0) {
					for (int j2 = j; j2 > -1; j2--) {
						if(temp[j2][i] >= 1) {
							temp[j][i] = temp[j2][i];
							temp[j2][i] = 0;
							break;
						}
					}
				}
			}
		}

	}
	private static void distroy(int i, int j, int[][] temp) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j,temp[i][j]});
		temp[i][j] = 0;
		while (!queue.isEmpty()) {
			int[] c = queue.poll();
			int x = c[0];
			int y = c[1];
			int p = c[2];
			for (int k = 0; k < 4; k++) {
				for (int k2 = 1; k2 < p; k2++) {
					int nx = x + dx[k]*k2;
					int ny = y + dy[k]*k2;
					if(nx<0||ny<0||nx>=h||ny>=w)continue;
					if(temp[nx][ny]== 1) {
						temp[nx][ny] = 0;
					}else if(temp[nx][ny] > 1) {
						queue.add(new int[] {nx,ny,temp[nx][ny]});
						temp[nx][ny] = 0;
					}
				}
			}
		}
	}
}

