package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1107 {
	static int result;
	static String target,now;
//	static HashSet<String> controller = new HashSet<>(Arrays.asList("1","2","3","4","5","6","7","8","9","0"));
	static boolean[] controller = new boolean[10];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();
		int n = Integer.valueOf(br.readLine());
		if(n != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				controller[Integer.valueOf(st.nextToken())] = true;
			}			
		}

		result = Math.abs(Integer.valueOf(target)-100);

		for (int i = 0; i < 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			boolean flag = false;
			for (int j = 0; j < len; j++) {
				if(controller[str.charAt(j)-'0']) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				result = Math.min(result, Math.abs(Integer.valueOf(target)-i)+len);
			}
		}

		System.out.println(result);
	}

}
