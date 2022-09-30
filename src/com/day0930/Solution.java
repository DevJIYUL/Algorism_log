package com.day0930;

import java.util.Arrays;

class Solution {
	static int t;
    static int[] num;
    static int[] list;
    static boolean[]  visited;
//	public static void main(String[] args) {
//		solution(3,5);
//		
//	}
	static int[] solution(int n, long k) {
    	num = new int[n];
    	list = new int[n];
    	visited = new boolean[n];
		for (int i = 1; i < n+1; i++) {
			num[i-1] = i;
		}
		int[] answer = {};
		int[] temp = per(0,n,k);
        return answer;
    }
	static int[] per(int count,int n,long k) {
		if(count == n) {
//			System.out.println(Arrays.toString(list));
			t++;
			if(t==k) return list;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list[count] = num[i];
			per(count+1,n,k);
			visited[i] = false;
		}
		return list;
	}
}