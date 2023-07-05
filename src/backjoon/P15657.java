package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15657 {
	static int n,m;
	static int[] arr,rep;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n];
		rep  = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		cal(0,0);
	}
	private static void cal(int i, int count) {
		if(count == m) {
//			System.out.println(Arrays.toString(rep));
			print(rep);
			return;
		}
		for (int j = i; j < arr.length; j++) {
			rep[count] = arr[j];
			cal(j,count+1);
		}
	}
	private static void print(int[] rep2) {
		for (int i = 0; i < rep2.length; i++) {
			System.out.print(rep2[i]+" ");
		}
		System.out.println();
	}

}
