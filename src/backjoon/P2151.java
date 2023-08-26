package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P2151 {
	static char[][] graph;
	static int n,result,doorX,doorY;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		graph = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = input.charAt(j);
				if(graph[i][j] == '#') {
					doorX = i;
					doorY = j;
				}
			}
		}
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[3]-o2[3]);
		for (int i = 0; i < 4; i++) {
			int nx = doorX+dx[i];
			int ny = doorY+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n||graph[nx][ny]=='*')continue;
			if(graph[nx][ny] == '.') {
				pqueue.add(new int[] {nx,ny,i,0});
			}else if(graph[nx][ny] == '!') {
				pqueue.add(new int[] {nx,ny,i,0});
				pqueue.add(new int[] {nx,ny,(i+1)%4,1});
				pqueue.add(new int[] {nx,ny,(i+3)%4,1});
			}else if(graph[nx][ny] == '#') {				
				pqueue.add(new int[] {nx,ny,i,0});
			}
		}
//		System.out.println(Arrays.toString(pqueue.peek()));
		visited[doorX][doorY] = true;
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
//			System.out.println(Arrays.toString(temp));
			if(graph[temp[0]][temp[1]] == '#') {
//				System.out.println("문찾음");
				if(temp[0] == doorX && temp[1] == doorY)continue;
				else {
//					System.out.println("정답");
					System.out.println(temp[3]);
					break;
				}
			}
			int nx = temp[0]+dx[temp[2]];
			int ny = temp[1]+dy[temp[2]];
			int direct = temp[2];				
			if(nx<0||ny<0||nx>=n||ny>=n||graph[nx][ny] == '*')continue;
			if(graph[nx][ny] == '!') {
				pqueue.add(new int[] {nx,ny,(direct),temp[3]});
				pqueue.add(new int[] {nx,ny,(direct+3)%4,temp[3]+1});
				pqueue.add(new int[] {nx,ny,(direct+1)%4,temp[3]+1});
			}else if(graph[nx][ny] == '.'||graph[nx][ny] == '#') {
				pqueue.add(new int[] {nx,ny,direct,temp[3]});
			}
		}
		
	}

}
