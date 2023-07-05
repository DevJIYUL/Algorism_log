package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1644 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		boolean[] visited = new boolean[n+1];
		visited[0] = visited[1] = true;
		for (int i = 2; i*i <= n; i++) {
			for (int j = i*i; j <= n; j+=i) {
				if(visited[j]) continue;
				visited[j] = true;
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) arr.add(i);
		}
//		System.out.println(arr);
		int result = 0,hap = 0,left=0, right = 0;
		if(arr.size()==0) {
			hap = 0;
			left=0;
			right = 0;
		}
		else{
			hap = arr.get(0);
			left = 0;
			right = 0;
		}
		while(left <= right && left<=arr.size()-1) {
			if(hap == n) {
				result++;
//				System.out.println("정답!");
			}
			if(hap<n) {
				if(right+1 < arr.size())right++;
				hap+=arr.get(right);
			}else if (hap>=n) {
				hap-=arr.get(left);
				left++;
				
			}
//			System.out.println("left -> "+left+" right -> "+right+ " hap -> "+hap);
		}
		System.out.println(result);
	}

}
