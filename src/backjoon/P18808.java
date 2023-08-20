package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18808 {
	static int n,m,k,cnt;
	static int[][] graph;
	static ArrayList<int[][]> sticker;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		graph = new int[n][m];
		sticker = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int[][] s = new int[a][b];
			for (int j = 0; j < a; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < b; j2++) {
					s[j][j2] = Integer.valueOf(st.nextToken());
				}
			}
			sticker.add(s);
		}
		for (int i = 0; i < sticker.size(); i++) {
			int[][] temp = sticker.get(i);
			loop : for (int w = 0; w < 4; w++) {

				for (int j = 0; j < n-temp.length+1; j++) {
					for (int j2 = 0; j2 < m-temp[0].length+1; j2++) {
						if(check(j,j2,temp)) {
							draw(j,j2,temp);
							break loop;
						}
					}
				}
				temp = turn(temp);
			}
		}
		int s = 0;
		for (int j = 0; j < n; j++) {
			for (int j2 = 0; j2 < m; j2++) {
				if(graph[j][j2] == 1)s++;
			}
		}

		System.out.println(s);
	}
	private static int[][] turn(int[][] temp) {
		int[][] turn = new int[temp[0].length][temp.length];
		// 90도회전
		for (int j2 = 0; j2 < temp[0].length; j2++) {
			for (int k = 0; k < temp.length; k++) {
				turn[j2][k] = temp[temp.length-1-k][j2]; 
				
			}
		}
		return turn;
//		temp = new int[turn.length][turn[0].length];
//		for (int j2 = 0; j2 < temp.length; j2++) {
//			for (int k = 0; k < temp[0].length; k++) {
//				temp[j2][k] = turn[j2][k]; 
//			}
//		}		
	}
	private static void draw(int a, int b, int[][] temp) {
		for (int l = 0; l < temp.length; l++) {
			for (int l2 = 0; l2 < temp[0].length; l2++) {
//				System.out.println(graph[a+l][b+l2]+" "+temp[l][l2]);
				graph[a+l][b+l2] += temp[l][l2];
			}
		}		

	}
	private static boolean check(int j, int j2, int[][] temp) {
		for (int k2 = 0; k2 < temp.length; k2++) {
			for (int l = 0; l < temp[0].length; l++) {

				if(graph[j+k2][j2+l]+temp[k2][l] == 2) {
					return false;
				}
			}
		}		
		return true;
	}

}
