package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14002 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		int result = 0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
					result = Math.max(dp[i], result);
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		System.out.println(result);
		for (int i = n; i >= 1; i--) {
			if(dp[i] == result) {
				stack.add(arr[i]);
				result--;
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(stack);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
