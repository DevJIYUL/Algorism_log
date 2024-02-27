package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P15656 {
	static int n,m;
	static int[] arr, select;
	static StringBuilder sb;
	static boolean[] visited;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n];
		select = new int[m];
		visited = new boolean[n];
		set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		per(0,0);
//		System.out.println(set);
		set.forEach(System.out::println);
	}
	public static void per(int index,int count) {
		if(count == m) {
//			System.out.println(Arrays.toString(select));
			String temp = "";
			for (int i = 0; i < select.length; i++) {
//				sb.append(select[i]+" ");
				temp +=select[i]+" ";
			}
//			sb.append("\n");
			set.add(temp);
			return;
		}
		for (int i = index; i < n; i++) {
			if(visited[i])continue;
			select[count] = arr[i];
			visited[i] = true;
			per(i+1,count+1);
			visited[i] = false;
		}
	}

}
