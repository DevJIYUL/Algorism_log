package com.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 낚시왕
public class BJ17143 {
	static class Shark{
		int s,d,z;
		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+s+" "+ d+" "+z+" "+"]";
		}
		
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		
	}
	static int r,c,m,result;
	static Shark[][] shark;
	static Shark[][] future;
	static ArrayList<Point> position;
	static ArrayList<Point> temp;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		shark = new Shark[r+1][c+1];
		future= new Shark[r+1][c+1];
		for (int i = 0; i < r+1; i++) {
			for (int j = 0; j < c+1; j++) {
				shark[i][j] = new Shark(0,0,0);
				future[i][j] = new Shark(0,0,0);
			}
		}
		position = new ArrayList<>();
		temp = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			position.add(new Point(R, C));
			shark[R][C] = new Shark(s, d, z);
		}
		int person = 0;
		while (++person <= c) {
			
			// 물고기 잡기
			for (int i = 1; i <= r; i++) {
				if (shark[i][person].d != 0) {
					result += shark[i][person].z;
					shark[i][person] = new Shark(0,0,0);
					break;
				}
			}
			if(position.size()==0)break;
			// 물고기 움직이기
			for (int i = 0; i < position.size(); i++) {
				Point p = position.get(i);
				if(shark[p.x][p.y].d == 0 && shark[p.x][p.y].s ==0 && shark[p.x][p.y].z == 0)continue;
				Shark sh = shark[p.x][p.y];
				System.out.println("이동 전"+p.x+" "+p.y);
				int nx = p.x + dx[sh.d]*sh.s;
				int ny = p.y + dy[sh.d]*sh.s;
				while(nx<=0||ny<=0||nx>r||ny>c) {
					if(nx<=0) {
						nx-=2;
						nx = Math.abs(nx);
					}else if(nx>r) {
						nx = r-(nx-r);
					}else if(ny<=0) {
						ny-= 2;
						ny = Math.abs(ny);
					}else if(ny>c) {
						ny = c-(ny-c);
					}
					if(sh.d==1) sh.d = 2;
					else if(sh.d==2) sh.d = 1;
					else if(sh.d==3) sh.d = 4;
					else if(sh.d==4) sh.d = 3;
					
				}
				
				System.out.println("이동 후"+nx+" "+ny);
				// 움직이는 자리에 있으면 크기 비교 없으면 그냥 넣어줌
				if(future[nx][ny].d == 0) {
					future[nx][ny] = sh;
					temp.add(new Point(nx, ny));
				}else {
					if(sh.z>future[nx][ny].z) future[nx][ny] = sh;
				}
			}
			for (int i = 0; i < r+1; i++) {
				for (int j = 0; j < c+1; j++) {
					shark[i][j] = new Shark(0,0,0);
				}
			}
			position.clear();
			for (int i = 0; i <= r; i++) {
				for (int j = 0; j <= c; j++) {
					shark[i][j] = future[i][j];
					future[i][j] = new Shark(0, 0, 0);
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				position.add(temp.get(i));
			}
			temp.clear();
		}
		System.out.println(result);
	}

}
