package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11279 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> pqueue = new PriorityQueue<>((o1,o2)->o2-o1);
		for (int i = 0; i < n; i++) {
			int t = Integer.valueOf(br.readLine());
			if(t==0) {
				if(pqueue.size()==0)System.out.println(0);
				else System.out.println(pqueue.poll());
			}else {
				pqueue.add(t);
			}
		}
	}

}
