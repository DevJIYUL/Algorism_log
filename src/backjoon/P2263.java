package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263 {
	static int[] in,post;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		in = new int[n];
		post = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in[i] = Integer.valueOf(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			post[i] = Integer.valueOf(st.nextToken());
		}
		
		print(0,n-1,0,n-1);
	}

	private static void print(int l, int r, int pl, int pr) {
		if(pl>pr||pl<0||pr==n)return;
		int head = post[pr];
		System.out.print(head+" ");
		int index=0;
		for (int i = 0; i < in.length; i++) {
			if(in[i] == head) {
				index = i;
				break;
			}
		}
		print(l,index-1,pl,pl+index-l-1);
		print(index+1,r,pl+index-l,pl+r);
	}

}
