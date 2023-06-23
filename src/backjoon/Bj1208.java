package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj1208 {
	static int n , s;
	static long count ;
	static int[] left,right;
	static ArrayList<Integer> canLeft, canRight;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		s = Integer.valueOf(st.nextToken());
		if(n % 2 == 0) {
			left = new int[n/2];
			right = new int[n/2];
		}else {
			left = new int[n/2];
			right = new int[n/2+1];
		}
		canLeft = new ArrayList<>();
		canRight = new ArrayList<>();
//		canLeft.add(0);
//		canRight.add(0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < left.length; i++) {
			left[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = Integer.valueOf(st.nextToken());
		}
//		System.out.println(Arrays.toString(left));
//		System.out.println(Arrays.toString(right));
		
		binary(0,left.length,0,left,canLeft);
		binary(0, right.length, 0, right, canRight);
		Collections.sort(canLeft);
		Collections.sort(canRight);
//		for (int i = 10; i > -1; i--) {
//			System.out.println(i);
//		}
//		System.out.println(canLeft);
//		System.out.println(canRight);
		int start =0, end = canRight.size()-1;
		while (start < canLeft.size() && end >= 0) {
//			System.out.println("start : "+start + " end : "+ end);
			int temp = canLeft.get(start);
			int m = canRight.get(end);
			if(temp+m < s) {
				start++;
			}else if(temp+m>s){
				end--;
			}else if(temp + m == s) {
				long a=0,b=0;
				for (int j = end; j > -1; j--) {
					if(temp+canRight.get(j) == s) {
						end--;
						a++;
//						System.out.println("temp : "+temp + " 대상 : "+ canRight.get(j));
					}
					else break;
				}
				for (int j = start; j < canLeft.size(); j++) {
					if(canLeft.get(j)+m == s) {
//						System.out.println("temp : "+temp+ " 댕상 : "+ canLeft.get(j));
						b++;
						start++;
					}
					else break;
				}
				count += a*b;
			}
		}
		
		System.out.println(s==0?count-1:count);
	}
	private static void binary(int i, int length, int j, int[] arr, ArrayList<Integer> can) {
		if(i == length) {
			can.add(j);
			return;
		}
		binary(i+1, length, j+arr[i],arr,can);
		binary(i+1, length, j, arr,can);
	}

}
