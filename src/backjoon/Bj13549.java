package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj13549 {
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		boolean[] visited = new boolean[100001];
		visited[n] = true;
//		Queue<int[]> queue = new ArrayDeque<int[]>();
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]!=o2[1]?o1[1]-o2[1]:o1[0]-o2[0]);
		queue.add(new int[] {n,0});
		while (!queue.isEmpty()) {
//			System.out.println(Arrays.toString(queue.peek()));
			int[] temp = queue.poll();
			if(temp[0] == m) {
				System.out.println(temp[1]);
				break;
			}
			if(2*temp[0]<=100000&&!visited[2*temp[0]]) {
				queue.add(new int[] {2*temp[0],temp[1]});
				visited[2*temp[0]] = true;
			}
			
			if(temp[0]+1<=100000&&!visited[temp[0]+1]) {
				queue.add(new int[] {temp[0]+1,temp[1]+1});
				visited[temp[0]+1] = true;
			}
			
			if(temp[0]-1>=0&&!visited[temp[0]-1]) {
				queue.add(new int[] {temp[0]-1,temp[1]+1});
				visited[temp[0]-1] = true;
			}
			
			
		}
	}

}
