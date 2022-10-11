package com.day1010;
// 슬라이딩 윈도우 : 고정된 크기의 윈도우를 이동시키면서 윈도우 안의 데이터를 이용해 문제를 푸는 알고리즘 기법
// 배열이나 리스트의 요소에 대해 일정 범위를 지정해 작업할때 사용됨.
public class SlidingWindowTest {

	public static void main(String[] args) {
		int[] input = {3,1,5,6,4,8,2,3,7,1};
		int n = 3;// 윈도우 크기
		int max= 0;
		int left = 0;
		int right = n;
		int sum= 0;
		for (int i = 0; i < n; i++) {
			sum+= input[i];
		}
		max = sum;
		while (right < input.length) {
			sum = sum - input[left];
			sum = sum + input[right];
			if(sum>max)max = sum;
		}
	}

}
