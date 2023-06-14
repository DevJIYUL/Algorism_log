package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1043 {
	static int n,m,answer;
	static int[] parent;
	static boolean[] true_peo;
	static ArrayList<int[]> party;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		parent = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int temp = Integer.valueOf(st.nextToken());
		true_peo = new boolean[51];
		for (int i = 0; i < temp; i++) {
			true_peo[Integer.valueOf(st.nextToken())] = true;
		}
		if(temp == 0) {
			System.out.println(m);
			return ;
		}
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		party = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.valueOf(st.nextToken());
			int[] t = new int[num];
			for (int j = 0; j < num; j++) {
				t[j] = Integer.valueOf(st.nextToken());
				if(j != 0) {
					int left = t[j-1];
					int right = t[j];
					union(right,left);
				}
			}
			party.add(t);
		}
//		System.out.println(Arrays.toString(parent));
//		System.out.println(Arrays.toString(true_peo));
		boolean[] visited = new boolean[51];
		for (int i = 1; i <= n; i++) {
			if(true_peo[i] && !visited[i]) {
				int root = find(i);
				for (int j = 1; j <= n; j++) {
					if(find(j) == root) {
						true_peo[j] = true;
						visited[j] = true;
					}
				}
			}
		}
		for (int i = 0; i < party.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < party.get(i).length; j++) {
				if(true_peo[party.get(i)[j]]) {
					flag = true;
					break;
				}
			}
			if(!flag)answer++;
		}
		System.out.println(answer);
	}
	private static void union(int a, int b) {
		int parenta = find(a);
		int parentb = find(b);
		if(parenta != parentb)parent[parentb] = parenta;
	}
	public static int find(int a) {
		if(parent[a] == a)return a;
		else return find(parent[a]);
	}

}

