package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class P2668 {
	static int n, arr[],result;
	static boolean visited[];
	static ArrayList<Integer> ar ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i] =Integer.valueOf(br.readLine());
		}
		ar= new ArrayList<>();
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			dfs(i,i);
		}
		System.out.println(ar.size());
		Collections.sort(ar);
		for (Integer integer : ar) {
			System.out.println(integer);
		}
	}
	private static void dfs(int i,int t) {
		if(!visited[arr[i]]) {
			visited[arr[i]] = true;
			dfs(arr[i],t);
		}
		if(arr[i] == t)ar.add(t);			
		
	}

}
