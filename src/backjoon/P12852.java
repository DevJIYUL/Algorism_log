package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P12852 {
	static class Node{
		int num;
		ArrayList<Integer> passed;
		int count;
		public Node(int num, ArrayList<Integer> passed,int count) {
			this.num = num;
			this.passed = passed;
			this.count= count;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", passed=" + passed + ", count=" + count + "]";
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o1.count - o2.count);
		pqueue.add(new Node(n, new ArrayList<>(Arrays.asList(n)), 0));
		boolean[] visited = new boolean[1000001];
		visited[n] = true;
		while (!pqueue.isEmpty()) {
			Node temp = pqueue.poll();
//			System.out.println(temp);
			if(temp.num == 1) {
				System.out.println(temp.count);
//				System.out.println(temp.passed);
				for (Integer a : temp.passed) {
					System.out.print(a+" ");
				}
				break;
			}
			if(temp.num % 3 ==0 && !visited[temp.num/3]) {
				ArrayList<Integer> x = new ArrayList<>(temp.passed);
				x.add(temp.num/3);
				visited[temp.num/3] = true;
				pqueue.add(new Node(temp.num/3,x , temp.count+1));
			}
			if(temp.num % 2 == 0 && !visited[temp.num/2]) {
				ArrayList<Integer> x = new ArrayList<>(temp.passed);
				x.add(temp.num/2);
				visited[temp.num/2] = true;
				pqueue.add(new Node(temp.num/2, x, temp.count+1));
			}
			if(!visited[temp.num-1]) {
				ArrayList<Integer> x = new ArrayList<>(temp.passed);
				x.add(temp.num-1);
				visited[temp.num-1] = true;
				pqueue.add(new Node(temp.num-1, x, temp.count+1));
			}
		}
	}

}
