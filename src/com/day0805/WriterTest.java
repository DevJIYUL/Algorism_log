package com.day0805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WriterTest {

	public static void main(String[] args) {
		ArrayList<Writer> list = new ArrayList<Writer>();
		list.add(new Writer(535, "jane", "kim", "who moved my cheese?"));
		list.add(new Writer(120, "harry", "potter", "will you marry me?"));
		list.add(new Writer(235, "bruce", "jones", "my love"));
		list.add(new Writer(300, "bruce", "willis", "ant story"));
		list.add(new Writer(270, "bruce", "kim", "baseball history"));
		
		//Collections.sort(list, new WriterFirstNameComparator());//firstname 기준으로 정렬	
		
		//무명 클래스 이용
		/*
		Collections.sort(list, new Comparator<Writer>() {			
			@Override
			public int compare(Writer o1, Writer o2) {				
				return o2.getBookTitle().compareTo(o1.getBookTitle());
			}			
		});//firstname 기준으로 정렬	
		*/
		
		//lambda
		Collections.sort(list, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		//Collections.sort(list);//no기준으로 정렬
		
		for (Writer w : list) {
			System.out.println(w);
		}
		
		
		
		
		
	}

}




