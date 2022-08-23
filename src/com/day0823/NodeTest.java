package com.day0823;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
	int prev;
	int next;
	public Node(int prev, int next) {
		this.prev = prev;
		this.next = next;
	}
	public void show() {
		System.out.print("("+prev+","+next+")");
	}
}
public class NodeTest {
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) {
		graph = new ArrayList<ArrayList<Node>>();
		graph.add(new ArrayList<>());
		graph.get(0).add(new Node(1, 1));
		graph.get(0).add(new Node(2, 2));
		graph.get(0).add(new Node(3, 3));
		for (int i = 0; i < graph.get(0).size(); i++) {
			graph.get(0).get(i).show();
		}
	}

}
