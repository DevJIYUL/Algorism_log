package com.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최적경로
public class SWEA_1247_Greeeedy {
	static int test_case,cusNum,answer;
	static int[] home,company,reservation;
	static boolean[] visited;
	static int[][] customer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			answer = Integer.MAX_VALUE;
			home = new int[2];
			company = new int[2];
			st = new StringTokenizer(br.readLine().trim());
			cusNum = Integer.parseInt(st.nextToken());
			customer = new int[2][cusNum];
			reservation = new int[cusNum];
			visited= new boolean[cusNum];
			st = new StringTokenizer(br.readLine().trim());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cusNum; j++) {
				customer[0][j] = Integer.parseInt(st.nextToken());
				customer[1][j] = Integer.parseInt(st.nextToken());
			}
			per(0);
			System.out.println("#"+i+" "+answer);
		}
	}
	private static void per(int count) {
		if (count == cusNum) {
			answer = Math.min(answer, cal(reservation));
			return;
		}
		for (int i = 0; i < cusNum; i++) {
			if (visited[i]) {
				continue;
			}
			reservation[count] = i;
			visited[i] = true;
			per(count+1);
			visited[i] = false;
		}
		
	}
	private static int cal(int[] reservation2) {
		int value = Math.abs(company[0]-customer[0][reservation2[0]])+Math.abs(company[1]-customer[1][reservation2[0]]);
		for (int i = 0; i < reservation2.length-1; i++) {
			value += Math.abs(customer[0][reservation2[i]]-customer[0][reservation2[i+1]])+Math.abs(customer[1][reservation2[i]]-customer[1][reservation2[i+1]]);
		}
		value += Math.abs(home[0]-customer[0][reservation2[reservation2.length-1]])+Math.abs(home[1]-customer[1][reservation2[reservation2.length-1]]);
		return value;
	}
	

}
