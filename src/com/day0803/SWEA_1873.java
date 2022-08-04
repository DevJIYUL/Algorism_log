package com.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 상호의 배틀필드
public class SWEA_1873 {
	static char[][] graph;// field 정보 담음
	static char[] command;// 명령 저장
	static char[] tank = {'^','<','>','v'};// 탱크가 바라보는 방향 (0,북) (1,서) (2,동) (3,남)
	// (0,북) (1,서) (2,동) (3,남)
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int d;// 탱크가 바라보는 방향 (0,북) (1,서) (2,동) (3,남)
	static int x;// 현재 탱크의 x좌표
	static int y;// 현재 탱크의 y좌표
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 0; i < test_case; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph = new char[h][w];
			flag = false;
			for (int j = 0; j < h; j++) {
				String str = br.readLine();
				for (int j2 = 0; j2 < w; j2++) {
					graph[j][j2] = str.charAt(j2);
					if (flag) continue;
					for (int c = 0; c<4;c++) {
						if (graph[j][j2]== tank[c]) {
							x = j;
							y = j2;
							d = c;
							flag = true;
						}
					}
				}
			}
			int command_line = Integer.parseInt(br.readLine());
			command = new char[command_line];
			String str = br.readLine();
			for (int j = 0; j < command_line; j++) {
				command[j] = str.charAt(j);
			}
			// command를 순회하면서 해당 명령을 수행한다.
			for (char c : command) {
				// 커멘드가 S이일때
				if (c == 'S') {
					int nx = x,ny = y;
					// 벽을 만나면 벽을 깨고 평지로 만들고 끝,강철벽을 만나면 끝, 필드를 넘어가도 끝
					while (true) {
						nx = nx +dx[d];
						ny = ny +dy[d];
						if (nx<0 || nx >= h || ny < 0 || ny >= w) break;
						if (graph[nx][ny] == '*') {
							graph[nx][ny] = '.';
							break;
						}
						if (graph[nx][ny] == '#') {
							break;
						}
					}
				}else {
					// 탱크의 방향을 설정
					if (c == 'R') {
						d = 2;
					}else if (c == 'L') {
						d = 1;
					}else if (c == 'U') {
						d = 0;
					}else if (c == 'D') {
						d = 3;
					}
					// 탱크 방향 바꾸고
					graph[x][y] = tank[d];
					// 탱크가 보는 방향으로 한칸전진할때 필드 밖으로 가면 커멘드를 넘어간다
					if (x+dx[d]<0 || x+dx[d] >= h || y+dy[d] <0 || y+dy[d] >= w) continue;
					// 탱크가 보는 방향으로 한칸 앞이 평지면 전진한다.
					if (graph[x+dx[d]][y+dy[d]] == '.') {
						graph[x][y] = '.';
						graph[x+dx[d]][y+dy[d]] = tank[d];
						x = x+dx[d];
						y = y+dy[d];
					}
				}
			}
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < h; j++) {
				for (int j3 = 0; j3 < w; j3++) {
					System.out.print(graph[j][j3]);
				}
				System.out.println();
			}
		}
	}

}
