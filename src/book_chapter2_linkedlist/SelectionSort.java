package book_chapter2_linkedlist;

import java.util.Scanner;

public class SelectionSort {
	public static Node selectSort(Node head) {
		if(head == null) {
			return head;
		}
		Node tail = null;
		Node cur = head;
		Node small = null;
		Node smallPre = null;
		while(cur != null) {
			small = cur;
			smallPre = getSmallPreNode(cur);
			if(smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small ? cur.next : cur;
			if(tail == null) {
				head = small;
			}else {
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}
	public static Node getSmallPreNode(Node head) {
		Node small = head;
		Node smallPre = null;
		Node pre = head;
		Node cur = head.next;
		while(cur != null) {
			if(cur.value < small.value) {
				small = cur;
				smallPre = pre;				
			}
			pre = cur;			
			cur = cur.next;			
		}
		return smallPre;
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
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node  head = makeList(data, len);
		Node res = selectSort(head);
		printRes(res);
	}
}
