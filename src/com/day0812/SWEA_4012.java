package com.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 요리사
public class SWEA_4012 {
	static int n,tS,fS;
	static int[] number;
	static int[][] graph;
	static boolean[] visited,visited_x;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= testcase; i++) {
			n = Integer.parseInt(br.readLine().trim());
			graph = new int[n][n];
			result = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[n];
			
			combi(0,0);
			System.out.println("#"+i+" "+result);
		}
	}
	
	static void combi(int index,int count) {
		if (count == n/2) {
			tS=0;
			fS=0;
			int[] t = new int[visited.length/2];
			int[] f = new int[visited.length/2];
			int tSize = 0;
			int fSize = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					t[tSize++] = i;
				}else {
					f[fSize++] = i;
				}
			}

			visited_x = new boolean[n/2];
			number= new int[2];
			per(0,0,t,true);
			per(0,0,f,false);
			result = Math.min(result, Math.abs(tS-fS));
			return;
		}
		for (int i = index; i < n; i++) {
			visited[i]= true;
			combi(i+1,count+1);
			visited[i]= false;
		}
	}
	static void per(int index,int count,int[] input,boolean flag) {
		if (count == 2) {
			if (flag) {
				tS += graph[number[0]][number[1]]+graph[number[1]][number[0]];
			}else {
				fS += graph[number[0]][number[1]]+graph[number[1]][number[0]];
			}
			return;
		}
		for (int i = index; i < visited_x.length; i++) {
			if (visited_x[i]) {
				continue;
			}
			number[count] = input[i];
			visited_x[i] = true;
			per(i+1, count+1,input,flag);
			visited_x[i] = false;
			
		}
		
	}

}

