package com.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
	static int n,m,end = -1;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		}
//		System.out.println(binarySearch(0,end));
		System.out.println(binarySearchOther(0,end));
	}
	private static int binarySearchOther(int i, int end2) {
		int start = i;
		int end = end2*2+1;
		while (start<end) {
			int mid = (start + end+1)/2;
			long cut = 0;
			// 여기 나무 자르는거 매번 돌리는것 보다 배열에 미리 계산 해놓고 비교해야 할까요?
			for (int j : tree) {
				if(j>mid) cut += j-mid;
			}
			if(m<=cut) {
				start = mid;
			}else {
				end = mid-1;
			}
		}
		return start;
	}
	private static int binarySearch(int i, int end2) {
		int start = i;
		int end = end2;
		int ret = -1;
		while (start <= end) {
			int mid = (start + end)/2;
			long cut = 0;
			// 여기 나무 자르는거 매번 돌리는것 보다 배열에 미리 계산 해놓고 비교해야 할까요?
			for (int j : tree) {
				if(j>mid) cut += j-mid;
			}
			System.out.println("시작 : "+start+" 끝 점 : "+end+" 중간지점 : "+mid+" 잘린 나무 양 : "+cut);
			if(m == cut) {
				return mid;
			}else if(m < cut) {
				ret = mid;
				start = mid+1;
			}else if(m > cut) {
				end = mid-1;
			}
			
		}
		return ret;
	}

}
