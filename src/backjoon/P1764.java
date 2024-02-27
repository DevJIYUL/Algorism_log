package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1764 {
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		PriorityQueue<String> pqueue = new PriorityQueue<>((o1,o2)->o1.compareTo(o2));
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			set.add(input);
		}
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if(set.contains(input))pqueue.add(input);
		}
		System.out.println(pqueue.size());
		while (!pqueue.isEmpty()) {
			System.out.println(pqueue.poll());
		}
	}

}
