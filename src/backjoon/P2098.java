package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2098 {
	static int[][] graph,d;
	static int n,result,INF = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		d = new int[n][(1<<(n))-1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(d[i], -1);
		}
		System.out.println(dfs(0,1));
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(d[i]));			
//		}
	}
	private static int dfs(int i, int bit) {
		if(bit == (1<<n)-1) {
			if(graph[i][0] == 0)return INF;
			else return graph[i][0];
		}
		if(d[i][bit] != -1)return d[i][bit];
		d[i][bit] =INF;
		for (int j = 0; j < n; j++) {
			if((bit & (1 << j)) == 0 && graph[i][j] !=0) {
				int re = dfs(j,bit|(1<<j));
				d[i][bit] = Math.min(d[i][bit], re+graph[i][j]);
//				System.out.println(i+" "+j+" "+bit+" "+d[i][bit]);
			}
		}
		return d[i][bit];
	}

}
