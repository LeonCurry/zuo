package book_chapter2_linkedlist;

import java.util.Scanner;

public class PrintCommonPart {
	public static void printCommonPart(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return;
		}
		while(head1 != null && head2 != null) {
			if(head1.value < head2.value) {
				head1 = head1.next;
			}else if(head1.value > head2.value) {
				head2 = head2.next;
			}else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1 = Integer.valueOf(in.nextLine());
		String[] data1 = in.nextLine().split(" ");
		int num2 = Integer.valueOf(in.nextLine());
		String[] data2 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node head2 = new Node(Integer.valueOf(data2[0]));
		Node cur = head1;
		for(int i = 1 ; i < num1 ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		cur = head2;
		for(int i = 1 ; i < num2 ; i++) {
			cur.next = new Node(Integer.valueOf(data2[i]));
			cur = cur.next;
		}
		cur.next = null;
		printCommonPart(head1, head2);
	}
}
