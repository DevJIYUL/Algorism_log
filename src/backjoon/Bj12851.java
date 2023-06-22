package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj12851 {
	static int n,k,result,count,m;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.MAX_VALUE;
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {n,0});
//		visited[n] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			visited[temp[0]] = true;
			if(temp[0] == k) {
//				System.out.println(Arrays.toString(temp));
				if(temp[1]<=m) {
					m = temp[1];
					result = m; 
					count++;
				}
				continue;
			}
			if(temp[0]+1 < 100001 && !visited[temp[0]+1]) {
//				visited[temp[0]+1] = true;
				queue.add(new int[] {temp[0]+1,temp[1]+1});
			}
			if(temp[0]-1 >= 0 && !visited[temp[0]-1]) {
//				visited[temp[0]-1] = true;
				queue.add(new int[] {temp[0]-1,temp[1]+1});
			}
			if(2*temp[0]<100001 && !visited[2*temp[0]]) {
//				visited[2*temp[0]] = true;
				queue.add(new int[] {2*temp[0],temp[1]+1});
			}
		}
		System.out.println(result);
		System.out.println(count);
	}

}
