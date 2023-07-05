package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P11444 {
	static long n;
	static TreeMap<Long, Long> h;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.valueOf(st.nextToken());
		h = new TreeMap<>();
		h.put(0l, 0l);
		h.put(1l, 1l);
		h.put(2l, 1l);
		h.put(3l, 2l);
		System.out.println(f(n));
//		System.out.println(h.get(n));
		
	}
	private static long f(long num) {
		if(h.containsKey(num))return h.get(num);
		
//		System.out.println("num : "+n+" "+h.containsKey(num));
		long a = num / 2;
		long b = num - a;
//		System.out.println("a : "+a);
//		System.out.println("b : "+b);
//		System.out.println("f(a-1)*f(b) : "+f(a-1)*f(b));
		long temp = (((f(a-1)*f(b))% 1000000007)+((f(a)*f(b+1))%1000000007))%1000000007;
//		System.out.println("temp : "+temp);
		
		h.put(num,temp);
		return temp;
//		return 0l;
	}

}
