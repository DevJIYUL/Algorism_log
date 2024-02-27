package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2450 {
	static int n,arr[],type[],temp[],answer = Integer.MAX_VALUE;
	static boolean typeVisted[];
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		map = new HashMap<>();
		type = new int[3];
		typeVisted = new boolean[3];
		for (int i = 0; i < n; i++) {
			int t = Integer.valueOf(st.nextToken());
			arr[i] = t;
			map.put(t, map.getOrDefault(t, 0)+1);
		}
		//System.out.println(map);
		cal(0);
		System.out.println(answer);
	}
	public static void cal(int index) {
		if(index == 3) {
//			System.out.println(Arrays.toString(type));
			temp = new int[n];
			int idx = 0;
			for (int i = 0; i < type.length; i++) {
				for (int j = 0; j < map.get(type[i]); j++) {
					temp[idx++] = type[i];
				}
			}
			int[][] pos = new int[4][4];
			for (int i = 0; i < n; i++) {
				pos[temp[i]][arr[i]]++;
			}
//			System.out.println("before"+Arrays.toString(temp));
			int count = 0,count2=0;
			for (int i = 1; i < 3; i++) {
				for (int j = i+1; j <= 3; j++) {
					int k =Math.min(pos[i][j], pos[j][i]);
					count+=k;
					count2+=pos[i][j]+pos[j][i]-(k*2);
				}
			}
//			System.out.println("after : "+Arrays.toString(temp));
//			System.out.println("count : "+count);
			answer = Math.min(answer, count+count2/3*2);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(typeVisted[i])continue;
			typeVisted[i] = true;
			type[index] = i+1;
			cal(index+1);
			typeVisted[i] = false;
		}
	}

}
