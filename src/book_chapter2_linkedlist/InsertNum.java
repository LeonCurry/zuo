package book_chapter2_linkedlist;

import java.util.Scanner;

public class InsertNum {
	public static Node insertNum(Node head , int num) {
		Node node = new Node(num);
		if(head == null ) {
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != head) {
			if(pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		head = head.value < num ? head : node;
		return head;		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node head = makeLoopList(data, len);
		int num = Integer.valueOf(in.nextLine());
		head = insertNum(head, num);
		printLoopList(head);
	}
	public static Node makeLoopList(String[] data, int len) {
		Node head = new Node(Integer.valueOf(data[0]));
		Node cur = head;
		for(int i = 1 ; i < len ; i++) {
			Node node = new Node(Integer.valueOf(data[i]));
			cur.next = node;
			cur = cur.next;
		}
		cur.next = head;
		return head;
	}
	public static void printLoopList(Node head) {		
		 System.out.print(head.value + " ");
        Node node = head.next;
        while (node != head) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
	}
}
