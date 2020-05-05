package book_chapter2_linkedlist;

public class GetIntersectNode {
	public static Node getLoopNode(Node head) {
		if(head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node fast = head.next.next;
		Node slow = head.next;
		while(fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	public static Node noLoop(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while(cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if(cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		while(n != 0) {
			cur1 = cur1.next;
			n--;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;		
	}
	public static Node bothLoop(Node head1, Node head2 , Node loop1, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while(cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n>0 ? head1 :head2;
			cur2 = cur1 == head1 ? head2 : head1;
			while(n != 0) {
				cur1 = cur1.next;
				n--;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	public Node getIntersectNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if(loop1 != null && loop2 != null) {
			return bothLoop(head1, head2, loop1, loop2);
		}
		return null;
	}
}
