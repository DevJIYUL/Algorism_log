package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_15683 {
	static int n,m;
	static ArrayList<int[]> cctv;
	static int[][] temp;
	static int[][] graph;
	static int[][] one = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][][] two = {{{-1,0},{1,0}},{{0,1},{0,-1}}};
	static int[][][] three = {
			{{-1,0},{0,1}},
			{{0,1},{1,0}},
			{{1,0},{0,-1}},
			{{0,-1},{-1,0}}
			};
			
	static int[][][] four = {
			{{-1,0},{0,1},{1,0}},
			{{0,1},{1,0},{0,-1}},
			{{1,0},{0,-1},{-1,0}},
			{{0,-1},{-1,0},{0,1}},
			};

	static int[][] five= 
			{{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[] visited;
	static int[] number;
	static HashMap<Integer, Integer> type;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		type = new HashMap<>();
		type.put(1, 4);
		type.put(2, 2);
		type.put(3, 4);
		type.put(4, 4);
		type.put(5, 1);
		graph = new int[n][m];
		cctv = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] != 0 && graph[i][j] !=6) {
					cctv.add( new int[] {i,j});
				}
			}
		}
		for (int[] string : graph) {
			System.out.println(Arrays.toString(string));
		}
		visited = new boolean[cctv.size()];
		number = new int[cctv.size()];
		// cctv 위치 저장
		
		for (int i = 0; i < cctv.size(); i++) {
			System.out.println(cctv.get(i)[0]+" "+cctv.get(i)[1]);
		}

		permutate(0, cctv.size());
	}
	static void permutate(int count,int n) {
		if (count == n) {
			System.out.println(Arrays.toString(number));
			makeSite(number);
			
			return;
		}

		for(int j = 0, size =type.get(graph[cctv.get(count)[0]][cctv.get(count)[1]]);j <size ;j++) {
			number[count] = j;
//				System.out.println(j);
			permutate(count+1, n);
			
		}

	}
	private static void makeSite(int[] number2) {
		temp = graph.clone() ;
		for (int i = 0; i < number2.length; i++) {
			int[][] tar = find(cctv.get(i),number2[i]);
			// 어느 방향으로 갈지 방향 tar에 저장
			for (int j = 0; j < tar.length; j++) {
				int x = cctv.get(i)[0];
				int y = cctv.get(i)[1];
				while(true) {
					x += tar[j][0];
					y += tar[j][1];
					if (x <0 || x>=n || y <0|| y>=m || temp[x][y] == 6) {
						break;
					}
					temp[x][y] = 7;
				}
			}
		}
		for (int[] is : temp) {
			System.out.println(Arrays.toString(is));
		}
	}
	private static int[][] find(int[] is,int index) {
		switch (graph[is[0]][is[1]]) {
		case 1:
			return one;
		case 2:
			return two[index];
		case 3:
			return three[index];
		case 4:
			return four[index];
		case 5:
			return five;
		}
		return null;
		
	}
}
