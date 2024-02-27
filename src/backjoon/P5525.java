package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5525 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int len = Integer.valueOf(br.readLine());
		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("IO");
		}
		sb.append("I");
		str = sb.toString();
		String rep = br.readLine();
		int result = 0;
		for (int i = 0; i <= rep.length()-str.length(); i++) {
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				if(rep.charAt(i+j) != str.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				result++;
//				System.out.println(i+"  hit");
			}
		}
//		System.out.println(str);
//		System.out.println(rep);
		System.out.println(result);
	}

}
