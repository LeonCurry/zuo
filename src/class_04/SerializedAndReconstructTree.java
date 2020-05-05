package class_04;

import java.util.LinkedList;
import java.util.Queue;

public class SerializedAndReconstructTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static String serialized(Node head) {
		if(head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialized(head.left);
		res += serialized(head.right);
		return res;
	}
	
	public static Node reconByPreString(String string) {
		String[] str = string.split("!");
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i != str.length; i++) {
			queue.offer(str[i]);
		}
		return reconByPreOrder(queue);
	}
	
	public static Node reconByPreOrder(Queue<String> queue) {
		String val = queue.poll();
		if(val == "#") {
			return null;
		}
		Node head = new Node(Integer.valueOf(val));
		head.left = reconByPreOrder(queue);
		head.right = reconByPreOrder(queue);
		return head;
	}
}
