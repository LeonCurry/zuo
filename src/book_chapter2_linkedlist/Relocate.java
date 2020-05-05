package book_chapter2_linkedlist;

import java.util.Scanner;

public class Relocate {
	public static Node relocate(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null) {
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		Node left = head;
		Node cur = null;
		Node pre = null;
		Node next = null;
		while(left != null && right != null) {
			cur = left;
			next = left.next;
			cur.next = right;
			cur = cur.next;
			right = right.next;
			left = next;
			cur.next = left;
		}
		cur.next = right;
		return head;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node head = makeList(data, len);
		head = relocate(head);
		printRes(head);
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
