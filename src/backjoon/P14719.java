package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14719 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		int answer = 0;
		ArrayList<Integer> list;
		for (int i = 1; i <= n; i++) {
			boolean flag = false;
			list = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				if(arr[j] >= i) {
					flag = true;
					answer += list.size();
					list.clear();
				}
				if(flag && arr[j]<i) {
					list.add(j);
				}
//				for (int k = 0; k < list.size(); k++) {
//					System.out.print(list.get(k)+" ");
//				}
			}
//			System.out.println();
		}
		System.out.println(answer);
	}

}
