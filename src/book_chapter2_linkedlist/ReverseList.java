package book_chapter2_linkedlist;

import java.util.Scanner;

public class ReverseList {
	public static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node next = null;
		Node pre = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static DoubleNode reverseList(DoubleNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		DoubleNode next = null;
		DoubleNode pre = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len1 = Integer.valueOf(in.nextLine());
		String[] data1 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node cur = head1;
		for(int i = 1 ; i < len1 ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		
		int len2 = Integer.valueOf(in.nextLine());
		String[] data2 = in.nextLine().split(" ");
		DoubleNode head2 = new DoubleNode(Integer.valueOf(data2[0]));
		DoubleNode cur2 = null;
		cur2 = head2;
		DoubleNode last = null;
		for(int i = 1 ; i < len2 ; i++) {
			cur2.last = last;
			cur2.next = new DoubleNode(Integer.valueOf(data2[i]));
			last = cur2;
			cur2 = cur2.next;
		}
		cur2.last = last;
		cur2.next = null;
		
		Node newHead1 = reverseList(head1);
		cur = newHead1;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		DoubleNode newHead2 = reverseList(head2);
		cur2 = newHead2;
		while(cur2 != null) {
			System.out.print(cur2.value + " ");
			cur2 = cur2.next;
		}
	}
}
