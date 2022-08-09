package com.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사칙연산 유효성 검사
public class SWEA_1233 {
	static boolean flag;
	static int num,left,right;
	static char command,leaf;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			flag = true;
			StringTokenizer st;
			int size = Integer.parseInt(br.readLine());
			int maxSize = 1;
			for (int j = 1; j <= 8; j++) {
				maxSize *= 2;
				if (maxSize >= size) {
					break;
				}
			}
			int maldan = (int) (maxSize/2 -Math.round(((maxSize - size)/2)+0.5)+1);
//			System.out.println(maldan);
//			System.out.println(Math.round(((maxSize - size)/2)+0.5));
//			System.out.println("maxsize : "+maxSize);
			
			for (int j = 1; j < maldan; j++) {
				st = new StringTokenizer(br.readLine());
				if (!flag) continue;
				num = Integer.parseInt(st.nextToken());
				command = st.nextToken().charAt(0);
				left = Integer.parseInt(st.nextToken());
				right = Integer.parseInt(st.nextToken());
//				System.out.println("num : "+num+" command :"+command+" left :"+left+" right:"+right);
				if (Character.isDigit(command)) {
					flag = false;
				}
			}
			for (int j = maldan; j <= size; j++) {
				st = new StringTokenizer(br.readLine());
				if (!flag) continue;
				num = Integer.parseInt(st.nextToken());
				leaf = st.nextToken().charAt(0);
//				System.out.println("num :"+num+" leaf:"+leaf);
				if (!Character.isDigit(leaf)) {
					flag = false;
				}

			}
			System.out.print("#"+i+" ");
			if (flag) {
				System.out.print(1);
			}else {
				System.out.print(0);
			}
			System.out.println();
		}
	}
}
