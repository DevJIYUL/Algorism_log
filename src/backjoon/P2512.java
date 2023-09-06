package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2512 {
	static int n,target,result;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int left = 1,right = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
//			left = Math.min(arr[i], left);
			right = Math.max(arr[i], right);
		}
		st = new StringTokenizer(br.readLine());
		target = Integer.valueOf(st.nextToken());
		while (left<=right) {
			int mid = (left+right)/2;
			int temp = 0;
			for (int i = 0; i < n; i++) {
				if(arr[i]<=mid) {
					temp+=arr[i];
				}else {
					temp += mid;
				}
			}
			if(temp<=target) {
				result = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
			System.out.println(left+" "+right);
		}
		System.out.println(result);

	}

}
