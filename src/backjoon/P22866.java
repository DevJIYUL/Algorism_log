package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P22866 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] height = new int[n+1];
		int[] near = new int[n+1];
		int[] num = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			height[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.fill(near, -100000);
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < n+1; i++) {
			while (!stack.isEmpty()&&height[stack.peek()] <= height[i]) {
				stack.pop();
			}
			num[i] += stack.size();
			if(num[i]>0) near[i] = stack.peek();
			stack.push(i);
			System.out.println("i : "+i+ " stack : "+stack+ " peek : "+stack.peek());
			System.out.println("num : "+Arrays.toString(num));
			System.out.println("near : "+Arrays.toString(near));
		}
		stack.clear();
		for (int i = n; i > 0; i--) {
			while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				stack.pop();
			}
			num[i] += stack.size();
			if(stack.size()>0 && stack.peek() -i < i - near[i]) near[i] = stack.peek();
			stack.push(i);
			System.out.println("i : "+i+ " stack : "+stack+ " peek : "+stack.peek());
			System.out.println("num : "+Arrays.toString(num));
			System.out.println("near : "+Arrays.toString(near));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			sb.append(num[i]);
			if(num[i] != 0) {
				sb.append(" "+near[i]+"\n");
			}else {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
