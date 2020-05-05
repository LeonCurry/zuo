package class_07;

import java.util.zip.Inflater;

import javax.sql.rowset.serial.SerialArray;

import class_07.TrieTree.TrieNode;

public class TrieTree {
	public static class TrieNode{
		public int path;
		public int end;
		public TrieNode[] next;
		public TrieNode() {
			path = 0;
			end = 0;
			next = new TrieNode[26];
		}
	}
	
	public static class Trie {
		public TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert (String word) {
			if(word == null) {
				return;
			}
			char[] ch = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0 ; i<ch.length; i++) {
				index = ch[i] - 'a' ;
				if(node.next[index] == null) {
					node.next[index] = new TrieNode();
				}
				node = node.next[index];
				node.path++;
			}
			node.end++;
		}
		
		public void delete(String word) {
			if(search(word) != 0) {
				char[] ch = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for(int i=0 ; i < ch.length ; i++) {
					index = ch[i] - 'a';
					if(--node.next[index].path == 0) {
						node.next[index] = null;
						return;
					}
					node = node.next[index];
					
				}
				node.end--;
			}
			
		}
		
		public int search(String word) {
			if(word == null) {
				return 0;
			}
			char[] ch = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0 ; i < ch.length ; i++) {
				index = ch[i] - 'a';
				if(node.next[index] == null) {
					return 0;
				}
				node = node.next[index];
			}
			return node.end;
		}
		
		public int prefixNumber (String word) {
			if(word == null) {
				return 0;
			}
			char[] ch = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0 ; i < ch.length ; i++) {
				index = ch[i] - 'a';
				if(node.next[index] == null) {
					return 0;
				}
				node = node.next[index];
			}
			return node.path;
		}
	}
}
