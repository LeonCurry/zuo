package class3;

import class3.Code_07_ReverseList.DoubleNode;
import class3.Code_07_ReverseList.Node;

public class ReverseList {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node reverseList(Node head) {
		Node next=null;
		Node pre=null;
		
		while(head!=null) {
			next=head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}
	
	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre=null;
		DoubleNode next=null;
		while(head!=null) {
			next = head.next;
			head.next=pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
}
