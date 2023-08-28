package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
	static int n,m,sum,result=Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			sum+= arr[i];
		}
		result = Math.max(result, sum);
		for (int i = 0; i < n-m; i++) {
			sum-=arr[i];
			sum+=arr[i+m];
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}

}
