package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2357 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		long[] a = new long[n];
		int size = (int) Math.ceil(Math.log(n)/Math.log(2));
		long[] minTree = new long[1<<(size+1)];
		long[] maxTree = new long[1<<(size+1)];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		minInit(a,minTree,1,0,n-1);
		maxInit(a,maxTree,1,0,n-1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			System.out.println(minQuary(a,minTree,1,0,n-1,x-1,y-1)+" "+maxQuary(a,maxTree,1,0,n-1,x-1,y-1));
		}
	}

	private static long minQuary(long[] a, long[] minTree, int node, int start, int end, int left, int right) {
		if(right<start || end<left) return Long.MAX_VALUE;
		else if(left<=start && end<=right) return minTree[node];
		long l = minQuary(a, minTree, node*2, start, (start+end)/2, left, right);
		long r = minQuary(a, minTree, node*2+1, (start+end)/2+1,end, left, right);
		return Math.min(l, r);
	}

	private static long maxQuary(long[] a, long[] maxTree, int node, int start, int end, int left, int right) {
		if(right<start || end<left) return Long.MIN_VALUE;
		else if(left<=start && end<=right) return maxTree[node];
		long l = maxQuary(a, maxTree, node*2, start, (start+end)/2, left, right);
		long r = maxQuary(a, maxTree, node*2+1,(start+end)/2+1,end, left, right);
		return Math.max(l, r);
	}

	private static void maxInit(long[] a, long[] maxTree, int node, int start, int end) {
		if(start == end) maxTree[node] = a[start];
		else {
			maxInit(a, maxTree, node*2, start, (start + end)/2);
			maxInit(a, maxTree, node*2+1, (start + end)/2+1,end);
			maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
		}
	}

	private static void minInit(long[] a, long[] minTree, int node, int start, int end) {
		if(start == end) minTree[node] = a[start];
		else {
			minInit(a, minTree, node*2, start, (start+end)/2);
			minInit(a, minTree, node*2+1, (start+end)/2+1,end);
			minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
		}
	}

}
