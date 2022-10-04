package com.day0930;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static ArrayList<Integer> num;
    static long f=1;
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5,40)));
	}
	static int[] solution(int n, long k) {
    	num = new ArrayList<>();
		for (int i = 1; i < n+1; i++) {
			num.add(i);
			f*=i;
		}
		int[] answer = new int[n];
		for (int i = n; i > 0; i--) {
			int dvd = (int)(f/i);
			if(f-i==0) {
				dvd=1;
			}
			f = dvd;
			int a = (int) (k/dvd);
			if(k-dvd==0) a=1;
			k = (int) k%dvd;
			if(k==0) {
				a-=1;
				k = f;
			}
			if(a>=0)answer[n-i] = num.remove(a);
		}
		return answer;
    }
}