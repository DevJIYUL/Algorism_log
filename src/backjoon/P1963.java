package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1963 {
	static int test_case;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		test_case = Integer.valueOf(st.nextToken());
		for (int i = 0; i < test_case; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			boolean[] visited = new boolean[10000];
//			visited[a] = true;
			int count = -1;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {a,0});
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				if(temp[0] == b) {
					
					count = temp[1];
					break;
				}
				System.out.println(Arrays.toString(temp));
				String t = temp[0]+"";
				for (int j = Integer.valueOf(-(t.charAt(3)-'0')); j <= Integer.valueOf(9-(t.charAt(3)-'0')); j++) {
					int n = Integer.valueOf(temp[0]+j);
					if(visited[n] || n<=1000)continue;
					boolean flag = false;
					for (int k = 2; k <= (int)Math.sqrt(n); k++) {
						if(n%k==0) {
//							System.out.println("n : "+n+" k : "+k + " => "+n/k);
							flag = true;
							break;
						}
						
					}
					if(flag)continue;
					visited[n] = true;
					queue.add(new int[] {n,temp[1]+1});
				}
				for (int j = Integer.valueOf(-(t.charAt(2)-'0')); j <= Integer.valueOf(9-(t.charAt(2)-'0')); j++) {
					int n = Integer.valueOf(temp[0]+j*10);
					if(visited[n] || n<=1000)continue;
					boolean flag = false;
					for (int k = 2; k <= (int)Math.sqrt(n); k++) {
						if(n%k==0) {
//							System.out.println("n : "+n+" k : "+k + " => "+n/k);
							flag = true;
							break;
						}
						
					}
					if(flag)continue;
					visited[n] = true;
					queue.add(new int[] {n,temp[1]+1});
				}
				for (int j = Integer.valueOf(-(t.charAt(1)-'0')); j <= Integer.valueOf(9-(t.charAt(1)-'0')); j++) {
					int n = Integer.valueOf(temp[0]+j*100);
					if(visited[n] || n<=1000)continue;
					boolean flag = false;
					for (int k = 2; k <= (int)Math.sqrt(n); k++) {
						if(n%k==0) {
//							System.out.println("n : "+n+" k : "+k + " => "+n/k);
							flag = true;
							break;
						}
						
					}
					if(flag)continue;
					visited[n] = true;
					queue.add(new int[] {n,temp[1]+1});
				}
				for (int j = Integer.valueOf(-(t.charAt(0)-'0')); j <= Integer.valueOf(9-(t.charAt(0)-'0')); j++) {
					int n = Integer.valueOf(temp[0]+j*1000);
					if(visited[n] || n<=1000)continue;
					boolean flag = false;
					for (int k = 2; k <= (int)Math.sqrt(n); k++) {
						if(n%k==0) {
//							System.out.println("n : "+n+" k : "+k + " => "+n/k);
							flag = true;
							break;
						}
						
					}
					if(flag)continue;
					visited[n] = true;
					queue.add(new int[] {n,temp[1]+1});
				}
			}
			System.out.println(count==-1?"Impossible":count);
		}

	}

}
