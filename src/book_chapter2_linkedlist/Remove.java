package book_chapter2_linkedlist;

import java.util.Scanner;

public class Remove {
	public Node removeMidNode(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		//如果是两个点，删除第一个，直接返回第二个
		if(head.next.next == null) {
			return head.next;
		}
		Node cur = head.next.next;
		Node pre = head;
		while(cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	public Node removeByRatio(Node head, int a, int b) {
		//a是整数，a<=0;
		if(a < 1 || a > b) {
			return head;
		}
		Node cur = head;
		int n = 0;
		while(cur != null) {
			n++;
			cur = cur.next;
		}
		n = (int) Math.ceil(((double) a * n) / (double) b );
		if(n == 1) {
			return head;
		}
		if(n > 1) {
			cur = head;
			while(--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;		
	}
	public static Node removeKthNode(Node head, int k) {
		if(head == null) {
			return head;
		}		
		Node cur = head;
		int n = 0;
		while(cur != null) {
			n++;
			cur = cur.next;
		}
		if(k > n || k <= 0) {
			return head;
		}
		if(k > 0) {
			cur = head;
			while(--k != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;		
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
		
		Node newHead = removeKthNode(head1,k);
		cur = newHead;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
}
