package com.day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호 짝짓기
public class SWEA_1218 {
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			flag = true;
//			int n = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			for (Character chr : br.readLine().toCharArray()) {
//				System.out.print(chr);
				if (chr == ')' || chr == '}' || chr == ']'|| chr == '>') {
//					System.out.println(stack.peek());
					if ((stack.peek() == '(' && chr == ')') || (stack.peek() == '[' && chr == ']') || (stack.peek() == '{' && chr == '}') || (stack.peek() == '<' && chr == '>')) {
						stack.pop();
					}else {
						flag = false;
						break;
					}
				}else {
					stack.push(chr);
				}
//				System.out.println(stack);
			}
			if (flag) {
				System.out.println("#"+i+" "+'1');
			}else {
				System.out.println("#"+i+" "+'0');
			}
			
		}
	}

}
