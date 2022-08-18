package com.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_15683 {
	static int n,m,result;
	static ArrayList<int[]> cctv;
	static int[][] temp;
	static int[][] graph;
	static int[][][] one = {{{-1,0}},{{0,1}},{{1,0}},{{0,-1}}};
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
		result= Integer.MAX_VALUE;
		type = new HashMap<>();
		type.put(1, 4);
		type.put(2, 2);
		type.put(3, 4);
		type.put(4, 4);
		type.put(5, 1);
		graph = new int[n][m];
		temp = new int[n][m];
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
//		for (int[] string : graph) {
//			System.out.println(Arrays.toString(string));
//		}
		visited = new boolean[cctv.size()];
		number = new int[cctv.size()];
		// cctv 위치 저장 확인 코드
		
//		for (int i = 0; i < cctv.size(); i++) {
//			System.out.println(cctv.get(i)[0]+" "+cctv.get(i)[1]);
//		}

		permutate(0, cctv.size());
		System.out.println(result);
	}
	static void permutate(int count,int n) {
		if (count == n) {
			// 어떤 조합이 만들어졌는지 확인 코드
//			System.out.println(Arrays.toString(number));
			makeSite(number);
			
			return;
		}

		for(int j = 0, size =type.get(graph[cctv.get(count)[0]][cctv.get(count)[1]]);j <size ;j++) {
			number[count] = j;
			permutate(count+1, n);
			
		}

	}
	private static void makeSite(int[] number2) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = graph[i][j];
			}
		}
		for (int i = 0; i < number2.length; i++) {
			int[][] tar = find(cctv.get(i),number2[i]);
			// tar에 어떤 값들이 들어오는지 테스트 코드
//			for (int j = 0; j < tar.length; j++) {
//				System.out.println(Arrays.toString(tar[j]));
//			}
			// 어느 방향으로 갈지 방향 tar에 저장
			for (int j = 0; j < tar.length; j++) {
				int x = cctv.get(i)[0];
				int y = cctv.get(i)[1];
				while(true) {
					if (graph[cctv.get(i)[0]][cctv.get(i)[1]] == 1) {
						
						x += tar[j][0];
						y += tar[j][1];
					}
					if (x <0 || x>=n || y <0|| y>=m || temp[x][y] == 6) {
						break;
					}
					temp[x][y] = 7;
				}
			}
		}
		int zero = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] == 0) {
					zero++;
				}
			}
		}
		result = Math.min(result, zero);
		// 각 경우의 수에 대한 방의 사각지대와 최소값 테스트 코드
//		for (int[] is : temp) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println("result :"+zero);
	}
	private static int[][] find(int[] is,int index) {
		switch (graph[is[0]][is[1]]) {
		case 1:
			return one[index];
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
