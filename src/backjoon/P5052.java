package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P5052 {
	static class Node{
		Map<Character, Node> child;
		String data;
//		boolean related=false;
		public Node(String data, Map<Character, Node> child) {
			this.data =data;
			this.child = child;
		}
		int insert(String word,int cnt,int count) {
			if(cnt == word.length()) {
				this.data = word;
				return count;
			}
			if(!this.child.containsKey(word.charAt(cnt))) {
				this.child.put(word.charAt(cnt), new Node("", new HashMap<>()));
				return this.child.get(word.charAt(cnt)).insert(word, cnt+1,count);
			}else return this.child.get(word.charAt(cnt)).insert(word, cnt+1,count+1);
		}

		@Override
		public String toString() {
			return "Node [child=" + child + ", data=" + data + "]";
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			Node node = new Node("", new HashMap<Character, Node>());
			boolean flag = false;
			int n = Integer.valueOf(br.readLine());
			ArrayList<String> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				String input = br.readLine();
				list.add(input);
			}
			Collections.sort(list,new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.length()-o1.length();
				}

			});
//			System.out.println(list);
			for (int j = 0; j < list.size(); j++) {
				String input = list.get(j);
				int v =node.insert(input, 0,0);
//				System.out.println(input +" "+v);
				if(v == input.length()) {
					flag = true;
				}
			}
//			System.out.println(node);
			System.out.println(flag?"NO":"YES");
		}
	}

}
