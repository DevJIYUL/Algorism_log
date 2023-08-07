package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10868 {
	static int n,m;
	static long[] a,tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.valueOf(st.nextToken());
		m= Integer.valueOf(st.nextToken());
		a = new long[n];
		tree = new long[1<<1+(int)Math.ceil(Math.log(n)/Math.log(2))];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		init(a,tree,1,0,n-1);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(tree));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			Long result  = quary(tree,1,0,n-1,a-1,b-1);
			System.out.println(result);
		}
	}
	private static Long quary(long[] tree2, int node, int start, int end, int left, int right) {
		if(left<=start && end <= right) return tree[node];
		else if(start>right || end<left) return Long.MAX_VALUE;
		Long l = quary(tree2, node*2, start, (start+end)/2, left, right);
		Long r = quary(tree2, node*2+1,(start+end)/2+1,end, left, right);
		return Math.min(l, r);
	}
	private static void init(long[] a2, long[] tree2, int node, int start, int end) {
		if(start == end) tree2[node] = a2[start];
		else{
			init(a2,tree2,node*2,start,(start+end)/2);
			init(a2,tree2,node*2+1,(start+end)/2+1,end);
			tree2[node] = Math.min(tree2[node*2], tree2[node*2+1]);
		}
		
	}

}
