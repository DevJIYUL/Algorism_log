package com.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
public class BJ_2961 {
	static int n,result;
	static int[] s,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int [n];
		b = new int [n];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(s));
//		System.out.println(Arrays.toString(b));
		cal(0,1,0);
		System.out.println(result);
	}
	
	static void cal(int count,int sour,int bitter) {
		if (count == n-1) {
//			if (sour == 1 && bitter == 0) return; 
			result = Math.min(result, Math.abs(sour-bitter));
//			System.out.println("sour:"+sour+" bitter : "+bitter+" result :"+result);
			return;
		}
		cal(count+1,sour*s[count],bitter+b[count]);
		cal(count+1,sour,bitter);
	}
}
