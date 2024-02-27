package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13913 {
	static class Node{
		int num,count;
		String str;
		public Node(int num,int count,String str) {
			this.num = num;
			this.count = count;
			this.str = str;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", count=" + count + ", str=" + str + "]";
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o1.count-o2.count);
		pqueue.add(new Node(n, 0, n+" "));
		boolean[] visited = new boolean[100001];
		visited[n] = true;
		if(n>k) {
			System.out.println(n-k);
			for (int i = n; i >= k; i--) {
				System.out.print(i+" ");
			}
		}else {
			while (!pqueue.isEmpty()) {
				Node temp = pqueue.poll();
				if(temp.num == k) {
					System.out.println(temp.count);
					System.out.println(temp.str);
					break;
				}
				if(temp.num+1 <= k+1 && !visited[temp.num+1]) {
					if(temp.num+1 == k) {
						System.out.println(temp.count+1);
						System.out.println(temp.str+(temp.num+1));
						break;
					}
					pqueue.add(new Node(temp.num+1, temp.count+1, temp.str+(temp.num+1)+" "));
					visited[temp.num+1] = true;
				}
				if(temp.num-1 >= 0 && !visited[temp.num-1]) {
					if(temp.num-1 == k) {
						System.out.println(temp.count+1);
						System.out.println(temp.str+(temp.num-1));
						break;
					}
					pqueue.add(new Node(temp.num-1, temp.count+1, temp.str+(temp.num-1)+" "));
					visited[temp.num-1] = true;
				}
				if(temp.num * 2 <= k+1 && !visited[temp.num*2]) {
					if(temp.num*2 == k) {
						System.out.println(temp.count+1);
						System.out.println(temp.str+(temp.num*2));
						break;
					}
					pqueue.add(new Node(temp.num*2, temp.count+1, temp.str+(temp.num*2)+" "));
					visited[temp.num * 2] = true;
				}
			}
		}
	}

}
