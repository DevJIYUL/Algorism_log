package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10815 {
	static int n,m;
	static int[] arr,arr2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		n = Integer.valueOf(st.nextToken());
//		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.valueOf(st.nextToken());
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
//		System.out.println(map);
		st = new StringTokenizer(br.readLine());
		m = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int temp = Integer.valueOf(st.nextToken());
			sb.append(map.containsKey(temp)?map.get(temp)+" ":0+" ");
		}
		System.out.println(sb);
				

	}

}
