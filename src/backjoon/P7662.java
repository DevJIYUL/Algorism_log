package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P7662 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			int a = Integer.valueOf(br.readLine());
			TreeSet<Integer> tset = new TreeSet<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < a; j++) {
				st = new StringTokenizer(br.readLine());
				String comm = st.nextToken();
				int num = Integer.valueOf(st.nextToken());
//				System.out.println(comm+" "+num);
				if(comm.equals("I")) {
					if(tset.contains(num)) {
						map.put(num, map.get(num)+1);
					}else {
						tset.add(num);
						map.put(num, 1);
					}
				}else if(comm.equals("D")) {
					if(tset.size()==0)continue;
					if(num == 1) {
						int temp = tset.last();
						if(map.get(temp)>1) {
							map.put(temp, map.get(temp)-1);
						}else if(map.get(temp)==1) {
							map.remove(temp);
							tset.remove(temp);
						}
//						System.out.println(temp);
					}else {
						int temp = tset.first();
						if(map.get(temp)>1) {
							map.put(temp, map.get(temp)-1);
						}else if(map.get(temp) == 1) {
							map.remove(temp);
							tset.remove(temp);
						}
//						System.out.println(temp);
					}
				}
//				System.out.println(tset);
//				System.out.println(map);
			}
			if(tset.size()==0)System.out.println("EMPTY");
			else {
				System.out.println(tset.last()+" "+tset.first());
			}
		}
		
	}

}
