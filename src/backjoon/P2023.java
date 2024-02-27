package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2023 {
	static class Node{
		String num;
		int count;
		public Node(String num,int count) {
			this.num = num;
			this.count = count;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		cal("",n);
		System.out.println(sb);
	}
	private static void cal(String string, int n) {
		if(n==0) {
			if(prime(Integer.valueOf(string))) {
//				System.out.println(string);
				sb.append(string).append("\n");
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			int t = Integer.valueOf(string+i);
			if(prime(t))cal(t+"", n-1);
		}
	}
	private static boolean prime(int n) {
		if(n < 2)return false;
		for (int i = 2; i < n; i++) {
			if(n%i == 0)return false;
		}
		return true;
	}

}
