package class3;

import class3.Code_14_FindFirstIntersectNode.Node;

public class FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1==null||head2==null) {
			return null;
		}
		Node loop1=getLoopNode(head1);
		Node loop2=getLoopNode(head2);
		if(loop1==null&&loop2==null) {
			return noLoop(head1, head2);
		}else if(loop1!=null&&loop2!=null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	public static Node getLoopNode(Node head) {
		if(head==null||head.next==null||head.next.next==null) {
			return null;
		}
		Node n1=head.next;
		Node n2=head.next.next;
		while(n1!=n2) {
			if(n2.next!=null||n2.next.next!=null) {
				return null;
			}
			n1=n1.next;
			n2=n2.next.next;
		}
		n2=head;
		while(n1!=n2) {
			n1=n1.next;
			n2=n2.next;
		}
		return n1;
	}
	
	public static Node noLoop(Node head1, Node head2) {
		if(head1==null||head2==null) {
			return null;
		}
		int n=0;
		Node cur1=head1;
		while(cur1.next!=null) {
			n++;
			cur1=cur1.next;
		}
		Node cur2=head2;
		while(cur2.next!=null) {
			n--;
			cur2=cur2.next;
		}
		if(cur1!=cur2) {
			return null;
		}
		cur1 = n>0?head1:head2;
		cur2 = cur1==head1? head2:head1;
		Math.abs(n);
		while(n!=0) {
			n--;
			cur1=cur1.next;
		}
		while(cur1!=cur2)	{
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return cur1;
		
	}
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1=null;
		Node cur2=null;
		if(loop1==loop2) {
			int n=0;
			cur1=head1;
			while(cur1.next!=loop1) {
				n++;
				cur1=cur1.next;
			}
			cur2=head2;
			while(cur2.next!=loop2) {
				n--;
				cur2=cur2.next;
			}
			cur1 = n>0?head1:head2;
			cur2 = cur1==head1? head2:head1;
			Math.abs(n);
			while(n!=0) {
				n--;
				cur1=cur1.next;
			}
			while(cur1!=cur2)	{
				cur1=cur1.next;
				cur2=cur2.next;
			}
			return cur1;
		}else {
			cur1=loop1.next;
			while(cur1!=loop1) {
				if(cur1==loop2) {
					return loop1;
				}
				cur1=cur1.next;
			}
			return null;
		}
	}
}
