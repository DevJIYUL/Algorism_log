package com.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임
public class SWEA_6808 {
	static int[] kyuO, inO, number;
	static int win, lose;
	static boolean[] card, visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_cast = Integer.parseInt(br.readLine());
		for (int i = 1; i <= test_cast; i++) {
			kyuO = new int[9];
			inO = new int[9];
			number = new int[9];
			card = new boolean[19];
			visited = new boolean[9];
			win = 0;
			lose = 0;
			int index = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				kyuO[j] = Integer.parseInt(st.nextToken());
				card[kyuO[j]] = true;
			}
			for (int j = 1; j < 19; j++) {
				if (!card[j]) {
					inO[index++] = j;
				}
			}

//			System.out.println(Arrays.toString(kyuO));
//			System.out.println(Arrays.toString(inO));
//			System.out.println(Arrays.toString(visited));
//			System.out.println("-----------------------");
			per(0);
			System.out.println("#" + i + " " + lose + " " + win);
		}
	}

	private static void per(int count) {
		if (count == 9) {
//			System.out.println(Arrays.toString(number));
//			System.out.println(Arrays.toString(kyuO));
			int kyu = 0;
			int inn = 0;
			for (int i = 0; i < 9; i++) {
				if (number[i] > kyuO[i]) {
					inn += number[i] + kyuO[i];
				} else if (number[i] < kyuO[i]) {
					kyu += number[i] + kyuO[i];
				} 
			}
			if (kyu > inn) {
				lose += 1;
			} else if (kyu < inn) {
				win += 1;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			number[count] = inO[i];
			visited[i] = true;
			per(count + 1);
			visited[i] = false;

		}
	}
}
