package book_chapter5_string;

import javax.activation.MailcapCommandMap;

class TireNode{
	public int path;
	public int end;
	public TireNode[] map;
	public TireNode() {
		path = 0;
		end = 0;
		map = new TireNode[26];
	}
}
public class Tire {
	private TireNode root;
	public Tire() {
		 root = new TireNode();
	}
	public void insert(String word) {
		if(word == null) {
			return;
		}
		char[] chas = word.toCharArray();
		TireNode node = root;
		node.path++;
		int index = 0;
		for(int i = 0 ; i < chas.length;i++) {
			index = chas[i] - 'a';
			if(node.map[index] == null) {
				node.map[index] = new TireNode();
			}
			node = node.map[index];
			node.path++;
		}
		node.end++;
	}
	public void delete(String word) {
		if(word == null) {
			return;
		}
		if(search(word)) {
			char[] chas = word.toCharArray();
			TireNode node = root;
			node.path--;
			int index = 0;
			for(int i = 0 ; i < chas.length ; i++) {
				index = chas[i] - 'a';
				if(node.map[index].path-- == 1) {
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}
	public int prefixNumber(String word) {
		if(word == null) {
			return 0;
		}
		char[] chas = word.toCharArray();
		TireNode node = root;
		int index = 0;
		for(int i = 0 ; i < chas.length; i++) {
			index = chas[i] - 'a';
			if(node.map[index] == null) {
				return 0;
			}
			node = node.map[index];
		}
		return node.path;
	}
	
	public boolean search(String word) {
		if(word == null) {
			return false;
		}
		char[] chas = word.toCharArray();
		TireNode node = root;
		int index = 0;
		for(int i = 0 ; i < chas.length; i++) {
			index = chas[i] - 'a';
			if(node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		
		return node.end == 0 ? false : true;
	}
}
