package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/* N과 M 12*/
public class P15666 {
	static int n,m;
	static int[] arr,ele;
	static HashSet<String> hs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n];
		ele = new int[m];
		hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		cal(0,0);
		//System.out.println(hs);
	}
	private static void cal(int ind, int cou) {
		if(cou == m) {
//			System.out.println(Arrays.toString(ele));
			if(!check(ele))return ;
			if(!hs.contains(arrToStr(ele))) {
				hs.add(arrToStr(ele));
				for (int i : ele) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = ind; i < n; i++) {
			ele[cou] = arr[i];
			cal(i,cou+1);
		}
	}
	private static boolean check(int[] ele2) {
		int temp = ele2[0];
		for (int i = 1; i < ele2.length; i++) {
			if(temp>ele2[i])return false;
			temp = ele2[i];
		}
		return true;
	}
	public static String arrToStr (int[] input) {
		String str = "";
		for (int i : input) {
			str+=i+" ";
		}
		return str;
	}
}
