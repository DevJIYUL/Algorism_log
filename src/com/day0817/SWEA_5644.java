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
			System.out.println(Arrays.toString(userA));
			System.out.println(Arrays.toString(userB));
			// graph info
			for (int i = 0; i < A.length; i++) {
				int x =A[i][0];
				int y =A[i][1];
				visited[y-1][x-1] = i+1;
				graph[y-1][x-1] |= (1<<(i+1));
				bfs(i+1,y-1,x-1,y-1,x-1,A[i][2]);
			}
			
			for (int[] string : graph) {
				System.out.println(Arrays.toString(string));
			}
			
			int ax=0,ay=0,bx = 9,by=9;
			ArrayList<Integer> arrlst;
			ArrayList<Integer> brrlst;
			arrlst = new ArrayList<>();
			brrlst = new ArrayList<>();
			int maxValue = 0;
//			if (graph[ax][ay] !=0) {
//				for (int j = 1; j < A.length+1; j++) {
//					if ((graph[ax][ay] & (1<<j))!=0) {
//						arrlst.add(j);
//					}
//				}
//				if(arrlst.size()>1) {
//				}else {
//					scoreA[0] = A[arrlst.get(0)-1][3];
//				}
//				
//			}else {
//				scoreA[0] = 0;
//			}
//			if (graph[bx][by] !=0) {
////				System.out.println("거리 :"+d+"bx:"+bx+" by"+by+" ");
//				for (int j = 1; j < A.length+1; j++) {
//					if ((graph[bx][by] & (1<<j))!=0) {
//						brrlst.add(j);
//					}
//				}
//				if(brrlst.size()>1) {
//				}else {
//					scoreB[0] = A[brrlst.get(0)-1][3];
//				}
//
//			}else {
//				scoreB[0] = 0;
//			}
//
//			
//			if (arrlst.size()>1) {
//				for (int j = 0; j < arrlst.size(); j++) {
//					for (int j2 = 0; j2 < brrlst.size(); j2++) {
//						if (arrlst.get(j)==brrlst.get(j2)) {
//							maxValue = Math.max(maxValue, A[arrlst.get(j)-1][3]/2);
//						}else {
//							maxValue = Math.max(maxValue, A[arrlst.get(j)-1][3]);
//						}
//						
//					}
//				}
//				scoreA[0] = maxValue;
//			}
//			maxValue = 0;
//			if (brrlst.size()>1) {
//				for (int j = 0; j < brrlst.size(); j++) {
//					for (int j2 = 0; j2 < arrlst.size(); j2++) {
//						if (brrlst.get(j)==arrlst.get(j2)) {
//							maxValue = Math.max(maxValue, A[brrlst.get(j)-1][3]/2);
//						}else {
//							maxValue = Math.max(maxValue, A[brrlst.get(j)-1][3]);
//							System.out.println(arrlst.get(j2)+" "+maxValue);
//						}
//
//					}
//				}
//				scoreB[0] = maxValue;
//			}
		
			for (int d = 0; d < userA.length; d++) {
				arrlst = new ArrayList<>();
				brrlst = new ArrayList<>();
				int i = userA[d];
				ax = ax + dx[i];
				ay = ay + dy[i];
				i = userB[d];
				bx = bx +dx[i];
				by = by + dy[i];
				maxValue = 0;
				if (graph[ax][ay] !=0) {
					for (int j = 1; j < A.length+1; j++) {
						if ((graph[ax][ay] & (1<<j))!=0) {
							arrlst.add(j);
						}
					}
					if(arrlst.size()>1) {
					}else {
						System.out.println(arrlst.get(0));
						scoreA[d] = A[arrlst.get(0)-1][3];
						System.out.println("d : "+d+" "+ax+" "+ay+" "+Arrays.toString(scoreA));
					}
					
				}else {
					scoreA[d] = 0;
				}
				if (graph[bx][by] !=0) {
//					System.out.println("거리 :"+d+"bx:"+bx+" by"+by+" ");
					for (int j = 1; j < A.length+1; j++) {
						if ((graph[bx][by] & (1<<j))!=0) {
							brrlst.add(j);
						}
					}
					if(brrlst.size()>1) {
					}else {
						scoreB[d] = A[brrlst.get(0)-1][3];
					}

				}else {
					scoreB[d] = 0;
				}
//				for (int j = 0; j < arrlst.size(); j++) {
//					System.out.print(arrlst.get(j)+" ");
//				}
//				System.out.println();
//				for (int j = 0; j < brrlst.size(); j++) {
//					System.out.print(brrlst.get(j)+" ");
//				}
//				System.out.println();

				if (arrlst.size()>1 && brrlst.size()>1) {
					if (arrlst.size()>brrlst.size()) {
						result += dou(arrlst,brrlst,d+1);
					}else {
						result += dou(brrlst,arrlst,d+1);
					}
					System.out.println("d :"+d+" ax :"+ax+"ay :"+ay+" bx :"+bx+" by :"+by);
					continue;
				}
				maxValue = 0;
				if (arrlst.size()>1 && brrlst.size() == 1) {
					for (int j = 0; j < arrlst.size(); j++) {
						for (int j2 = 0; j2 < brrlst.size(); j2++) {
							if (arrlst.get(j)==brrlst.get(j2)) {
								maxValue = Math.max(maxValue, A[arrlst.get(j)-1][3]/2);
							}else {
								maxValue = Math.max(maxValue, A[arrlst.get(j)-1][3]);
							}
							
						}
					}
					scoreA[d] = maxValue;
				}
				maxValue = 0;
				if (brrlst.size()>1 && arrlst.size() == 1) {
					for (int j = 0; j < brrlst.size(); j++) {
						for (int j2 = 0; j2 < arrlst.size(); j2++) {
							if (brrlst.get(j)==arrlst.get(j2)) {
								maxValue = Math.max(maxValue, A[brrlst.get(j)-1][3]/2);
							}else {
								maxValue = Math.max(maxValue, A[brrlst.get(j)-1][3]);
//								System.out.println(arrlst.get(j2)+" "+maxValue);
							}

						}
					}
					scoreB[d] = maxValue;
				}
			}
			
			for (int i = 0; i < scoreA.length; i++) {
				result+= scoreA[i];
				result+= scoreB[i];
			}
			System.out.println("#"+test+" "+result);
			System.out.println(Arrays.toString(scoreA));
			System.out.println(Arrays.toString(scoreB));
			
		}
		
		
	}
	private static int dou(ArrayList<Integer> big, ArrayList<Integer> small, int i) {
		int maxV = 0;
		for (int j = 0; j < big.size(); j++) {
			for (int j2 = 0; j2 < small.size(); j2++) {
				if (big.get(j)==small.get(j2)) {
					maxV = Math.max(maxV, A[big.get(j)-1][3]);
//					int t = A[big.get(j)-1][3]/2+A[small.get(j2)-1][3]/2;
//					maxV = Math.max(maxV, t);
				}else {
					int t = A[big.get(j)-1][3]+A[small.get(j2)-1][3];
					maxV = Math.max(maxV, t);
				}
			}
		}
		return maxV;
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
