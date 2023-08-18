package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16928 {
	static int n,m;
	static ArrayList<int[]> ladder,snake;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		ladder = new ArrayList<>();
		snake = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			ladder.add(new int[] {a,b});
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			snake.add(new int[] {a,b});
		}
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pqueue.add(new int[] {1,0});
		boolean[] visited = new boolean[101];
		visited[1] = true;
		while (!pqueue.isEmpty()) {
			int[] temp = pqueue.poll();
//			System.out.println(Arrays.toString(temp));
			if(temp[0] == 100) {
				System.out.println(temp[1]);
				break;
			}
			for (int i = 1; i <= 6; i++) {
				int nx = temp[0]+i;
				if(nx >=101)continue;
				if(visited[nx]) continue;
				boolean flag = false;
				for (int j = 0; j < n; j++) {
					if(ladder.get(j)[0] == nx) {
						pqueue.add(new int[] {ladder.get(j)[1],temp[1]+1});
						flag = true;
						visited[nx] = true;
						break;
					}
				}
				for (int j = 0; j < m; j++) {
					if(snake.get(j)[0] == nx) {
						pqueue.add(new int[] {snake.get(j)[1],temp[1]+1});
						flag = true;
						visited[nx] = true;
						break;
					}
				}
				if(flag)continue;
				pqueue.add(new int[] {nx,temp[1]+1});
				visited[nx] = true;
			}
		}
	}

}
