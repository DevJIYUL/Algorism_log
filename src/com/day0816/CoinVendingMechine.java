package com.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinVendingMechine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		int targetMoney = Integer.parseInt(st.nextToken());
		int[] units = {500,100,50,10,5,1};
		st = new StringTokenizer(br.readLine().trim());
		int[] counts = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		int totalMoney = 0;
		for (int i = 0; i < counts.length; i++) {
			totalMoney += counts[i]*units[i];
		}
		int remainMoney = totalMoney- targetMoney;
		
		int sum = 0,maxCnt,availCnt;
		for (int i = 0; i < units.length; i++) { // 가장 큰 화폐 단위부터 많이 사용하도록
			maxCnt = remainMoney/units[i]; // 해당 금액을 i 화폐단위를 가장 많이 쓸때의 개수
			availCnt = maxCnt<=counts[i] ? maxCnt:counts[i];
			counts[i] -= availCnt;
			remainMoney -= availCnt * units[i];
			sum += counts[i];
		}
		System.out.println(sum);
		for (int i = 0,size=counts.length; i < size; i++) {
			System.out.print(counts[i]+" ");
		}
	}

}
