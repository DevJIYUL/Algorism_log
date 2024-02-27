package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P17219 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		Map<String,String> map = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String address = st.nextToken();
			String password = st.nextToken();
			map.put(address, password);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(map.get(st.nextToken()));
		}
	}

}
