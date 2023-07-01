package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 이진 검색 트리*/
public class Bj5639 {

	static class Node{
		int parent;
		Node left;
		Node right;
		
		public Node(int parent) {
			this.parent = parent;
		}
		
		public void add(int a) {
			if(a<parent) {
				if(this.left == null) {
					Node temp = new Node(a);
					left = temp;
				}
				else left.add(a);
			}
			else if(a>parent) {
				if(this.right == null) {
					Node temp = new Node(a);
					right = temp;
				}
				else right.add(a);
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.valueOf(br.readLine()));
		String input;
		while (true) {
			input = br.readLine();
			if(input == null ||input.equals(""))break;
			root.add(Integer.valueOf(input));
		}
		print(root);
	}

	public static void print(Node root) {
		if(root == null)return;
		
		print(root.left);
		print(root.right);
		System.out.println(root.parent);
	}
}
