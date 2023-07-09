package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P15663 {
	static int n,k;
	static int[] arr,elect;
	static boolean[] visited;
	static HashSet<Integer> has;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		has = new HashSet<>();
		arr = new int[n];
		elect = new int[k];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr)+" "+n+" "+k);
		cal(0,0);
	}
	private static void cal(int i,int count) {
		
		if(count == k) {
			for (int j : elect) {
				System.out.print(j+" ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(elect));
			return;
		}
		int te = 0;
		for (int j = 0; j < n; j++) {
			if(j>0 && arr[j] == te)continue;
			if(visited[j]) continue;
			te = arr[j];
			visited[j] = true;
			elect[count] = arr[j];
			cal(j,count+1);
			visited[j] = false;
		}
	}

}
