package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P2251 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		arr[0] = Integer.valueOf(st.nextToken());
		arr[1] = Integer.valueOf(st.nextToken());
		arr[2] = Integer.valueOf(st.nextToken());
		TreeSet<Integer> answer = new TreeSet<>();
		boolean[][] visited = new boolean[201][201];
		answer.add(arr[2]);
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,arr[2]});
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0] == 0) {
				answer.add(temp[2]);
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int[] t = new int[] {temp[0],temp[1],temp[2]};
					if(i!=j) {
						t[j] = temp[j]+temp[i]>arr[j]?arr[j]:temp[j]+temp[i];
						t[i] = arr[j]-temp[j]>temp[i]?0:temp[i]-(arr[j]-temp[j]);
					}
//					System.out.println(Arrays.toString(t));
					if(visited[t[0]][t[1]])continue;
					visited[t[0]][t[1]] = true;
					queue.add(t);
				}
			}
		}
		for (Integer integer : answer) {
			System.out.print(integer+" ");
		}
	}

}
