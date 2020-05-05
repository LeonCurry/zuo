package book_chapter2_linkedlist;

import java.util.Scanner;

public class ReversePart {
	public static Node reversePart(Node head, int from , int to) {
		if(head == null || head.next == null) {
			return head;
		}
		int n = 0;
		Node cur = head;
		Node fPre = null;
		Node tPos = null;
		while(cur != null) {
			n++;
			fPre = (n == from -1) ? cur : fPre;
			tPos = (n == to +1) ? cur : tPos;
			cur = cur.next;
		}
		if(from <1 || to > n || from > to) {
			return head;
		}
		cur = fPre == null ? head : fPre.next;
		Node node2 = cur.next;
		cur.next = tPos;
		Node next = null;
		while(node2 != tPos) {
			next = node2.next;
			node2.next = cur;
			cur = node2;
			node2 = next;
		}
		if(fPre != null) {
			fPre.next = cur;
			return head;
		}
		return cur;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data1 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node cur = head1;
		for(int i = 1 ; i < len ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		String[] data2 = in.nextLine().split(" ");
		int from = Integer.valueOf(data2[0]);
		int to = Integer.valueOf(data2[1]);
		Node newHead1 = reversePart(head1, from, to);
		cur = newHead1;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
}
