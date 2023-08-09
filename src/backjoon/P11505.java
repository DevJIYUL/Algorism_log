package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11505 {
	static int n,m,k;
	static long[] a, tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		a = new long[n];
		tree = new long[1<<((int)Math.ceil(Math.log(n)/Math.log(2))+1)];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		init(1,0,n-1);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(tree));
		int aa,b,c;
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			aa = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			c = Integer.valueOf(st.nextToken());
			if(aa == 1) {
				update(b-1,c,1,0,n-1);
//				System.out.println("----------------------");
//				System.out.println(Arrays.toString(a));
//				System.out.println(Arrays.toString(tree));
			}else {
				System.out.println(quary(1,0,n-1,b-1,c-1));
			}
		}
	}
	private static long quary(int node, int start, int end, int left, int right) {
		if(left<=start && end<=right)return tree[node];
		if(right<start || end < left) return 1;
		long l = quary(2*node, start, (start+end)/2, left, right);
		long r = quary(2*node+1, (start+end)/2+1,end, left, right);
		return l*r%1000000007;
	}
	private static void update(int index, int value, int node, int start, int end) {
		if(index<start||index>end) return;
		else if(start == end) {
			a[index]=value;
			tree[node]=value;
			return;
		}
		update(index, value, 2*node, start, (start+end)/2);
		update(index, value, 2*node+1, (start+end)/2+1,end);
		tree[node] = tree[2*node]*tree[2*node+1]%1000000007;
	}
	private static void init(int node, int start, int end) {
		if(start == end) tree[node] = a[start];
		else {
			init(2*node,start,(start+end)/2);
			init(2*node+1,(start+end)/2+1,end);
			tree[node] = tree[2*node]*tree[2*node+1]%1000000007;
		}
		
	}

}
