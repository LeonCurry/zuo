package class_04;

import java.util.LinkedList;
import java.util.Queue;

public class IsBSTAndCBT {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isCBT(Node head) {
		if(head ==null) {
			return true;
		}
		boolean leaf = false;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			if((leaf && (head.left !=null || head.right != null)) || (head.left ==null && head.right !=null)) {
				return false;
			}
			if(head.left !=null) {
				queue.offer(head.left);
			}
			if(head.right!=null) {
				queue.offer(head.right);
			}else {
				leaf = true;
			}
		}
		return true;
	}
}
