package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class P15665 {
	static int n,m;
	static int[] arr,select;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n];
		select = new int[m];
		set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		per(0);
		for (String string : set) {
			System.out.println(string);
		}
	}
	public static void per(int count) {
		if(count == m) {
//			System.out.println(Arrays.toString(select));
			String input = "";
			for (int i = 0; i < select.length; i++) {
				input+=select[i]+" ";
			}
			set.add(input);
			return;
		}
		for (int i = 0; i < n; i++) {
			select[count] = arr[i];
			per(count+1);
		}
	}

}
