package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1941 {
	static int result;
	static char[][] graph;
	static int[] select;
	static boolean[] visit;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 5; j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		select = new int[7];
		visit = new boolean[26];
		go(0,0);
		System.out.println(result);
	}
	private static void go(int index, int count) {
		if(count == 7) {
			int[][] g = new int[5][5];
			for (int is : select) {
				int x = is/5;
				int y = is%5;
				g[x][y] = 1;
			}
			int m = 1;
			boolean[][] visited = new boolean[5][5];
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {select[0]/5,select[0]%5});
			visited[select[0]/5][select[0]%5] = true;
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				
//				System.out.println(temp[0]+" "+temp[1]+" "+temp[2]);
				for (int i = 0; i < 4; i++) {
					int nx = temp[0]+dx[i];
					int ny = temp[1]+dy[i];
					if(nx<0||ny<0||nx>=5||ny>=5||g[nx][ny] == 0 ||visited[nx][ny])continue;
					if(g[nx][ny] == 1) {
						visited[nx][ny] = true;
						m++;
						queue.add(new int[] {nx,ny});
					}
				}
			}
			int s = 0;
			if(m == 7) {
				for (int is : select) {
					int x = is/5;
					int y = is%5;
					if(graph[x][y] == 'S') s++;
				}
			}
//			if(select[0] ==5 &&select[1]==6&&select[2]==7&&select[3]==8&&select[4]==9&&select[5]==11&&select[6] == 16) {
//				for (int i = 0; i < 5; i++) {
//					System.out.println(Arrays.toString(g[i]));
//				}
//				System.out.println("m : "+m);
//				System.out.println("s : "+s);
//			}
			if(s>=4) {
//				System.out.println("m : "+m);
//				System.out.println(Arrays.toString(select));
//				for (int i = 0; i < 5; i++) {
//					System.out.println(Arrays.toString(g[i]));
//				}
//				System.out.println(" s : "+s);
				result++;
//				System.out.println(result);
			}
			return;
		}
		for (int i = index; i < 25; i++) {
			if(visit[i])continue;
			visit[i] = true;
			select[count] = i;
			go(i+1,count+1);
			visit[i] = false;
		}
	}

	

}
