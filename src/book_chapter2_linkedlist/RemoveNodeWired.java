package book_chapter2_linkedlist;

import java.util.Scanner;

public class RemoveNodeWired {
	public static void removeNodeWired(Node node) {
		if(node == null) {
			return;
		}
		Node next = node.next;
		if(next == null) {
			throw new RuntimeException("can not remove last node");
		}
		node.value = next.value;
		node.next = next.next;
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
		Node head = makeList(data, len);
		Node node = head;
		int val = Integer.valueOf(in.nextLine());
		while(--val != 0) {
			node =node.next;
		}
		removeNodeWired(node);		
		printRes(head);
	}
}
