package com.day0929;

import java.util.Arrays;

public class AptPaint {
	static int[] dp;
	public static void main(String[] args) {
		dp = new int[8];
		dp[0] = 2;
		dp[1] = 3;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[dp.length-1]);
	}

}
