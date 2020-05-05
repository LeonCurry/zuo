package book_chapter2_linkedlist;

import java.util.Scanner;
import java.util.Stack;

public class IsPalindrome {
	//时间复杂度为O(N) 空间复杂度为O(N)
	public static boolean isPalindrome1(Node head) {
		Stack<Integer> stack = new Stack<>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur.value);
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			if(stack.pop() != cur.value) {
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	//时间复杂度为O（N）,空间复杂度为O（N/2）
	public static boolean isPalindrome2(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node right = head.next;
		Node cur = head;
		while(cur.next != null && cur.next.next !=null) {
			right = right.next;
			cur = cur.next.next;
		}
		
		while(right != null) {
			stack.push(right.value);
			right = right.next;
		}
		while(!stack.isEmpty()) {
			if(head.value != stack.pop()){
				return false;
			}
			head = head.next;
		}
		return true;
	}	
	//时间复杂度为O（N），空间复杂度为O(1)
	public static boolean isPalindrome3(Node head) {
		Node leftStart = head;
		Node mid = head;
		Node cur = head;
		while(cur.next != null && cur.next.next != null) {
			mid = mid.next;
			cur = cur.next.next;
		}
		//反转右边
		cur = mid;
		Node rightStart = mid.next;
		Node next = null;
		while(rightStart != null) {
			next = rightStart.next;
			rightStart.next = cur;
			cur = rightStart;
			rightStart = next;
		}
		rightStart = cur;
		mid.next = null;
		//比较
		boolean res = true;
		while(leftStart.next != null && rightStart.next != null) {
			if(leftStart.value != rightStart.value) {
				res = false;
				break;
			}
			leftStart = leftStart.next;
			rightStart = rightStart.next;
		}
		//调整回原来的结构
		Node pre = null;
		while(cur != mid) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		mid.next = pre;
		return res;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len1 = Integer.valueOf(in.nextLine());
		String[] data1 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node cur = head1;
		for(int i = 1 ; i < len1 ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		boolean res = isPalindrome3(head1);
		System.out.println(res);
	}
}
