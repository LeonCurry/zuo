package book_chapter2_linkedlist;

import java.util.Currency;
import java.util.Scanner;

public class JosephusKill {
	public static Node josephusKill1(Node head, int m) {
		if(head == null || m <1 || head.next == head) {
			return head;
		}
		Node last = head;
		while(last.next != head) {
			last = last.next;
		}
		int count =0;
		while(head != last) {
			if(++count == m) {
				last.next = head.next;
				count =0;
			}else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	public static Node josephusKill2(Node head, int m) {
		if(head == null|| head.next == head || m<1) {
			return head;
		}
		Node cur = head.next;
		int temp = 1;
		while(cur != head) {
			temp++;
			cur = cur.next;
		}
		temp = getLive(temp, m);
		while(--temp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}
	
	public static int getLive(int i, int m) {
		if(i ==1) {
			return 1;
		}
		return (getLive(i-1, m)+m-1) % i +1;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		String[] row = in.nextLine().split(" ");
		int num = Integer.valueOf(row[0]);
		int m = Integer.valueOf(row[1]);
		Node head = new Node(1);
		Node newHead = head;
		for(int i = 2 ; i <= num ; i++) {
			newHead.next = new Node(i);
			newHead = newHead.next;
		}
		
		newHead.next = head;

		head = josephusKill2(head, m);
		System.out.println(head.value);
	}
	
}
