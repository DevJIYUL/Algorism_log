package com.day0819;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2};
		ArrayList<int[]> arrlst = new ArrayList<>();
		arrlst.add(new int[] {1,2});
		arrlst.add(new int[] {3,4});
		
		for (int i = 0; i < arrlst.size(); i++) {
			if (Arrays.equals(arrlst.get(i),new int[] {arr[1],arr[2]})) {
				System.out.println("리스트 "+i+" 번째는 같다");
			}else {
				System.out.println("리스트 "+i+" 번쨰는 다르다");
			}
		}
	}

}
