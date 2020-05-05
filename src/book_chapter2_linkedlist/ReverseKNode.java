package book_chapter2_linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class ReverseKNode {
	//时间复杂度为O（N），空间复杂度为O（K）
	public static Node reverseKNode(Node head , int k) {
		if(k < 2 || head == null) {
			return head;
		}
		Stack<Integer> stack = new Stack<Integer>();
		Node cur=head;
		Node newHead = head;
		Node pre = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			stack.push(cur.value);
			if(stack.size() == k) {
				pre = resign1(stack , pre , next);
				//新的头部仅仅判断了第一次
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	public static Node resign1(Stack<Integer> stack, Node left , Node right) {
		Node next = null;
		Node cur = new Node(stack.pop());
		if(left != null) {
			left.next = cur;
		}
		while(!stack.isEmpty()) {
			next = new Node(stack.pop());
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;		
	}
	//时间复杂度为O（N） ， 空间复杂度为O（1）
	public static Node reverseKNode2(Node head, int k) {
		if(k < 2 || head == null) {
			return head;
		}
		Node cur = head;
		Node start = null;
		Node next = null;
		Node pre =null;
		int count = 1;
		while(cur != null) {
			next = cur.next;
			if(count == k) {
				start = pre == null ? head : pre.next;
				head = pre == null ? cur : head;
				resign2(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
	}
	public static void resign2(Node left, Node start, Node end, Node right) {
		Node pre = start;
		Node cur =start.next;
		Node next = null;
		while(cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null) {
			left.next = end;
		}
		start.next = right;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		Node head = makeList(data, len);
		int k = Integer.valueOf(in.nextLine());
		Node res = reverseKNode2(head, k);
		printRes(res);
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
