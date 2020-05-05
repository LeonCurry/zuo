package book_chapter2_linkedlist;

import java.security.acl.LastOwnerException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import book_chapter2_linkedlist.Convert.ReturnType;

public class Convert {
	//时间复杂度为O（N），空间复杂度为O（N）
	public static TreeNode convert1(TreeNode head) {
		if(head == null) {
			return head;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		inOrderToQueue(head, queue);
		head = queue.poll();
		TreeNode pre = head;
		head.left = null;
		TreeNode cur = null;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			cur.left = pre;
			pre.right = cur;
			pre = cur;
		}
		cur.right = null;
		return head;		
	}
	public static void inOrderToQueue(TreeNode root , Queue<TreeNode> queue){
		if(root == null) {
			return;
		}
		inOrderToQueue(root.left , queue);
		queue.offer(root);
		inOrderToQueue(root.right, queue);
	}
	//使用递归，时间复杂度为O（N），空间复杂度为O（h），h是二叉树高度
	public static class ReturnType{
		public TreeNode start;
		public TreeNode end;
		public ReturnType (TreeNode start, TreeNode end) {
			this.start = start;
			this.end = end;
		}
	}
	public static TreeNode convert2(TreeNode head) {
		if(head == null) {
			return null;
		}
		return process(head).start;
	}
	public static ReturnType process(TreeNode head) {
		if(head == null) {
			return new ReturnType(null, null);
		}
		ReturnType leftList = process(head.left);
		ReturnType rightList = process(head.right);
		if(leftList.end != null) {
			leftList.end.right = head;
		}
		head.left = leftList.end;
		head.right = rightList.start;
		if(rightList.start != null) {
			rightList.start.left = head;
		}
		return new ReturnType(leftList.start != null ? leftList.start : head , rightList.end != null ? rightList.end : head);
	}
	
	public static TreeNode treeGenerator(int count, String[][] numbers) {
	        HashMap<Integer, TreeNode> map = new HashMap<>();
	        map.put(0, null);
	        String[] number;
	        int value;
	        for (int i = 0; i < count; i++) {
	            number = numbers[i];
	            value = Integer.parseInt(number[0]);
	            if (value != 0) {
	                map.put(value, new TreeNode(value));
	            }
	        }
	        TreeNode cur;
	        for (int i = 0; i < count; i++) {
	            number = numbers[i];
	            value = Integer.parseInt(number[0]);
	            cur = map.get(value);
	            cur.left = map.get(Integer.parseInt(number[1]));
	            cur.right = map.get(Integer.parseInt(number[2]));
	        }
	        return map.get(Integer.parseInt(numbers[0][0]));
	 }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String[][] numbers = new String[n][3];
		for(int i = 0 ; i < n ; i++) {
			numbers[i] = in.nextLine().split(" ");
		}
		TreeNode root = treeGenerator(n, numbers);
		TreeNode head = convert1(root);
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.right;
		}
	}
	
	
}
