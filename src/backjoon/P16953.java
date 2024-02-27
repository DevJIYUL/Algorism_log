package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class P16953 {
	static long a,b,result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.valueOf(st.nextToken());
		b = Long.valueOf(st.nextToken());
		result = Long.MAX_VALUE;
		boolean[] visited = new boolean[1000000001];
		visited[(int)a] = true;
		Queue<long[]> queue = new ArrayDeque<long[]>();
		queue.add(new long[] {a,1});
		while (!queue.isEmpty()) {
			long[] temp = queue.poll();
			if(temp[0] == b) {
				result = temp[1];
				break;
			}
//			System.out.println("temp : "+ temp[0]);
			long first = temp[0]*2;
			long second = makenum(temp[0]);
//			System.out.println("first : "+first+" second : "+second);
			if(first<1000000001 && !visited[(int)first]) {
				visited[(int)first] = true;
				queue.add(new long[] {first, temp[1]+1});
			}
			if(second> 0 && second < 1000000001 && !visited[(int)second]) {
				visited[(int)second] =  true;
				queue.add(new long[] {second, temp[1] + 1});
			}
		}
		System.out.println(result==Long.MAX_VALUE?-1:result);
	}
	private static long makenum(long i) {
		long temp = i * 10;
		return temp+1;
	}

}
