package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1517 {
	/** 
	 * 버블 소트 
	 * https://www.acmicpc.net/problem/1517
	 * **/
	static long answer = 0;
	static long[] arr,temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		arr = new long[n];
		temp = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		divide(0,n-1);
		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}

	private static void divide(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			divide(left, mid);
			divide(mid+1, right);
			merge(left,right,mid);
		}
	}

	private static void merge(int left, int right, int i) {
		int leftFirst = left;
		int rightFirst = i+1;
		int index = left;
//		System.out.println("left : "+left+" right : "+right+" mid "+ i);
		while (leftFirst<= i && rightFirst<= right) {
			if (arr[leftFirst] <= arr[rightFirst]) {
				temp[index] = arr[leftFirst];
				leftFirst++;
			}else {
				temp[index] = arr[rightFirst];
				rightFirst++;
				answer +=i - leftFirst+1;
			}
			index++;
		}
		while (leftFirst <= i) {
			temp[index] = arr[leftFirst];
			leftFirst++;
			index++;
		}
		while (rightFirst<=right) {
			temp[index] = arr[rightFirst];
			rightFirst++;
			index++;
		}
		for (int u = left; u < right+1; u++) {
			arr[u] = temp[u];
		}
	}

}
