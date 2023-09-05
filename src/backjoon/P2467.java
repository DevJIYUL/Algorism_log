package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2467 {
	static int n,left,right,result = Integer.MAX_VALUE;
	static int[] liq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		liq = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			liq[i] = Integer.valueOf(st.nextToken());
		}
		right = n-1;
		int a=0,b=0;
		while (left < right) {
			if(Math.abs(liq[left]+liq[right]) < result) {
				a = liq[left];b=liq[right];
				result = Math.abs(liq[left]+liq[right]);
			}
			if(liq[left]+liq[right]>0) {
				right--;
			}else if(liq[left]+liq[right]<=0) {
				left++;
			}
		}
		System.out.println(a+" "+b);
	}

}
