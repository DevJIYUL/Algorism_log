package com.day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_flatten {
	static int[] recur(int d,int[] b,int count) {
		int max = 0;
		int min = 99;
		for (int i = 0; i < b.length; i++) {
			if (b[i] > b[max]) {
				max = i;
			}else if (b[i] < b[min]) {
				min = i;
			}
		}
		if (count == d) {
//			System.out.println(count+" 도착 ");
			return new int[] {min,max};
		}
		b[max] -= 1;
		b[min] += 1;
		return recur(d,b,count+1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			for (int j = 0; j < box.length; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
			int[] result = recur(dump,box,0);
			System.out.println("#"+i+" "+(box[result[1]]-box[result[0]]));
			
		}

	}

}
