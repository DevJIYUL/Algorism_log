package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1655 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
		PriorityQueue<Integer> leftQqueue = new PriorityQueue<>((o1,o2)->o2-o1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int a = Integer.valueOf(br.readLine());
			if(rightQueue.size()==0)rightQueue.add(a);
			else if(a>=rightQueue.peek()){
				rightQueue.add(a);
				if(rightQueue.size()>i/2&&i%2==0)leftQqueue.add(rightQueue.poll());
			}else {
				leftQqueue.add(a);
				if(leftQqueue.size()>i/2&&i%2==1)rightQueue.add(leftQqueue.poll());
			}
			
//			System.out.println(rightQueue);
//			System.out.println(leftQqueue);
			if(i%2==1)sb.append(rightQueue.peek()+"\n");
			else sb.append(leftQqueue.peek()+"\n");
		}
		System.out.println(sb);

	}

}
