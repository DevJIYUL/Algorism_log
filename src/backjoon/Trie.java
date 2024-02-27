package backjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Trie {
	
	@Override
	public String toString() {
		return "Trie [rootNode=" + rootNode + "]";
	}
	class TrieNode{
		Map<Character, TrieNode> child = new HashMap<Character, Trie.TrieNode>();
		boolean word;
		public TrieNode() {
			
		}
		public TrieNode(Map<Character, TrieNode> child, boolean word) {
			this.child = child;
			this.word = word;
		}
		@Override
		public String toString() {
			return "TrieNode [child=" + child + ", word=" + word + "]";
		}
		
	}
	TrieNode rootNode;
	public Trie() {
		rootNode = new TrieNode(); 
	}
	void add(String word) {
		TrieNode node = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			node = node.child.computeIfAbsent(word.charAt(i), key->new TrieNode());
		}
		node.word = true;
	}
	boolean contains(String word) {
		TrieNode node = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			if(!node.child.containsKey(word.charAt(i))) return false;
			node = node.child.get(word.charAt(i));
		}
		return node.word;
	}
	void delete(String word) {
		delete(this.rootNode,word,0);
	}
	private void delete(TrieNode node, String word, int i) {
		if(i == word.length()) {
			if(!node.word) throw new Error("존재 하지 않습니다.");
			node.word = false;
			return ;
		}
		if(!node.child.containsKey(word.charAt(i))) throw new Error("존재 하지 않습니다.")	;
		TrieNode c = node.child.get(word.charAt(i));
		delete(c,word,i+1);
		if(c.child.isEmpty() && !c.word) 
			node.child.remove(word.charAt(i), c);
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("apple");
		trie.add("app");
		trie.add("apply");
		trie.add("banana");
		trie.add("ban");
//		trie.delete("appl");
		trie.delete("appr");
		System.out.println(trie);
		
	}

}
