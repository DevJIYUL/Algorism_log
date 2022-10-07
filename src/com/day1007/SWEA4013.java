package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

// 특이한 자석
public class SWEA4013 {
	static class Mag{
		ArrayList<Integer> magnetic;
		public Mag(ArrayList<Integer> magnetic) {
			this.magnetic = magnetic;
		}
	}
	static int t;
	static Mag[] mag;
	static boolean[] states;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		t = Integer.parseInt(st.nextToken());
		for (int i = 1; i < t+1; i++) {
			int result = 0;
			mag = new Mag[4];
			states = new boolean[3];
			st = new StringTokenizer(br.readLine().trim());
			// n 회전 횟수
			int n = Integer.parseInt(st.nextToken());
			// 자석 4 개 상태
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine().trim());
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j2 = 0; j2 < 8; j2++) {
					int state = Integer.parseInt(st.nextToken());
					temp.add(state);
				}
				mag[j] = new Mag(temp);
			}
			// states 배열도 초기화, true : 서로 다른 자석 -> 회전시 반대로 회전
			setState();
			
			// n번 회전한다
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int magnum = Integer.parseInt(st.nextToken())-1;
				int direction = Integer.parseInt(st.nextToken());
				// 해당 자석 돌리고 왼쪽 오른쪽도 돌려지면 돌린다.
				visited = new boolean[4];
				
				turn(magnum,direction);
				setState();
			}
			for (int j = 0; j < 4; j++) {
				if(mag[j].magnetic.get(0) == 1) {
					result+= (1<<j);
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
	private static void turn(int magnum, int direction) {
		visited[magnum] =true;
		// 해당 자석 부터 돌린다
		if(direction == 1) {
			//시계 방향
			// 0번쨰에 맨마지막꺼 넣고 맨 마지막꺼 지워준다
			mag[magnum].magnetic.add(0,mag[magnum].magnetic.get(7));
			mag[magnum].magnetic.remove(8);
		}else {
			// 반시계 방향
			// 맨 마지막에 0번쨰꺼 넣고 0 지워준다.
			mag[magnum].magnetic.add(mag[magnum].magnetic.get(0));
			mag[magnum].magnetic.remove(0);
		}
		// 왼쪽에 돌릴수 있으면 돌리고
		if(magnum - 1 >=0 && states[magnum-1] && !visited[magnum-1]) {
			turn(magnum-1, -direction);
		}
		// 오른쪽 돌릴수 있으면 돌리고
		if(magnum +1 <= 3 && states[magnum] && !visited[magnum+1]) {
			turn(magnum+1, -direction);
		}
	}
	private static void setState() {
		for (int j = 0; j < 3; j++) {
			if(mag[j].magnetic.get(2) == mag[j+1].magnetic.get(6)) {
				states[j] = false;
			}else {
				states[j] = true;
			}
		}
		
	}

}
