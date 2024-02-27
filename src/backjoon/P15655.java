package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {
	static int n,m;
	static int[] arr, select;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n];
		select = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		per(0,0);

	}
	public static void per(int index,int count) {
		if(count == m) {
//			System.out.println(Arrays.toString(select));
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i]+" ");
			}
			return;
		}
		for (int i = index; i < n; i++) {
			select[count] = arr[i];
			per(i+1,count+1);
		}
	}
}
