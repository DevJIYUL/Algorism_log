package com.day0805;

import java.util.Comparator;

//Comparator:클래스 외부에 정렬 기준을 만들어 놓을 때 사용됨.
//compare(o1, o2):o1, o2를 비교해서 정렬 시켜줌. 정렬기준이 들어감.
public class WriterFirstNameComparator implements Comparator<Writer>{

	@Override
	public int compare(Writer o1, Writer o2) {
		int result = o1.getFirstName().compareTo(o2.getFirstName());
		
		if(result == 0) {
			result = o1.getNo() - o2.getNo();
		}
		return result;
	}

}
