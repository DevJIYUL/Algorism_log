package com.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집
public class BJ_3109 {
	static int n,c,result;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new char[n][c];
		visited= new boolean[n][c];
		result = 0;
		// 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		//0,0에서 1,0 2,0 3,0이렇게 시작하게
		for (int i = 0; i < n; i++) {
			visited[i][0] = true;
			flag = false;
			getPipe(i,0);
		}
		System.out.println(result);
	}
	//여기사 재귀 함수인데
	private static void getPipe(int x, int y) {
		//여기 플래그 있습니다 이플래그는 재귀 스택 날려주는거구요
		if (flag) {
			return;
		}
		//오른쪽 대각선 오른쪽 오른쪽 아래 3방향
		for (int i = 0; i < 3; i++) {
			// 진행해주고
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx<0||nx>=n||ny<0||ny>=c||(graph[nx][ny] == 'x')||visited[nx][ny]) {
				continue;
			}
			visited[nx][ny] = true;
			// 마지막에 도착했는 지 확인
			if(ny == c-1) {
				// 
				result++;
				flag = true;
				return;
			}else {
				//여기는 정답이 나왔을때 나머지 포문에 대해서 계산해주는거입니다 ㅜㅜ
				if (flag) {
					visited[nx][ny] =false;
					return;
				}
				getPipe(nx, ny);
			}
		}
	}

}
