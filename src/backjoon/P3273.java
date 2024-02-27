package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.valueOf(st.nextToken());
		int count = 0;
		Arrays.sort(arr);
		int left = 0, right = n-1;
		while (left < right) {
			if(arr[left]+arr[right] == x) {
				count++;
				left++;
			}else if(arr[left]+arr[right] >x) {
				right--;
			}else if(arr[left] + arr[right]<x) {
				left++;
			}
		}
		System.out.println(count);

	}

}
