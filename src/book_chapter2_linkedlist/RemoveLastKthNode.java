package book_chapter2_linkedlist;

import java.util.Scanner;

public class RemoveLastKthNode {
	public static Node removeLastKthNode(Node head1, int k) {
		if(head1 == null || k<1) {
			return head1;
		}
		Node cur = head1;
		while(cur != null) {
			k--;
			cur = cur.next;
		}
		if(k == 0) {
			head1 = head1.next;
		}
		if(k < 0) {
			cur = head1;
			while(++k != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head1;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] row1 = in.nextLine().split(" ");
		int len = Integer.valueOf(row1[0]);
		int k = Integer.valueOf(row1[1]);
		String[] data1 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node cur = head1;
		for(int i = 1 ; i < len ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		Node newHead = removeLastKthNode(head1,k);
		cur = newHead;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
}
