package book_chapter2_linkedlist;

import java.util.Scanner;

public class Merge {
	public static Node merge(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return head1 != null ? head1 : head2;
		}
		Node cur1 = null;
		Node cur2 = null;
		
		cur1 = head1.value <= head2.value ? head1 : head2;
		cur2 = cur1 == head2 ? head1 : head2;
		Node head = cur1;
		Node pre = null;
		Node next = null;
		while( cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				pre = cur1;
				cur1 = cur1.next;
			}else {
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;			
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len1 = Integer.valueOf(in.nextLine());
		String[] data1 = in.nextLine().split(" ");
		int len2 = Integer.valueOf(in.nextLine());
		String[] data2 = in.nextLine().split(" ");
		Node head1 = makeList(data1 , len1);
		Node head2 = makeList(data2, len2);
		Node head = merge(head1, head2);
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
