package com.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MeetingRoom {
	
	public static class Meeting implements Comparable<Meeting>{
		int start,end;
		public Meeting(int start,int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) { // 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
			// TODO Auto-generated method stub
			return this.end != o.end ? this.end-o.end : this.start-o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		
		Meeting[] meetings = new Meeting[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());
		for (Meeting meeting : result) {
			System.out.println(meeting.start +" "+meeting.end);
		}
	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		// TODO Auto-generated method stub
		List<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]);
		
		for (int i = 1; i < meetings.length; i++) {
			if (result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}

}
