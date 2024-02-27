package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1927 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int n = Integer.valueOf(a);
		PriorityQueue<Integer> pqueue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int z = Integer.valueOf(br.readLine());
			if(z == 0) {
				if(pqueue.size()!=0)System.out.println(pqueue.poll());
				else System.out.println(0);
			}
			else{
				pqueue.add(z);
			}
		}
	}

}
