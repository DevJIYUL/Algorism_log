package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2042 {
	static int n,m,k;
	static long[] a,tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.valueOf(br.readLine());
		}
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		tree = new long[1<<(h+1)];
		init(a,tree,1,0,n-1);
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			long c = Long.valueOf(st.nextToken());
			if(e==1) update(a,tree,1,0,n-1,b-1,c);
			else System.out.println(quary(a,tree,1,0,n-1,b-1,c-1));
		}
		System.out.println("a : "+Arrays.toString(a));
		System.out.println("tree : "+Arrays.toString(tree));
	}
	private static long quary(long[] a, long[] tree, int node, int start, int end, int left, long right) {
		if(right < start || left > end)return 0;
		if(left <= start && end <= right) return tree[node];
		long l = quary(a, tree, node*2, start, (start+end)/2, left, right);
		long r = quary(a, tree, node*2+1,(start+end)/2+1,end, left, right);
		return l+r;
	}
	private static void update(long[] a, long[] tree, int node, int start, int end, int index, long value) {
		if(index < start||index > end)return;
		if(start == end) {
			a[index] = value;
			tree[node] = value;
			return;
		}
		update(a,tree,node*2,start,(start+end)/2,index,value);
		update(a,tree,node*2+1,(start+end)/2+1,end,index,value);
		tree[node] = tree[node*2]+tree[node*2+1];
		
	}
	private static void init(long[] a, long[] tree, int node, int start, int end) {
		if(start == end) tree[node] = a[start];
		else {
			init(a,tree,node*2,start,(start+end)/2);
			init(a,tree,node*2+1,(start+end)/2+1,end);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}

}
