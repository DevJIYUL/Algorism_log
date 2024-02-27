package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2243 {
	static long[] a,tree;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		int size = 0;
		int maxSize = 1;
		while (maxSize<1000001) {
			maxSize *= 2;
			size++;
		}
		tree = new long[1<<(1+size)+1];
//		System.out.println(1<<(1+size)+);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			if(a==1) {
				int b = Integer.valueOf(st.nextToken());
				System.out.println(search(1,1000001,1,b));
//				System.out.println("a : "+a+" b :"+b);
			}else {
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				insert(1,1000001,1,b,c);
//				System.out.println("a : "+a+" b :"+b+" c : "+c);
			}
			for (int q = 0; q < 100; q++) {
//				System.out.print(tree[q]+" ");
			}
//			System.out.println();
		}
	}
	private static long search(int start, int end, int node, int target) {
//		System.out.println(start + " "+ end+" "+node+" "+target);
		if(start == end) {
//			tree[node]--;
			insert(1, 1000001, 1, start, -1);
			return start;
		}
			
		long l = tree[2*node];
		long r = tree[2*node+1];
//		System.out.println(l+ " "+ r);
		if(target<=l) {
			return search(start, (start+end)/2, 2*node, target);
		}else {
			return search((start+end)/2+1, end, 2*node+1, (int) (target-l));
		}
//		tree[node] = tree[2*node]+tree[2*node+1];
//		return 0;
	}
	private static void insert(int start, int end, int node, int index, int value) {
		if(start>index || end<index) return;
//		System.out.println(start + " "+end+" "+node+" "+index);
		if(start == end) {
			tree[node]+= value;
			return;
		}
		insert(start, (start+end)/2, 2*node, index, value);
		insert((start+end)/2+1,end, 2*node+1, index, value);
		tree[node] = tree[2*node] + tree[2*node+1];
	}

}
