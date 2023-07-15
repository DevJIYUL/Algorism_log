package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6549 {
	static int[] a,tree;
	static int e;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			e = Integer.valueOf(st.nextToken());
			if(e == 0)break;
			a = new int[e];
			for (int i = 0; i < e; i++) {
				a[i] = Integer.valueOf(st.nextToken());
			}
			tree = new int[(1<<(1+(int) Math.ceil(Math.log(e)/Math.log(2))))];
			init(a,tree,1,0,e-1);

			System.out.println(getmax(0,e-1));
		}
	}
	private static long getmax(int i, int j) {
		long maxresult,temp;
		int minindex = quary(tree, 1, 0, e-1, i, j);
		maxresult = (long)(j-i+1)*(long)a[minindex];
//		System.out.println("maxresult : "+maxresult+" min index : "+minindex);
		if(i<minindex) {
			temp = getmax(i, minindex-1);
			maxresult = Math.max(maxresult, temp);
		}
		if(j>minindex) {
			temp = getmax(minindex+1, j);
			maxresult = Math.max(maxresult, temp);
		}
		return maxresult;
	}
	private static int quary(int[] tree, int node, int start, int end, int left, int right) {
		if(end<left||right<start) return 2000000000;
		if(end<=right && start>= left) return tree[node];
//		if(end==right && start== left) return tree[node];
//		System.out.println("start : "+start+" end : "+end);
		int l = quary(tree, node*2, start, (start + end)/2, left, right);
		int r = quary(tree, node*2+1, (start + end)/2+1,end, left, right);
//		System.out.println("left : "+l+" right : "+r);
		if(l == 2000000000)return r;
		else if(r == 2000000000) return l;
		else return a[l]<a[r]?l:r;
	}
	private static int init(int[] a, int[] tree, int node, int start, int end) {
		if(start == end) return tree[node] = start;
		else {
			int lindex = init(a,tree,node*2,start,(start+end)/2);
			int rindex = init(a,tree,node*2+1,(start+end)/2+1,end);
			return tree[node] = a[lindex]<a[rindex]?lindex:rindex;
		}	
	}
	
	
}
