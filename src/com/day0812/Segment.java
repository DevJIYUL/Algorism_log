package com.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Segment {
	static long tree[];
	static int treeSize,n;
	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Segment stree = new Segment(n);
		stree.init(arr, 1, 1, n);
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i]+" ");
		}
		System.out.println();
		System.out.println(stree.sum(1,1,n-1,3,5));
		System.out.println(stree.sum(2,1,n-1,3,5));
		System.out.println(stree.sum(3,1,n-1,3,5));
		System.out.println(stree.sum(1,1,n-1,3,4));
		System.out.println(stree.sum(2,1,n-1,3,4));
		
	}
	public Segment(int arrSize) {
		int h = (int)Math.ceil(Math.log(arrSize)/Math.log(2));
		
		this.treeSize = (int)Math.pow(2,h+1);
		System.out.println(treeSize);
		tree = new long[treeSize];
	}
	
	public long init(long[] arr, int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		return tree[node] = init(arr,node*2,start,(start+end)/2)+
				init(arr,node*2+1,(start+end)/2+1,end);
	}
	
	public long sum(int node, int start,int end,int left,int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		return sum(node*2,start,(start+end)/2,left,right)+sum(node*2+1,(start+end)/2+1,end,left,right);
	}
}
