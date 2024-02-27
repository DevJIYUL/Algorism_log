package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P19237 {
	static class Shark{
		int id,x,y,d;
		public Shark(int id,int x,int y, int d) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.d=d;
		}
		@Override
		public String toString() {
			return "Shark [id=" + id + ", x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		public void toUp() {
			this.x--;
			this.d = 1;
		}
		public void toDown() {
			this.x++;
			this.d = 2;
		}
		public void toRight() {
			this.y++;
			this.d = 4;
		}
		public void toLeft() {
			this.y--;
			this.d = 3;
		}
	}
	public static class Smell{
		int id,time;
		public Smell(int id,int time) {
			this.id = id;
			this.time = time;
		}
		public void smelling(Shark shark) {
			this.id = shark.id;
			this.time = k;
		}
		public void spendTime() {
			this.time--;
			if(this.time == 0)smellReset();
		}
		public void smellReset() {
			this.id = 0;
			this.time = 0;
		}
	}
	static int n,m,k,count, dx[] = {0,-1,1,0,0},dy[]= {0,0,0,-1,1};
	static Shark[] sharkInfo,sharkNext;
	static Smell[][] smellMap;
	static int[][][] directPrior;
	static boolean[] isDead;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		sharkInfo = new Shark[m+1];
		sharkNext = new Shark[m+1];
		smellMap = new Smell[n][n];
		directPrior = new int[m][4][4];
		isDead = new boolean[m+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int t = Integer.valueOf(st.nextToken());
				if(t == 0)continue;
				sharkInfo[t] = new Shark(t, i, j, 0);
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			sharkInfo[i].d = Integer.valueOf(st.nextToken());
		}
		for (int i = 0; i < m*4; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[] {Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken())};
			directPrior[i/4][i%4] = temp;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				smellMap[i][j] = new Smell(0, 0);
			}
		}
		for (int i = 1; i <= m; i++) {
			smellMap[sharkInfo[i].x][sharkInfo[i].y].smelling(sharkInfo[i]);
		}
		
		while (count < 1000) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(smellMap[i][j].time+" ");
//				}
//				System.out.println();
//			}
			// 상어 별로 우선순위에 따라 sharknext에 저장한다 sharkinfo도 업데이트
			sharkNext = new Shark[m+1];
			for (int i = 1; i <= m; i++) {
				if(isDead[i])continue;
				boolean flag = false;
				int id = sharkInfo[i].id;
				int x = sharkInfo[i].x;
				int y = sharkInfo[i].y;
				int d = sharkInfo[i].d;
				// 아무 냄새가 없는 곳으로
				for (int j = 0; j < 4; j++) {
					int nextD = directPrior[id-1][d-1][j];
					int nx = x+dx[nextD];
					int ny = y+dy[nextD];
					if(nx<0||ny<0||nx>=n||ny>=n)continue;
					if(smellMap[nx][ny].id !=0)continue;
					sharkNext[id] = new Shark(id, nx, ny, nextD);
					sharInfoChanger(nextD,id);
					flag = true;
					break;
				}
				if(flag)continue;
				for (int j = 0; j < 4; j++) {
					int nextD = directPrior[id-1][d-1][j];
					int nx = x+dx[nextD];
					int ny = y+dy[nextD];
					if(nx<0||ny<0||nx>=n||ny>=n)continue;
					if(smellMap[nx][ny].id == id) {
						sharkNext[id] = new Shark(id, nx, ny, nextD);
						sharInfoChanger(nextD,id);
						break;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(smellMap[i][j].id == 0)continue;
					smellMap[i][j].spendTime();
				}
			}
			// smellMap에 sharkNext 적용하기
			for (int i = 1; i <= m; i++) {
				if(isDead[i])continue;
				int x = sharkNext[i].x;
				int y = sharkNext[i].y;
				// 냄새 주인이 없을 떄
				if(smellMap[x][y].id == 0) {
					smellMap[x][y].smelling(sharkNext[i]);
				}
				// 누군가의 냄새 주인이 있을때
				else {
					if(smellMap[x][y].id < sharkNext[i].id) {
						isDead[i] = true;
					}else if(smellMap[x][y].id > sharkNext[i].id) {
						isDead[smellMap[x][y].id] = true;
						smellMap[x][y].smelling(sharkNext[i]);
					}else {
						smellMap[x][y].smelling(sharkNext[i]);
					}
				}
			}
			count++;
//			System.out.println("sharkinfo : "+Arrays.toString(sharkInfo));
//			System.out.println("isDead : "+Arrays.toString(isDead));
//			System.out.println("count : "+count);
			boolean isDone= true;
			for (int i = 2; i <= m; i++) {
				if(!isDead[i]) {
					isDone = false;
					break;
				}
			}
			if(isDone)break;
			// 냄새 빼기

		}
		System.out.println(count==1000?-1:count);
	}
	private static void sharInfoChanger(int nextD, int id) {
		if(nextD == 1)sharkInfo[id].toUp();
		else if(nextD == 2)sharkInfo[id].toDown();
		else if(nextD == 3)sharkInfo[id].toLeft();
		else if(nextD == 4)sharkInfo[id].toRight();
		
	}

}
