package com.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static boolean[] visited;
	static int n,m,sum;
	static int[] lst,hap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 1; i <= test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sum = 0;
//			LinkedList<Integer> lst = new LinkedList<>();
			lst = new int[n];
			hap = new int[2];
			visited = new boolean[n+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
//				lst.add(Integer.parseInt(st.nextToken()));
				lst[j] = Integer.parseInt(st.nextToken());
			}
			per(0,0);
			if (sum == 0) {
				System.out.println("#"+i+" "+-1);
			}else {
				System.out.println("#"+i+" "+sum);
			}
		}
	}
	static void per(int index, int count) {
		if (count == 2) {
			if (hap[0]+hap[1]<= m) {
				sum = Math.max(sum, hap[0]+hap[1]);
			}
//			System.out.println(Arrays.toString(hap));
			return;
		}
		for (int i = index; i < n; i++) {
			if (visited[i]) continue;
			
			hap[count] = lst[i];
			visited[i] = true;
			per(i,count + 1);
			visited[i] = false;
		}
	}

}
/*
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
*/
