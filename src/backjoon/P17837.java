package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17837 {
	static class Chess{
		int id,x,y,d;
		public Chess(int id,int x, int y, int d) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.d = d;
		}
		public void right() {
			this.y++;
		}
		public void left() {
			this.y--;
		}
		public void up() {
			this.x--;
		}
		public void down() {
			this.x++;
		}
		public void directionChanger() {
			if(this.d == 0) this.d = 1;
			else if (this.d == 1)this.d =0;
			else if(this.d == 2)this.d = 3;
			else this.d = 2;
		}
		@Override
		public String toString() {
			return "Chess [id=" + id + ", x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	static int n,k;
	static int[] dx = {0,0,-1,1},dy = {1,-1,0,0};
	static int[][] graph;
	static ArrayList<Integer>[][] chessMap;
	static Chess[] chessInfo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		chessMap = new ArrayList[n][n];
		chessInfo = new Chess[k];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
				chessMap[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken())-1;
			int y = Integer.valueOf(st.nextToken())-1;
			int d = Integer.valueOf(st.nextToken())-1;
			chessMap[x][y].add(i);
			chessInfo[i] = new Chess(i, x, y, d);
		}
		int count = 0;

		while (count<1000) {
			count++;
			boolean flag = false;
			for (int i = 0; i < k; i++) {
				System.out.println("k : "+i);
				int x =chessInfo[i].x;
				int y =chessInfo[i].y;
				int nx = x+dx[chessInfo[i].d];
				int ny = y+dy[chessInfo[i].d];
				System.out.println(x+" "+y+ " "+chessInfo[i].d);
				System.out.println(nx+" "+ny);
				if(nx<0||ny<0||nx>=n||ny>=n||graph[nx][ny] == 2) {
					chessInfo[i].directionChanger();
					System.out.println("direct change");
					nx = x + dx[chessInfo[i].d];
					ny = y + dy[chessInfo[i].d];
					System.out.println(nx+" "+ny);
					if(nx<0||ny<0||nx>=n||ny>=n||graph[nx][ny] == 2)continue;
					else if(graph[nx][ny] == 0) {
						white(i,x,y,nx,ny);
					}else if (graph[nx][ny] == 1) {
						red(i,x,y,nx,ny);
					}
				}else if(graph[nx][ny] == 0) {
//					System.out.println("befor : "+chessInfo[i]);
					white(i, x, y, nx, ny);
//					System.out.println("after : "+chessInfo[i]);
				}else if (graph[nx][ny] == 1) {
					red(i, x, y, nx, ny);
				}
//				for (int j = 0; j < chessMap[nx][ny].size(); j++) {
//					System.out.println(chessMap[nx][ny].get(j));
//				}
				if(chessMap[nx][ny].size()>=4) {
					flag = true;
					System.out.println("count : "+count);
					break;
				}
			}
			if(flag)break;
//			System.out.println(Arrays.toString(chessInfo));
//			for (int i = 0; i < n; i++) {
//				if(flag)break;
//				for (int j = 0; j < n; j++) {
//					if(chessMap[i][j].size()>=4) flag = true;
//				}
//			}
//			if(flag) break;
		}
		System.out.println(count==1000?-1:count);

	}
	private static void red(int i, int x, int y, int nx, int ny) {
//		System.out.println("red !!");
		int index = chessMap[x][y].indexOf(i);
//		System.out.println("index : "+index);
		int size = chessMap[x][y].size();
		for (int j = size-1; j >= index; j--) {
			int temp = chessMap[x][y].remove(j);
			System.out.println("temp : "+temp);
			chessMap[nx][ny].add(temp);
			System.out.println("before : "+chessInfo[temp]);
			if(chessInfo[i].d==2)chessInfo[temp].up();
			else if(chessInfo[i].d == 0) chessInfo[temp].right();
			else if(chessInfo[i].d == 3) chessInfo[temp].down();
			else if(chessInfo[i].d == 1) chessInfo[temp].left();
			System.out.println("after : "+chessInfo[temp]);
		}
	}
	private static void white(int i, int x, int y, int nx, int ny) {
		int index = chessMap[x][y].indexOf(i);
		int size = chessMap[x][y].size();
		for (int j = 0; j < size-index; j++) {
			int temp = chessMap[x][y].remove(index);
			System.out.println("j : "+j);
			chessMap[nx][ny].add(temp);
			System.out.println("before: "+chessInfo[temp]);
			if(chessInfo[i].d==2)chessInfo[temp].up();
			else if(chessInfo[i].d == 0) chessInfo[temp].right();
			else if(chessInfo[i].d == 3) chessInfo[temp].down();
			else if(chessInfo[i].d == 1) chessInfo[temp].left();
			System.out.println("after : "+chessInfo[temp]);

		}
	}

}
