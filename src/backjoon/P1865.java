package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1865 {
	static int testcase;
	static boolean flag;
	static int[] distance;
	static ArrayList<ArrayList<int[]>> graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testcase = Integer.valueOf(st.nextToken());
		for (int i = 0; i < testcase; i++) {
			flag = false;
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());
			graph = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				graph.add(new ArrayList<>());
			}
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				graph.get(a).add(new int[] {b,c});
				graph.get(b).add(new int[] {a,c});
			}
			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				for (int k = 0; k < graph.get(a).size(); k++) {
					if(b==graph.get(a).get(k)[0]) {
						graph.get(a).remove(k);
						break;
					}
				}
				graph.get(a).add(new int[] {b,-c});

			}
//			for (ArrayList<int[]> arrayList : graph) {
//				for (int j = 0; j < arrayList.size(); j++) {
//					System.out.print(Arrays.toString(arrayList.get(j))+" ");
//				}
//				System.out.println();
//			}
			flag = false;
			for (int j = 1; j <= n; j++) {
				if(cal(n,j)) {
					flag = true;
					break;
				};
			}
			System.out.println(flag?"YES":"NO");
		}
	}

	public static boolean cal(int n, int start) {
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		boolean update = false;
		for (int i = 1; i < n; i++) {
			update = false;
			for (int j = 1; j <= n; j++) {
				for (int k = 0; k < graph.get(j).size(); k++) {
					if(distance[j] != Integer.MAX_VALUE && distance[graph.get(j).get(k)[0]] > distance[j] + graph.get(j).get(k)[1]) {
						distance[graph.get(j).get(k)[0]] = distance[j] + graph.get(j).get(k)[1];
						update = true;
					}
					
				}
			}
			if(!update)break;
		}
		if(update) {
			for (int i =0; i < n+1; i++) {
				for (int j = 0; j < graph.get(i).size(); j++) {
					if(distance[i] != Integer.MAX_VALUE && distance[graph.get(i).get(j)[0]] > distance[i] + graph.get(i).get(j)[1]) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
