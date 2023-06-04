package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {
	static int n,m,result;
	static int[] array,arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		array = new int[n];
		arr = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
		c(0,0);
	}
	private static void c(int start, int index) {
		if(index == m) {
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0)break;
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i])continue;
			visited[i] = true;
//			if(index>0 && (arr[index-1] == array[i]))continue;
			arr[index] = array[i];
			c(i+1,index+1);
			visited[i] = false;
		}
	}

}
