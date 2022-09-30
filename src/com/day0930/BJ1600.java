package com.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class BJ1600 {
	static int k,w,h;
	static int[][] graph;
	static int[][][] d;
	static int[] mondx = {1,0,-1,0};
	static int[] mondy = {0,-1,0,1};
	static int[] hordx = {-1,-1,-2,-2,1,1,2,2};
	static int[] hordy = {-2,2,-1,1,-2,2,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		graph = new int[h][w];
		d = new int[h][w][k+1];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < w; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				for (int z = 0; z < k; z++) {
					d[i][j][z] = Integer.MAX_VALUE;
				}
			}
		}
		d[0][0][0] = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				for (int z = 0; z < k; z++) {
					if(i==0&&j==0)continue;
					for (int j2 = 0; j2 < 4; j2++) {
						int px = i + mondx[j2];
						int py = j + mondy[j2];
						if(px<0||py<0||px>=h||py>=w) continue;
						d[i][j][z] = Math.min(d[i][j][z], d[px][py][z]);
					}
					for (int j3 = 0; j3 < 8; j3++) {
						int px = i + hordx[j3];
						int py = j + hordy[j3];
						if(px<0||py<0||px>=h||py>=w) continue;
						d[i][j][z+1] = Math.min(d[i][j][z+1], d[px][py][z-1]);
					}
				}
			}
		}
	
	}
}