package book_chapter2_linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class RemoveRep {
	//时间复杂度为O（N）
	public static Node removeRep1(Node head) {
		if(head == null) {
			return head;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while(cur != null) {
			if(set.contains(cur.value)) {
				pre.next = cur.next;
			}else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
		return head;		
	}
	//时间复杂度为O(N^2),空间复杂度为O(1)
	public static Node removeRep2(Node head) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			pre = cur;
			while(next != null) {
				if(next.value == cur.value) {
					pre.next = next.next;
				}else {
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
		return head;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node head = makeList(data, len);
		Node newHead = removeRep1(head);
		printRes(newHead);	
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
