package com.CodeBattle;
// 헌터
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2 {
	static class Info{
		int x,y;
		public Info(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+x+" "+y+"]";
		}
		
	}
	static int n,t,size,result;
	static int[][] graph;
	static Info[] monster,customer;
	static Info hunter;
	static int[] permu,number;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			size = -1;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < n; j2++) {
					graph[j][j2] = Integer.parseInt(st.nextToken());
					size = Math.max(size, graph[j][j2]);
				}
			}
			monster = new Info[size+1];
			customer= new Info[size+1];
			hunter = new Info(0, 0);
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(graph[j][j2] > 0) {
						monster[graph[j][j2]] = new Info(j, j2);
					}else if (graph[j][j2] < 0) {
						customer[Math.abs(graph[j][j2])] = new Info(j, j2);
					}
					
				}
			}
			number = new int[size*2];
			for (int j = 1; j <= size; j++) {
				number[j-1] = j;
				number[j-1+size] = -j;
			}
//			System.out.println(Arrays.toString(number));
			visited = new boolean[2*size];
			permu = new int[2*size];
			result = Integer.MAX_VALUE;
			permutate(0);
			System.out.println("#"+i+" "+result);
		}
	}
	private static void permutate(int count) {
		if(count == 2*size) {
//			System.out.println(Arrays.toString(permu));
			if(check(permu)) {
//				System.out.println("pass");
				result = Math.min(result, cal(permu));
//				result = cal(permu);
//				System.out.println("result : "+result);
			}
			return;
		}
		for (int i = 0; i < 2*size; i++) {
			if(visited[i]) continue;
			permu[count] = number[i];
			visited[i] = true;
			permutate(count+1);
			visited[i] = false;
		}
		
	}
	private static int cal(int[] permu2) {
		Info temp;
		int distance = 0;
		for (int i = 0; i < permu2.length; i++) {
			if(permu2[i] > 0) {
				temp = monster[permu2[i]];
			}else {
				temp = customer[-permu2[i]];
			}
//			System.out.print(temp.toString()+" ");
			distance += Math.abs(temp.x-hunter.x)+Math.abs(temp.y-hunter.y);
//			System.out.print(distance+" ");
			hunter.x = temp.x;
			hunter.y = temp.y;
		}
		hunter.x = 0;
		hunter.y = 0;
//		System.out.println();
		return distance;
	}
	private static boolean check(int[] permu2) {
		boolean[] monster = new boolean[size+1];
		boolean[] customer = new boolean[size+1];
		for (int i = 0; i < permu2.length; i++) {
			if(permu2[i] > 0) {
				monster[permu2[i]] = true;
			}else {
				if(!monster[Math.abs(permu2[i])]) return false;
				customer[Math.abs(permu2[i])] = true;
			}
		}
		return true;
	}

}
