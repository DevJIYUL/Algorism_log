package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1275 {
	static int n,m;
	static long[] arr,tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new long[n];
		int size = (int)Math.ceil(Math.log(n)/Math.log(2));
		tree = new long[(1<<(size+1))];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		init(0,n-1,1);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(tree));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			if(x>y) {
				int temp = x;
				x = y;
				y = temp;
			}
			System.out.println(quary(0,n-1,x-1,y-1,1));
			arr[a-1] = b;
			update(0,n-1,1,a-1,b);
		}
	}
	private static void update(int start, int end, int node, int index, int value) {
		if(index<start || index>end)return;
		if(start == end) {
			if(start == index) tree[node] = arr[start];
			return;
		}
		update(start, (start+end)/2, 2*node, index, value);
		update((start+end)/2+1,end, 2*node+1, index, value);
		tree[node] = tree[node*2]+tree[node*2+1];
	}
	private static long quary(int start, int end, int left, int right, int node) {
		if(left <= start && end <= right)return tree[node];
		else if(right < start || end < left)return 0;
		long l = quary(start, (start+end)/2, left, right, 2*node);
		long r = quary((start+end)/2+1,end, left, right, 2*node+1);
		return l+r;
	}
	private static void init(int start, int end, int node) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		init(start,(start+end)/2,2*node);
		init((start+end)/2+1,end,2*node+1);
		tree[node] = tree[node*2]+tree[node*2+1];
	}

}
