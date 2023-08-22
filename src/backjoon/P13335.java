package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13335 {
	static int num,size,limit;
	static ArrayList<Integer> bridge;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		limit = Integer.valueOf(st.nextToken());
		bridge = new ArrayList<>();
		queue = new LinkedList<Integer>();
		for (int i = 0; i < b; i++) {
			bridge.add(0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			queue.add(Integer.valueOf(st.nextToken()));
		}
//		System.out.println(num);
//		System.out.println(size);
//		System.out.println(bridge);
//		System.out.println(queue);
		while (size>0 || !queue.isEmpty()) {
//			System.out.println("----------");
//			System.out.println(num);
//			System.out.println(size);
//			System.out.println(bridge);
//			System.out.println(queue);
			size -= bridge.remove(0);
			num++;
			if(queue.isEmpty()) {
				bridge.add(0);
				continue;
			}
			if(size + queue.peek() <= limit) {
				int temp = queue.poll();
				size+= temp;
				bridge.add(temp);
			}else {
				bridge.add(0);
//				size -= bridge.remove(0);
				
			}
		}
		System.out.println(num);
	}

}
