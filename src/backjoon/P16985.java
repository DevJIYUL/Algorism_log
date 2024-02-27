package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16985 {
	static int[][][] rep,graph,temp;
	static boolean[][][] visited;
	static int[] arr,brr;
	static int[] dx= {0,1,0,-1,0,0};
	static int[] dy= {1,0,-1,0,0,0};
	static int[] dz= {0,0,0,0,1,-1};
	static boolean[] v;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new int[5][5][5];
		rep = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 5; j2++) {
					rep[i][j][j2] = Integer.valueOf(st.nextToken());
				}
			}
		}
		v = new boolean[5];
		brr = new int[5];
		go(0,0);
//		find();
//		per(0);
		System.out.println(result == Integer.MAX_VALUE?-1:result);
		
	}
	private static void go(int index, int count) {
		if(count == 5) {
//			System.out.println(Arrays.toString(brr));
			make(brr);
			arr = new int[5];
			per(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if(v[i])continue;
			brr[count] = i;
			v[i] = true;
			go(i+1,count+1);
			v[i] = false;
		}
		
	}
	private static void make(int[] arr2) {
		graph = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			graph[i] = rep[arr2[i]];
		}
	}
	private static void per(int count) {
		if(count == 5) {
			temp = turn(arr);

			visited = new boolean[5][5][5];
			if(temp[0][0][0] ==1) {
				find();
				
			};
			return;
		}
		for (int i = 0; i < 4; i++) {
			arr[count] = i;
			per(count+1);
		}
	}
	private static void find() {
		PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1,o2)->o1[3]-o2[3]);
		pqueue.add(new int[] {0,0,0,0});
		visited[0][0][0] = true;
		while (!pqueue.isEmpty()) {
			int[] te = pqueue.poll();
//			System.out.println(Arrays.toString(te));
			if(te[0] == 4 && te[1] == 4 && te[2] == 4) {
				if(te[3] == 12) {
//					System.out.println("brr : "+Arrays.toString(brr));
//					System.out.println("arr : "+Arrays.toString(arr));
//					for (int i = 0; i < 5; i++) {
//						for (int j = 0; j < 5; j++) {
//							System.out.println(Arrays.toString(graph[i][j]));
//						}
//					}
				}
				result = Math.min(result, te[3]);
				return;
			}
			for (int i = 0; i < 6; i++) {
				int nx = te[1]+dx[i];
				int ny = te[2]+dy[i];
				int nz = te[0]+dz[i];
				if(nx<0||nx>=5||ny<0||ny>=5||nz<0||nz>=5||visited[nz][nx][ny])continue;
				if(temp[nz][nx][ny] == 0)continue;
				visited[nz][nx][ny] = true;
				pqueue.add(new int[] {nz,nx,ny,te[3]+1});
			}
		}
	}
	private static int[][][] turn(int[] arr2) {
		int[][][] t = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					t[i][j][j2] = graph[i][j][j2];
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if(arr2[i] == 0)continue;
			t[i] = layerTurn(t,arr2[i],i);
		}
		return t;
	}
	private static int[][] layerTurn(int[][][] t, int hMany, int index) {
		for (int i = 0; i < hMany; i++) {
			int[][] a = new int[5][5];

			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					a[j][j2] = t[index][4-j2][j];
				}
			}
			t[index] = a;

		}
		return t[index];
	}

}
