package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2143 {
	static int target,present;
	static int[] a,b;
	static long[] aSum,bSum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		target = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int s = Integer.valueOf(st.nextToken());
		a = new int[s];		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int w = Integer.valueOf(st.nextToken());
		b = new int[w];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			b[i] = Integer.valueOf(st.nextToken());
		}
		for (int i = 1; i < s; i++) {
			a[i] += a[i-1];
		}
		for (int i = 1; i < w; i++) {
			b[i] += b[i-1];
		}
		aSum = new long[s*(s+1)/2];
		bSum = new long[w*(w+1)/2];
		int index = 0;
		for (int i = 0; i < s; i++) {
			for (int j = i; j < s; j++) {
				int v = a[j];
				if(i!=0) v -= a[i-1];
				aSum[index++] = v;
			}
		}
		index = 0;
		for (int i = 0; i < w; i++) {
			for (int j = i; j < w; j++) {
				int v = b[j];
				if(i!=0) v -=b[i-1];
				bSum[index++] = v;
			}
		}
		Arrays.sort(aSum);
		Arrays.sort(bSum);
		int left = 0,right = bSum.length-1;
		long count = 0;
		while (left<aSum.length && right>=0) {
			long aIndex = aSum[left], bIndex = bSum[right];
			long sum = aIndex + bIndex;
			if(sum == target) {
				long aCount = 0 ,bCount = 0;
				while (left<aSum.length && aIndex == aSum[left]) {
					left++;
					aCount++;
				}
				
				while (right>=0 && bIndex == bSum[right]) {
					right--;
					bCount++;
				}
				count += aCount*bCount;
			}else if(sum <target) {
				left++;
			}else right--;
		}
		System.out.println(count);
	}

}
