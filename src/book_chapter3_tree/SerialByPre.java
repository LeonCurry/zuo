package book_chapter3_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import book_chapter2_linkedlist.Node;

public class SerialByPre {
	//œ»–Ú±È¿˙
	public static String serialByPre(TreeNode head) {
		if(head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	public static TreeNode reconByPreString(String preStr) {
		if(preStr.equals("")) {
			return null;
		}
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0 ; i < values.length ; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}
	public static TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if(value.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
	//≤„–Ú±È¿˙
	public static String serialByLevel(TreeNode head) {
		if(head == null) {
			return "#!";
		}
		String res = head.value + "!";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			if(head.left != null) {
				res +=head.left.value + "!";
				queue.offer(head.left);
			}else {
				res += "#!";
			}
			if(head.right != null) {
				res += head.right.value + "!";
				queue.offer(head.right);
			}else {
				res += "#!";
			}
		}
		return res;
	}
	public static TreeNode reconByLevelString(String levelString) {
		String[] values = levelString.split(" ");
		int index = 0;
		TreeNode head = generateNodeByString(values[index++]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(head);
		TreeNode node = null;
		while(!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(values[index++]);
			node.right = generateNodeByString(values[index++]);
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			
		}
		return head;
	}
	public static TreeNode generateNodeByString(String val) {
		if(val.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
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
		String preStr = serialByPre(root);
		String levelStr = serialByLevel(root);
		System.out.println(preStr.toString());
		System.out.println(levelStr.toString());
	}
}
