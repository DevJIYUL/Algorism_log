package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10999 {
	static int n,m,k;
	static long[] a,tree,lazy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.valueOf(st.nextToken());
		m=Integer.valueOf(st.nextToken());
		k=Integer.valueOf(st.nextToken());
		a = new long[n];
		int h = (int)(Math.ceil(Math.log(n)/Math.log(2)));
		tree = new long[1<<(h+1)];
		lazy= new long[1<<(h+1)];
		for (int i = 0; i < n; i++) {
			long input = Long.valueOf(br.readLine());
			a[i] = input;
		}
		init(0,n-1,1);
//		System.out.println(Arrays.toString(tree));
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.valueOf(st.nextToken());
			if(a == 1) {
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				long d = Long.valueOf(st.nextToken());
				update(0,n-1,1,b-1,c-1,d);
			}else {
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				System.out.println(search(0,n-1,1,b-1,c-1));
			}
//			System.out.println(Arrays.toString(tree));
		}
	}
	private static long search(int start, int end,int node, int left, int right) {
		update_lazy(node,start,end);
		if(right<start||end<left)return 0;
		if(start>=left && right >=end)return tree[node];
		long a = search(start, (start+end)/2, 2*node, left, right);
		long b = search((start+end)/2+1,end, 2*node+1, left, right);
		return a+b;
	}
	private static void update(int start, int end, int node, int left, int right, long value) {
		update_lazy(node,start,end);
		if(end<left || right<start) return;
		if(left<=start&&end<=right) {
			tree[node] += (end-start+1)*value;
			if(start != end) {
				lazy[node *2] += value;
				lazy[node *2+1] += value;
			}
			return;
		}
		update(start, (start+end)/2, 2*node, left, right, value);
		update((start+end)/2+1,end, 2*node+1, left, right, value);
		tree[node] = tree[node*2]+tree[2*node+1];
	}
	private static void update_lazy(int node, int start, int end) {
		if(lazy[node] == 0)return;
		tree[node] += (end-start+1)*lazy[node];
		if(start != end) {
			lazy[2*node] +=lazy[node];
			lazy[2*node+1] += lazy[node];
		}
		lazy[node] = 0;
	}
	private static void init(int start, int end, int node) {
		if(start == end) {
			tree[node] = a[start];
			return;
		}
		init(start, (start+end)/2, 2*node);
		init((start+end)/2+1,end, 2*node+1);
		tree[node] = tree[2*node]+tree[2*node+1];
	}

}
