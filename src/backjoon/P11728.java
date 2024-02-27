package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {
	static int n,m;
	static int[] a,b;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		a = new int[n];
		b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.valueOf(st.nextToken());
		}
		int[] arr = new int[n+m];
		int index = 0,ai=0,bi=0;
		StringBuilder sb = new StringBuilder();
		while (ai != n || bi != m) {
			if(ai == n) {
				sb.append(b[bi++]+" ");
				continue;
			}else if(bi == m) {
				sb.append(a[ai++]+" ");
				continue;
			}
			if(a[ai]<b[bi]) {
				sb.append(a[ai++]+" ");
			}else {
				sb.append(b[bi++]+" ");
			}
		}
		System.out.println(sb);
	}

}
