package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P1038 {
	static ArrayList<Integer> result = new ArrayList<>();
	static int[] select = new int[10];
	static int[] num = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for (int i = 1; i < 10; i++) {
			select = new int[10];
			com(0,0,i);
		}
//		com(0,0,9);
		
		Collections.sort(result);
//		System.out.println(result.size());
//		System.out.println(result.get(1021));
		System.out.println(n==1022?"9876543210":result.size()<=n?-1:result.get(n));
	}

	private static void com(int index, int count,int m) {
		if(count == m) {
//			Arrays.sort(select);
//			System.out.println(Arrays.toString(select));
			String in = "";
			boolean flag = false;
			for (int i = select.length-1; i > -1; i--) {
				if(!flag && select[i] == 0)continue;
				flag = true;
				in+=select[i]+"";
			}
			result.add(in==""?0:Integer.parseInt(in));
//			System.out.println(in);
			return;
		}
		for (int i = index; i < num.length; i++) {
			select[count] = num[i];
			com(i+1,count+1,m);
		}
	}

}
