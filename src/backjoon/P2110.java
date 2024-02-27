package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
	static int n,c;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			int input = Integer.valueOf(br.readLine());
			arr[i] = input;
		}
		Arrays.sort(arr);
		int left = 1;
		int right = arr[n-1];
		int mid = 0 ;
		int answer = 0;
		while (right>=left) {
			mid = (right+left)/2;
			int result = count(mid);
			if(result >= c) {
				left = mid+1;
				answer = Math.max(answer, mid);
			}else {
				right = mid;
			}
			System.out.println("left : "+left+" right :  "+right);
		}
		System.out.println(answer);
	}
	private static int count(int mid) {
		int cnt = 1;
		int a = arr[0];
		for (int i = 1; i < n; i++) {
			if(arr[i]-a>=mid) {
				cnt++;
				a = arr[i];
			}
		}
		return cnt;
	}

}
