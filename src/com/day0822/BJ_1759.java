package com.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기
public class BJ_1759 {
	static int l,c;
	static char[] alpha;
	static int[] combi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		alpha = new char[c];
		combi = new int[l];
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		combinate(0,0);
	}
	private static void combinate(int index, int count) {
		if (count == l) {
//			System.out.println(Arrays.toString(combi));
			String str = "";
			boolean flag = false;
			int son = 0;
			for (int c : combi) {
				str+=alpha[c]+"";
				if (alpha[c] == 'a'||alpha[c] == 'e'||alpha[c] == 'o'||alpha[c] == 'u'||alpha[c] == 'i') {
					flag = true;
					continue;
				}
				son++;
			}
			if (flag&&son >= 2) {
				System.out.println(str);
			}
			return;
		}
		for (int i = index; i < c; i++) {
			combi[count] = i;
			combinate(i+1,count+1);
		}
	}

}
