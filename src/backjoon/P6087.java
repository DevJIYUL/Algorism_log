package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P6087 {
	static int w,h;
	static int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
	static char[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.valueOf(st.nextToken());
		h = Integer.valueOf(st.nextToken());
		int[] start = new int[2];
		int[] end = new int[2];
		graph = new char[h][w];
		boolean flag = true;
		for (int i = 0; i < h; i++) {
			String input = br.readLine();
			for (int j = 0; j < w; j++) {
				graph[i][j] = input.charAt(j);
				if(flag && graph[i][j]=='C') {
					start[0] =i;
					start[1]=j;
					flag = false;
				}
				if(!flag && graph[i][j]=='C') {
					end[0] =i;
					end[1]=j;
				}
			}
		}
//		System.out.println(start[0] +" "+start[1]);
//		System.out.println(end[0] +" "+end[1]);
		int[][][] visited = new int[h][w][4];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);				
			}
		}
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
//		visited[start[0]][start[1]] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = start[0]+dx[i];
			int ny = start[1]+dy[i];
			if(nx<0||nx>=h||ny<0||ny>=w||graph[nx][ny] == '*')continue;
			visited[nx][ny][i] = 0;
			pqueue.add(new int[] {0,nx,ny,i});
		}
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
//			System.out.println(Arrays.toString(temp));
			if(temp[0]>visited[temp[1]][temp[2]][temp[3]])continue;
//			if(graph[temp[1]][temp[2]] == 'C') {
//				end = new int[] {temp[1],temp[2]};
//				break;
//			}
			for (int i = 0; i < 4; i++) {
				if((i+2)%4 == temp[3])continue;
				int nx = temp[1]+dx[i];
				int ny = temp[2]+dy[i];
				if(nx<0||nx>=h||ny<0||ny>=w||graph[nx][ny] == '*')continue;
//				visited[nx][ny] = true;
				if(temp[3] == 0||temp[3] == 2) {
					if(i==1||i==3) {
						if(visited[nx][ny][i] > visited[temp[1]][temp[2]][temp[3]]+1) {
							visited[nx][ny][i] = visited[temp[1]][temp[2]][temp[3]]+1;
							pqueue.add(new int[] {temp[0]+1,nx,ny,i});
						}
					}else {
						if(visited[nx][ny][i] > visited[temp[1]][temp[2]][temp[3]]) {
							visited[nx][ny][i] = visited[temp[1]][temp[2]][temp[3]];
							pqueue.add(new int[] {temp[0],nx,ny,i});
						}
					}
				}else {
					if(i==0||i==2) {
						if(visited[nx][ny][i] > visited[temp[1]][temp[2]][temp[3]]+1) {
							visited[nx][ny][i] = visited[temp[1]][temp[2]][temp[3]]+1;
							pqueue.add(new int[] {temp[0]+1,nx,ny,i});
						}

					}else {
						if(visited[nx][ny][i] > visited[temp[1]][temp[2]][temp[3]]) {
							visited[nx][ny][i] = visited[temp[1]][temp[2]][temp[3]];
							pqueue.add(new int[] {temp[0],nx,ny,i});
						}
					}
				}
			}
		}
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				System.out.print(Arrays.toString(visited[i][j])+" ");
//			}
//			System.out.println();
//		}

		System.out.println(Math.min(Math.min(Math.min(visited[end[0]][end[1]][0], visited[end[0]][end[1]][1]), visited[end[0]][end[1]][2]),visited[end[0]][end[1]][3]));
	}

}
