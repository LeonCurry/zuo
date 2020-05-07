package book_chapter5_string;

import javax.swing.LayoutFocusTraversalPolicy;

public class MaxXorSubarray {
	//时间复杂度为O(N^2)
	public static int maxXorSubarray1(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[] eor = new int[arr.length];
		eor[0] = arr[0];
		for(int i = 1; i < arr.length ; i++) {
			eor[i] = arr[i] ^ eor[i-1];
		}
		int max = Integer.MIN_VALUE;
		for(int j = 0 ; j < arr.length ;j++) {
			for(int i = j ; i <= j ; i++) {
				max = Math.max(max, i == 0 ? eor[j] : eor[j] ^ eor[i -1]);
			}
		}
		return max;
	}
	
}
class Node{
	public Node[] nexts = new Node[2];
}
class NumTree{
	public Node head = new Node();
	public void add(int newNum) {
		Node cur = head;
		for(int move = 31 ; move >= 0; move--) {
			int path = ((newNum >> move) & 1);
			cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
		}
	}
}
