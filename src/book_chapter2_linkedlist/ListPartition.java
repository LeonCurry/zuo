package book_chapter2_linkedlist;

import java.util.Scanner;

import javax.swing.border.EtchedBorder;

public class ListPartition {
	public static Node listPartition1(Node head , int pivot) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		int num= 0;
		while(cur != null) {
			num++;
			cur = cur.next;
		}
		cur = head;
		Node[] nodeArr = new Node[num];
		for(int i = 0 ; i < num ; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		
		arrPartition(nodeArr, pivot);
		for(int i = 1; i <num;i++) {
			nodeArr[i-1].next = nodeArr[i];
		}
		nodeArr[num-1].next = null;
		return nodeArr[0];
	}
	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while(index != big) {
			if(nodeArr[index].value < pivot) {
				swap(nodeArr, index++, ++small);
			}else if(nodeArr[index].value == pivot) {
				index++;
			}else {
				swap(nodeArr, index, --big);
			}
		}
	}
	
	public static void swap(Node[] nodeArr, int a, int b) {
		Node temp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = temp;
	}
	
	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;
		Node sE = null;
		Node mH = null;
		Node mE = null;
		Node bH = null;
		Node bE = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sE = head;
				}else {					
					sE.next = head;
					sE = head;
				}
			}else if(head.value == pivot) {
				if(mH == null) {
					mH = head;
					mE = head;
				}else {
					mE.next = head;
					mE = head;
				}
			}else {
				if(bH == null) {
					bH = head;
					bE = head;
				}else {
					bE.next = head;
					bE = head;
				}
			}
			head = next;
		}
		//小的和相等的重新连接
		if(sE != null) {
			sE.next = mH;
			mE = mE == null ? sE : mE;
		}
		if(mE != null) {
			mE.next = bH;
		}
		return sH != null ? sH : mH != null ? mH : bH;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] row = in.nextLine().split(" ");
		int len1 = Integer.valueOf(row[0]);
		int pivot = Integer.valueOf(row[1]);
		String[] data1 = in.nextLine().split(" ");
		Node head1 = new Node(Integer.valueOf(data1[0]));
		Node cur = head1;
		for(int i = 1 ; i < len1 ; i++) {
			cur.next = new Node(Integer.valueOf(data1[i]));
			cur = cur.next;
		}
		cur.next = null;
		head1 = listPartition2(head1, pivot);
		while(head1 != null) {
			System.out.print(head1.value + " ");
			head1 = head1.next;
		}
	}
}
