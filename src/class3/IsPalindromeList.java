package class3;

import java.util.Stack;

import javax.security.sasl.SaslException;

public class IsPalindromeList {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	// need n extra space
	public static boolean isPalindrome1(Node head) {
		if(head==null||head.next==null) {
			return true;
		}
		Stack<Node> stack=new Stack<Node>();
		Node cur = head;
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		while(head!=null) {
			if(head.value!=stack.pop().value) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	// need n/2 extra space
	public static boolean isPalindrome2(Node head) {
		if(head==null||head.next==null) {
			return true;
		}
		Node fastNode=head;
		Node slow = head.next;
		Stack<Node> stack= new Stack<>();
		while(fastNode.next!=null&&fastNode.next.next!=null) {
			fastNode=fastNode.next.next;
			slow=slow.next;
		}
		while(slow!=null) {
			stack.push(slow);
			slow=slow.next;
		}
		while(!stack.isEmpty()) {
			if(head.value!=stack.pop().value) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	// need O(1) extra space
	public static boolean isPalindrome3(Node head) {
		if(head==null||head.next==null) {
			return true;
		}
		//找中间点
		Node n1=head;
		Node n2=head;
		while(n2.next!=null&&n2.next.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
		}
		//反转后半部分；
		Node n3=null;
		n2=n1.next;
		n1.next=null;
		while(n2!=null) {
			n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		n3=n1; //n1现在是最后一个节点
		n2=head;
		//检验
		boolean res=true;
		while(n1!=null&&n2!=null) {
			if(n1.value!=n2.value) {
				res=false;
				break;
			}
			n1=n1.next;
			n2=n2.next;
		}
		n1=n3.next;
		n3.next=null;
		while(n1!=null) {
			n2=n1.next;
			n1.next=n3;
			n3=n1;
			n1=n2;
		}
		return res;		
	}
}
