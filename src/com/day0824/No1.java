package com.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1 {
	static int test_case, n, answer;
	static int[] fishPlace, input, fishGatePermutate;
	static boolean[] fishGateVisted;
	static HashMap<Integer, Integer> gate;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		test_case = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= test_case; i++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			gate = new HashMap<>();
			answer = Integer.MAX_VALUE;
			fishGateVisted = new boolean[n];
			input = new int[3];
			fishGatePermutate = new int[3];
			for (int j = 0; j < 3; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				gate.put(key, value);
				input[j] = key;
			}
			System.out.println(gate);
			permutate(0);
			
			System.out.println("#"+i+" "+answer);
		}
	}

	private static void permutate(int count) {
		if (count == 3) {
			System.out.println(Arrays.toString(fishGatePermutate));
			fishPlace = new int[n+1];
			cal(fishGatePermutate,fishPlace,0);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (fishGateVisted[i]) {
				continue;
			}
			fishGatePermutate[count] = input[i];
			fishGateVisted[i] = true;
			permutate(count + 1);
			fishGateVisted[i] = false;
		}
	}
	// 재귀
	private static void cal(int[] fishGatePermutate, int[] fishPlace,int g) {
		System.out.println(Arrays.toString(fishGatePermutate)+" "+Arrays.toString(fishPlace)+" "+g);
		if(g == 3) {
			System.out.println(Arrays.toString(fishPlace));
			int sum =0;
			for (int i = 0; i < fishPlace.length; i++) {
				sum+= fishPlace[i];
			}
			answer = Math.min(answer, sum);
			return ;
		}
		System.out.println(Arrays.toString(fishPlace));
		for (int i = 0; i < gate.get(fishGatePermutate[g]); i++) {
			// 최단거리 좌표
			ArrayList<Integer> min = new ArrayList<>();
			int value = Integer.MAX_VALUE;
			for (int k = 1; k < fishPlace.length; k++) {
				if ((value >= Math.abs(fishGatePermutate[g]-k)+1) && fishPlace[k] == 0) {
					value = Math.min(value, Math.abs(g-k)+1);
					min.add(k);
				}
			}
			if(min.size() == 0) continue;
			if(i == gate.get(fishGatePermutate[g])-1) {
				if(min.size()>1) {
					for (int k = 0; k < min.size(); k++) {
						fishPlace[min.get(k)] = value;
						cal(fishGatePermutate,fishPlace,g+1);
						fishPlace[min.get(k)] = 0;
					}
				}else {
					fishPlace[min.get(0)] = value;
					cal(fishGatePermutate,fishPlace,g+1);
					fishPlace[min.get(0)] = 0;
				}
			}else {
				fishPlace[min.get(0)] = value;
			}
		}	
	}
}
