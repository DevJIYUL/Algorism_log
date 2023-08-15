package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17609 {
	static int pali;
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			int left = 0, right = str.length()-1;
			pali = Integer.MAX_VALUE;
			palind(left,right,0);
			System.out.println(pali>=2?2:pali);
		}
	}
	private static void palind(int left, int right,int count) {
		if(count >= 2||left >= right) {
			pali = Math.min(pali, count);
			return;
		}
		if(str.charAt(left) == str.charAt(right)) {
			palind(left+1, right-1,count);
		}else {
			
			palind(left+1, right,count+1);
			palind(left, right-1,count+1);
		}
	}

}
