package com.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17135 {
	// 조합
	static int[] setGungsu;
	// 구현
	static int n,m,d,result,play;
	static int[][] graph;
	//적위치
	static PriorityQueue<int[]> pq;
	static PriorityQueue<int[]> pq1;
	static PriorityQueue<int[]> pq2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < graph.length; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setGungsu = new int[3];
		combinate(0,0);
		System.out.println(result);
	}
	private static void combinate(int index, int count) {
		if (count == 3) {
			
			result = Math.max(result, attck(setGungsu));
			return;
		}
		for (int i = index; i < m; i++) {
			setGungsu[count] = i;
			combinate(i+1,count+1);
		}
	}
	private static int attck(int[] setGungsu2) {
		play = 0;
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = graph[i][j];
			}
		}
//		for (int i = temp.length-1; i >= 0; i--) {
//			System.out.print(i);
//		}
//		System.out.println(temp.length);
		while (!isClear(temp)) {
			int kill = 0;
			boolean[][] attcked = new boolean[n][m];
			// 가장 가까운 적 3명 찾아서 죽이고 0 하고 count
			// 맨 마지막 부터 탐색
			// 궁수 3명 기준으로 탐색
			pq = new PriorityQueue<>((o1,o2)->{
				return o1[0] != o2[0]?o1[0]-o2[0]:o1[2]-o2[2];
			});
			pq1 = new PriorityQueue<>((o1,o2)->{
				return o1[0] != o2[0]?o1[0]-o2[0]:o1[2]-o2[2];
			});
			pq2 = new PriorityQueue<>((o1,o2)->{
				return o1[0] != o2[0]?o1[0]-o2[0]:o1[2]-o2[2];
			});
			for (int gungsu = 0; gungsu < setGungsu2.length; gungsu++) {
				// 궁수에서 가장 가까운 적의 위치 찾기
				boolean isDone = false;
				for (int i = temp.length-1; i >= 0; i--) {
					for (int j = 0; j < temp[i].length; j++) {
						// 적발견
						if (temp[i][j] == 1) {
							int gungsuX = n;
							int gungsuY = setGungsu2[gungsu];
							if (Math.abs(gungsuX-i)+Math.abs(gungsuY-j) <= d) {
								if (gungsu == 0) {
									pq.add(new int[] {Math.abs(gungsuX-i)+Math.abs(gungsuY-j),i,j});
								}else if (gungsu == 1) {
									pq1.add(new int[] {Math.abs(gungsuX-i)+Math.abs(gungsuY-j),i,j});
								}else if (gungsu == 2) {
									pq2.add(new int[] {Math.abs(gungsuX-i)+Math.abs(gungsuY-j),i,j});
								}
							}
						}
					}
				}
				
			}
			int[] close;
			if (!pq.isEmpty()) {
				close = pq.poll();
				attcked[close[1]][close[2]] = true;
				temp[close[1]][close[2]] = 0;
			}
			if (!pq1.isEmpty()) {
				close = pq1.poll();
				attcked[close[1]][close[2]] = true;
				temp[close[1]][close[2]] = 0;
			}
			if (!pq2.isEmpty()) {
				close = pq2.poll();
				attcked[close[1]][close[2]] = true;
				temp[close[1]][close[2]] = 0;
			}
			int check = 0;
			for (int i = 0; i < attcked.length; i++) {
				for (int j = 0; j < attcked[i].length; j++) {
					if (attcked[i][j]) {
						check++;
					}
				}
			}
			
			
//			HashSet<int[]> check = new HashSet<>();
//			HashMap<int[], Integer> check = new HashMap<>();
//			ArrayList<int[]> check = new ArrayList<>();
//			if (!pq.isEmpty()) {
//				int[] close = pq.poll();
//				if (!check.contains(new int[] {close[1],close[2]})) {
//					check.add(new int[] {close[1],close[2]});
//				}
//				temp[close[1]][close[2]] = 0;
//			}
//			if (!pq1.isEmpty()) {
//				int[] close = pq1.poll();
//				if (!check.contains(new int[] {close[1],close[2]})) {
//					check.add(new int[] {close[1],close[2]});
//				}
//				temp[close[1]][close[2]] = 0;
//			}
//			if (!pq2.isEmpty()) {
//				int[] close = pq2.poll();
//				if (!check.contains(new int[] {close[1],close[2]})) {
//					check.add(new int[] {close[1],close[2]});
//				}
//				temp[close[1]][close[2]] = 0;
//			}
//			for (int i = 0; i < check.size(); i++) {
//				System.out.print(check.get(i)[0]+" "+check.get(i)[1]+"|");
//			}
//			System.out.println();
//			System.out.println(" 사이즈 "+check.size());
			
			
			
			play += check;
			temp = moveEnemy(temp);
		}
		return play; 
		
	}
	private static int[][] moveEnemy(int[][] temp) {
		Arrays.fill(temp[temp.length-1], 0);
		for (int i = temp.length-2; i >= 0; i--) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i+1][j] = temp[i][j];
			}
		}
		Arrays.fill(temp[0], 0);
		return temp;
	}
	// 다죽엿냐
	private static boolean isClear(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

}
