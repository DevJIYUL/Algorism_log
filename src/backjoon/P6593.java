package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6593 {
	static int l,r,c,answer,start[];
	static int[] dx = {0,1,0,-1,0,0},dy = {1,0,-1,0,0,0},dz = {0,0,0,0,1,-1};
	static char graph[][][];
	static boolean visited[][][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.valueOf(st.nextToken());
			r = Integer.valueOf(st.nextToken());
			c = Integer.valueOf(st.nextToken());
			if(l==0 && r==0 && c ==0)break;
			start = new int[3];
			graph = new char[l][r][c];
			visited = new boolean[l][r][c];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						graph[i][j][k] = str.charAt(k);
						if(graph[i][j][k] == 'S')start = new int[] {i,j,k};
					}
				}
				String a = br.readLine();
			}
//			System.out.println(l+" "+r+" "+c);
			answer = bfs();
			//System.out.println("answer : "+answer);
			System.out.println(answer==0?"Trapped!":"Escaped in "+answer+" minute(s).");
		}
		
		
	}
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start[0],start[1],start[2],0});
		visited[start[0]][start[1]][start[2]] = true;
		int result = 0;
		while (!queue.isEmpty()) {
			int[] temp =queue.poll();
			if(graph[temp[0]][temp[1]][temp[2]] == 'E') {
				result = temp[3];
				break;
			}
			for (int i = 0; i < 6; i++) {
				int nz = temp[0]+dz[i];
				int nx = temp[1]+dx[i];
				int ny = temp[2]+dy[i];
				if(nz<0||nz>=l||nx<0||nx>=r||ny<0||ny>=c||visited[nz][nx][ny]||graph[nz][nx][ny] == '#')continue;
				visited[nz][nx][ny] = true;
				queue.add(new int[] {nz,nx,ny,temp[3]+1});
			}
		}
		return result;
	}

}
