package class_05;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
	public static class Node {
		// whatever you like
	}
	
	public static class UnionFindSet{
		public  HashMap<Node, Node> fatherMap;
		public HashMap<Node,  Integer> sizeMap;
		
		public UnionFindSet(){
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}
		
		public void makeSet (List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for(Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		public Node findFatherNode (Node node) {
			Node father = fatherMap.get(node);
			if(father != node) {
				father = findFatherNode(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet (Node a, Node b) {
			return findFatherNode(a) == findFatherNode(b);
		}
		
		public void union (Node a, Node b) {
			if(a ==null || b == null) {
				return;
			}
			Node aHead = findFatherNode(a);
			Node bHead = findFatherNode(b);
			if(aHead != bHead) {
				int aSize = sizeMap.get(aHead);
				int bSize = sizeMap.get(bHead);
				if(aSize <= bSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead , aSize + bSize);
				}else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead , aSize + bSize);
				}
			}
		}
	}
}
