package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P3020 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
//		int a[] = new int[100000];
//		int b[] = new int[100000];
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		int aIndex=0,bIndex = 0;
		for (int i = 0; i < n; i++) {
			int input = Integer.valueOf(br.readLine());
			if(i%2==0) {
				a.add(input);
			}else {
				b.add(input);
			}
		}
		Collections.sort(a);
		Collections.sort(b);
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(binary(b, b.size()-1, m-1+1));
//		System.out.println(binary(b, b.size()-1, m-2+1));
//		System.out.println(binary(b, b.size()-1, m-3+1));
//		System.out.println(binary(b, b.size()-1, m-4+1));
		int[] answer = new int[] {Integer.MAX_VALUE,0};
		for (int i = 1; i <= m; i++) {
			int count = 0;
			count += a.size() - binary(a,a.size()-1,i);
//			System.out.println("count : "+count);
			count += b.size() - binary(b,b.size()-1, m-i+1);
//			System.out.println("count : "+count);
			if(answer[0] > count) {
				answer = new int[] {count,1};
			}else if(answer[0] == count) {
				answer[1]++;
			}
		}
		System.out.println(answer[0]+" "+answer[1]);
	}

	private static int binary(ArrayList<Integer> arr,int high, int i) {
//		System.out.println("목 표 : "+i);
		int low = 0;
		int result = arr.size();
		while (high>=low) {
			int mid = (high+low)/2;
//			System.out.println("mid : "+mid+" "+arr.get(mid));
			if(arr.get(mid)>=i) {
				high = mid-1;
				result = mid;
			}else {
				low = mid+1;
			}
		}
		return result;
	}

}
