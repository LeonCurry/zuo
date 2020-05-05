package book_chapter3_tree;

import java.util.HashMap;
import java.util.Scanner;

public class PrintEdge {
	//标准1
	public static void  printEdge1(TreeNode head) {
		if(head == null) {
			return;
		}
		int height = getHeight(head , 0);
		TreeNode[][] edgeMap = new TreeNode[height][2];
		setEdgeMap(head, 0 , edgeMap);
		//打印左边界
		for(int i = 0 ; i < edgeMap.length ; i++) {
			System.out.print(edgeMap[i][0].value + " ");
		}
		printLeafNotInMap(head, 0 , edgeMap);
		for(int i = edgeMap.length - 1 ; i > -1 ; i--) {
			if(edgeMap[i][0] != edgeMap[i][1]) {
				System.out.print(edgeMap[i][1].value + " ");	
			}
		}
		System.out.println();
	}
	public static int getHeight(TreeNode head, int l) {
		if(head == null) {
			return l;
		}
		return Math.max(getHeight(head.left, l+1), getHeight(head.right, l+1));
	}
	public static void setEdgeMap(TreeNode head, int l, TreeNode[][] edgeMap) {
		if(head == null) {
			return;
		}
		edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
		edgeMap[l][1]	 = head;
		setEdgeMap(head.left, l+1, edgeMap);
		setEdgeMap(head.right, l+1, edgeMap);
	}
	public static void printLeafNotInMap(TreeNode head, int l, TreeNode[][] edgeMap) {
		if(head == null) {
			return ;
		}
		if(head.left == null && head.right ==null && head !=edgeMap[l][0] && head != edgeMap[l][1]) {
			System.out.print(head.value + " ");
		}
		printLeafNotInMap(head.left, l+1, edgeMap);
		printLeafNotInMap(head.right, l+1, edgeMap);
	}
	//标准二
	public static void printEdge2(TreeNode head) {
		if(head == null) {
			return;
		}
		System.out.print(head.value + " ");
		if(head.left != null && head.right != null) {
			printLeftEdge(head.left , true);
			printRightEdge(head.right , true);
		}else {
			printEdge2( head.left != null ? head.left : head.right);
		}
		System.out.println();
	}
	public static void printLeftEdge(TreeNode head, boolean print) {
		if(head == null) {
			return;
		}
		if(print || (head.left == null && head.right == null)) {
			System.out.print(head.value + " ");
		}
		printLeftEdge(head.left, print);
		printLeftEdge(head.right, print && (head.left == null ? true : false));		
	}
	public static void printRightEdge(TreeNode head , boolean print) {
		if(head == null) {
			return;
		}
		printRightEdge(head.left, print && (head.right == null ? true : false));
		printRightEdge(head.right, print);
		if(print || (head.left == null && head.right == null)) {
			System.out.print(head.value + " ");
		}
		
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
		String[] row = in.nextLine().split(" ");
		int n = Integer.valueOf(row[0]);
		String[][] numbers = new String[n][3];
		for(int i = 0 ; i < n ; i++) {
			numbers[i] = in.nextLine().split(" ");
		}
		TreeNode root = treeGenerator(n, numbers);
		printEdge1(root);
		printEdge2(root);
	}
}
