package class_04;

import java.util.Stack;

import class_04.Code_01_PreInPosTraversal.Node;

public class PreInPosTraversal {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	public static void preOrderRecur(Node head) {
		if(head == null) {
			return;
		}
		System.out.println(head.value);
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}
	
	public static void preOrderUnRecur(Node head) {
		if(head==null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(head);
		while(!stack.isEmpty()) {
			head=stack.pop();
			System.out.println(head.value);
			if(head.right!=null) {
				stack.push(head.right);
			}
			if(head.left!=null) {
				stack.push(head.left);
			}
		}
		System.out.println();
	}
	
	public static void inOrderUnRecur(Node head) {
		if(head==null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head!=null) {
			if(head!=null) {
				stack.push(head);
				head = head.left;
			}
			if(head == null) {
				head = stack.pop();
				System.out.println(head.value);
				head = head.right;
			}
		}
	}
	
	public static void posOrderUnRecur1(Node head) {
		if(head==null) {
			return;
		}
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(head);
		while(!stack1.isEmpty()) {
			head = stack1.pop();
			stack2.push(head);
			if(head.left!=null) {
				stack2.push(head.left);
			}
			if(head.right != null) {
				stack2.push(head.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.println(stack2.pop().value);
		}
		System.out.println();
	}
}
