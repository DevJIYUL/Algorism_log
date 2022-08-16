package com.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int result = 0;
		ArrayList<int[]> arrlst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			arrlst.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		arrlst.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] != o2[1] ? o1[1]-o2[1] : o1[0] - o2[0];
			}
		});
		int last = arrlst.get(0)[1];
		result++;
		for (int i = 1; i < arrlst.size(); i++) {
			if (!(arrlst.get(i)[0] <= last && last <= arrlst.get(i)[1])) {
				last = arrlst.get(i)[1];
				result++;
			}
		}
		System.out.println(result);
	}

}
