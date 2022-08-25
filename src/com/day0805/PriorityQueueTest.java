package com.day0805;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				
				if(len1.equals(len2)) {
					return o1.compareTo(o2);
				}
				
				return len1.compareTo(len2);
			}			
		});
		
		pq.offer("true");
		pq.offer("dream");
		pq.offer("start");
		pq.offer("is");
		pq.offer("come");
		
		System.out.println(pq);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}

}
