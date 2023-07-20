package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.valueOf(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cal(st.nextToken(),st.nextToken());
		}
	}
	static boolean[] visited;
	private static void cal(String a, String b) {
		a = transform(a);
		b = transform(b);
//		System.out.println("a : "+ a+" b :"+ b);
		visited = new boolean[10000];
		Queue<String[]> queue = new LinkedList<String[]>();
		visited[Integer.valueOf(a)] = true;
		queue.add(new String[] {a,""});
		int index = 0;
		while (!queue.isEmpty()) {
			String[] temp = queue.poll();
//			if(index++ == 20) break;
//			System.out.println(Integer.valueOf(b)+" "+Integer.valueOf(temp[0])+" ");
//			System.out.println(b.equals(Integer.valueOf(temp[0])+""));
			if(b.equals(temp[0])) {
				System.out.println(temp[1]);
				break;
			}
			String D = D(temp[0]);
			String S = S(temp[0]);
			String L = L(temp[0]);
			String R = R(temp[0]);
			if(b.equals(D)) {
				System.out.println(temp[1]+"D");
				break;
			}
			if(b.equals(S)) {
				System.out.println(temp[1]+"S");
				break;
			}
			if(b.equals(L)) {
				System.out.println(temp[1]+"L");
				break;
			}
			if(b.equals(R)) {
				System.out.println(temp[1]+"R");
				break;
			}
			if(!visited[Integer.valueOf(D)]) {
				visited[Integer.valueOf(D)] = true;
				queue.add(new String[] {D,temp[1]+"D"});
			}
			if(!visited[Integer.valueOf(S)]) {
				visited[Integer.valueOf(S)] = true;
				queue.add(new String[] {S,temp[1]+"S"});
			}
			if(!visited[Integer.valueOf(L)]) {
				visited[Integer.valueOf(L)] = true;
				queue.add(new String[] {L,temp[1]+"L"});
			}
			if(!visited[Integer.valueOf(R)]) {
				visited[Integer.valueOf(R)] = true;
				queue.add(new String[] {R,temp[1]+"R"});
			}
//			System.out.println("D : "+D);
//			System.out.println("S : "+S);
//			System.out.println("L : "+L);
//			System.out.println("R : "+R);
		}
	}
	private static String transform(String b) {
		int size = b.length();
		for (int i = 0; i < 4-size; i++) {
			b = "0"+b;
		}
		return b;
	}
	private static String R(String string) {
		string = string.charAt(string.length()-1)+string;
		return string.substring(0, string.length()-1);
	}
	private static String L(String string) {
		string = string+string.charAt(0);
		return string.substring(1);
	}
	private static String S(String string) {
		int temp = Integer.valueOf(string);
		return temp==0?"9999":transform((temp-1)+"");
	}
	private static String D(String string) {
		int temp = Integer.valueOf(string)*2%10000;
		
		return transform(temp+"");
	}

}
