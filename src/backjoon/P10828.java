package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if(input.equals("push")) {
				stack.add(Integer.valueOf(st.nextToken()));
			}else if(input.equals("pop")) {
				System.out.println(stack.size()>0?stack.pop():-1);
			}else if(input.equals("size")) {
				System.out.println(stack.size());
			}else if(input.equals("empty")) {
				System.out.println(stack.isEmpty()?1:0);
			}else if(input.equals("top")) {
				System.out.println(stack.size()>0?stack.peek():-1);
			}
		}
	}

}
