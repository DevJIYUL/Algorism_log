package com.day1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15961 {
	static int n,d,k,c,result;
	static int[] belt;
	static int[] dishes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		belt = new int[n];
		dishes = new int[d+1];
		int start = 0;
		int end = k;
		int count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			belt[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			if(dishes[belt[i]] == 0) count++;
			dishes[belt[i]] += 1;
		}
//		for (int i = 1; i < d+1; i++) {
//			if(dishes[i]!=0) count++;
//		}
//		if(dishes[c] == 0) {
//			count++;
//		}
		result = count;
		System.out.println(Arrays.toString(belt));
		System.out.println(Arrays.toString(dishes));
		System.out.println(result);
		System.out.println("---------------");
		while (start<n) {
			if(dishes[belt[start]] == 1) {
				count--;
			}
			dishes[belt[start]]--;
			System.out.println(start+" "+belt[start]+" 1빠짐");
			if(dishes[belt[end]] == 0) {
				count++;
			}
			dishes[belt[end]%n]++;
			System.out.println(end+" "+belt[end]+" 1 더해짐");
			start++;
			end++;
//			count = 0;
//			for (int i = 1; i < d+1; i++) {
//				if(dishes[i]!=0) count++;
//			}
			if(dishes[c] == 0) count++;
//			else count--;
			result = Math.max(result, count);
			if(dishes[c] == 0) count--;
			System.out.println(Arrays.toString(dishes));
			System.out.println(start+" "+end+" "+result);
			System.out.println("---------------------");
		}
		System.out.println(result);
	}

}
