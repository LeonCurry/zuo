package class_04;


public class SuccessorNode {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getSuccessorNode(Node node) {
		if(node == null) {
			return node;
		}
		if(node.right!=null) {
			return getMostLeft(node.right);
		}else {
			Node parent = node.parent;
			while(parent.left != node && parent != null) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	public static Node getMostLeft(Node node) {
		if(node == null) {
			return node;
		}
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
	
}
