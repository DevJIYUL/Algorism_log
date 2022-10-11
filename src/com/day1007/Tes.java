package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tes {
	static int n,c,result,left,right,mid;
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		input = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		left = 0;
		right = input[n-1]-input[0];
		while (left != right) {
			System.out.println("left : "+left+" right : "+right);
			mid = (left +right+1)/2;
			System.out.println("공유기 최소 값은 : "+mid);
			int count = 0;
			int ret = -100000;
			for (int i = 0; i < n; i++) {
				if(input[i]-ret>=mid) {
					count++;
					ret = input[i];
				}
			}
			System.out.println("count : "+count);
			if(count>=c) {
				System.out.println("답이 될수 있음");
				left = mid;
			}else {
				System.out.println("답이 될수 없음");
				right = mid-1;
			}
		}
		
		System.out.println(left);
		
	}
}
