package class_04;

import class_04.Code_08_CompleteTreeNodeNumber.Node;

public class CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	public static int nodeNum(Node head) {
		if(head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	
	public static int bs(Node head, int level, int h) {
		if(head == null) {
			return 1;
		}
		if(mostLeftLevel(head.right, level+1)==h) {
			return (1<<(h-level)) + bs(head.right, level+1, h);
		}else {
			return (1<<(h-level-1)) + bs(head.left, level+1, h);
		}
	}
	
	public static int mostLeftLevel(Node head, int level) {
		if(head == null) {
			return level;
		}
		while(head.left!=null) {
			level++;
			head=head.left;
		}
		return level;
	}
}
