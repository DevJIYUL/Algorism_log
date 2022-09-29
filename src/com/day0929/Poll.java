package com.day0929;

import java.util.Arrays;

public class Poll {
	static int[] dp;
	public static void main(String[] args) {
		dp = new int[7];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1]+dp[i-1]+dp[i-2];
		}
		System.out.println(Arrays.toString(dp));
	}

}
