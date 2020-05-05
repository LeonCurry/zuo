package book_chapter2_linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class AddList {
	public static Node addList1(Node head1, Node head2) {
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while(head1 != null) {
			stack1.push(head1.value);
			head1 = head1.next;
		}
		while(head2 != null) {
			stack2.push(head2.value);
			head2 = head2.next;
		}
		int n1 = 0;
		int n2 = 0;
		int ca = 0;
		int n = 0;
		Node node = null;
		Node pre =null;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			n1 = stack1.isEmpty() ? 0 : stack1.pop();
			n2 = stack2.isEmpty() ? 0 : stack2.pop();
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n %10);
			node.next = pre;
			ca = n / 10;
		}
		if(ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
		
	}
	
	public static Node addList2(Node head1, Node head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		head1 = reverse(head1);
		head2 = reverse(head2);
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node c1 = head1;
		Node c2 = head2;
		Node node = null;
		Node pre = null;
		while(c1 != null || c2 != null) {
			n1 = c1 != null ? c1.value : 0;
			n2 = c2 != null ? c2.value : 0;
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n %10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if(ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		head1 = reverse(head1);
		head2 = reverse(head2);
		return node;
	}
	public static Node reverse(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] len = in.nextLine().split(" ");
		int len1 = Integer.valueOf(len[0]);
		int len2 = Integer.valueOf(len[1]);
		String[] data1 = in.nextLine().split(" ");
		String[] data2 = in.nextLine().split(" ");
		Node head1 = makeList(data1, len1);
		Node head2 = makeList(data2, len2);
		Node res = addList2(head1, head2);
		printRes(res);
	}
	public static Node makeList(String[] data , int len) {
		Node head = new Node(Integer.valueOf(data[0]));
		Node cur = head;
		for(int i = 1; i < len ; i++) {
			Node next = new Node(Integer.valueOf(data[i]));
			cur.next = next;
			cur = cur.next;
		}
		cur.next = null;
		return head;
	}
	public static void printRes(Node head) {
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}
