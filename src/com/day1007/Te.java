package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Te {
	static int n,m;
	static long left,right,mid,result,count,compare;
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[m];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		left = 0;
		right = 300000;
		while (left < right) {
			mid = (left+right)/2;
			if(f(mid)) {
				right = mid ;
				compare = count;
			}else {
				left = mid+1;
			}
		}
		result = right;
		long index = compare-n;
		int back = 0;
		long answer = 0;
		if(m > result) answer = result;
		else for (int i = input.length-1; i > -1; i--) {
			if(result % input[i] == 0) {
				answer = i+1;
				if(back == index)break;
				back++;
			}
		}
		System.out.println(answer);
	}
	private static boolean f(long val) {
		count = 0;
		for (int i : input) {
			if(val == 0)break;
			if(i>val) {
				count++;
				val--;
			}
			else count += val/i+1;
		}
		return count>=n;
	}

}
