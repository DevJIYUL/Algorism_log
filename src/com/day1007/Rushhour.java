package com.day1007;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Queue;

public class Rushhour {
	static class Station{
		String name;
		ArrayList<String> route = new ArrayList<>();
		ArrayList<Integer> ho = new ArrayList<>();

		public Station(String name, ArrayList<String> route, ArrayList<Integer> ho) {
			super();
			this.name = name;
			this.route = route;
			this.ho = ho;
		}
	}
	static String company = "역삼";
	static String[] houselist = {"압구정 로데오","양재","논현"};
	static HashMap<Integer, ArrayList<String>> metro;
	static HashMap<String, ArrayList<Integer>> transfer;
	static HashSet<String> visited;
	public static void main(String[] args) {
		metro = new HashMap<>();
		transfer = new HashMap<>();
		visited = new HashSet<>();
		metro.put(1, new ArrayList<>(Arrays.asList("교대","강남","역삼","선릉","삼성")));
		metro.put(2, new ArrayList<>(Arrays.asList("논현","신논현","강남","양재")));
		metro.put(3, new ArrayList<>(Arrays.asList("신논현","언주","선정릉")));
		metro.put(4, new ArrayList<>(Arrays.asList("한치","선릉","선정릉","강남구청","압구정 로데오")));
		for (Entry<Integer, ArrayList<String>> e : metro.entrySet()) {
			for (String string : metro.get(e.getKey())) {
				if(transfer.containsKey(string)) transfer.get(string).add(e.getKey());
				else transfer.put(string, new ArrayList<>(Arrays.asList(e.getKey())));

			}
		}
		System.out.println("관심 지역으로 추가된 집에서 가장 가까운 역 : "+Arrays.toString(houselist));
		System.out.println("회사에서 가장 가까운 역 : "+company);
		System.out.println("//호선//역들");
		for (Entry<Integer, ArrayList<String>> met : metro.entrySet()) {
			System.out.println(met.getKey()+" : "+met.getValue());
		}
		System.out.println("//역이름//역을 지나는 호선들");
		for (Entry<String, ArrayList<Integer>> tran : transfer.entrySet()) {
			System.out.println(tran.getKey()+" : "+tran.getValue());
		}
		Queue<Station> queue = new ArrayDeque<>();
		queue.add(new Station(company, new ArrayList<>(Arrays.asList("역삼")),new ArrayList<>(Arrays.asList(1))));
		visited.add(company);
		while (!queue.isEmpty()) {
			Station temp = queue.poll();
			boolean isfind = false;
			for (String house : houselist) {
				if(temp.name.equals(house)) {
					isfind = true;
					for (int i = 0; i < temp.route.size(); i++) {
						System.out.print(temp.ho.get(i)+"호선 "+ temp.route.get(i)+" -> ");
					}
					System.out.println("관심 지역 집");
					break;
				}
			}
			if(isfind) continue;
			for (Integer hosun : transfer.get(temp.name)) {
				for (int i = 0; i < metro.get(hosun).size(); i++) {
					if(metro.get(hosun).get(i).equals(temp.name)) {
						if(i-1>=0 && !visited.contains(metro.get(hosun).get(i-1))) {
							ArrayList<String> t = new ArrayList<>();
							ArrayList<Integer> h = new ArrayList<>();
							for (int k = 0; k < temp.route.size(); k++) {
								t.add(temp.route.get(k));
								h.add(temp.ho.get(k));
							}
							t.add(metro.get(hosun).get(i-1));
							h.add(hosun);
							queue.add(new Station(metro.get(hosun).get(i-1), t,h));
							visited.add(metro.get(hosun).get(i-1));
						}
						if(i+1<= metro.get(hosun).size()-1 && !visited.contains(metro.get(hosun).get(i+1))) {
							ArrayList<String> t = new ArrayList<>();
							ArrayList<Integer> h = new ArrayList<>();
							for (int k = 0; k < temp.route.size(); k++) {
								t.add(temp.route.get(k));
								h.add(temp.ho.get(k));
							}
							t.add(metro.get(hosun).get(i+1));
							h.add(hosun);
							queue.add(new Station(metro.get(hosun).get(i+1), t,h));
							visited.add(metro.get(hosun).get(i+1));
						}
						break;
					}
				}
			}
		}
	}
}
