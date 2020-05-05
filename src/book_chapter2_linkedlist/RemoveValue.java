package book_chapter2_linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class RemoveValue {
	//时间复杂度为O(N),空间复杂度为O(1)
	public static Node removeValue(Node head, int num) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			if(pre == null && cur.value == num) {
				head = next;
			}else if(pre != null &&cur.value == num){
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = next;
		}
		return head;
	}
	//时间复杂度为O(N),空间复杂度为O(N)
	public static Node removeValue1(Node head, int num) {
		Stack<Node> stack = new Stack<Node>	();
		while(head != null) {
			if(head.value != num) {
				stack.push(head);
			}
			head = head.next;
		}
		while(!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node head = makeList(data, len);
		int num = Integer.valueOf(in.nextLine());
		Node newHead = removeValue(head, num);
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
