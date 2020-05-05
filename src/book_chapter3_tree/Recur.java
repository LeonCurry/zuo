package book_chapter3_tree;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Recur {
	//递归
	public static void preOrderRecur(TreeNode root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.value+ " ");
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	public static void inOrderRecur(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrderRecur(root.left);
		System.out.print(root.value + " ");
		inOrderRecur(root.right);
	}
	public static void posOrderRecur(TreeNode root) {
		if(root == null) {
			return;
		}
		posOrderRecur(root.left);
		posOrderRecur(root.right);
		System.out.print(root.value + " ");
	}
	//非递归
	public static void preOrderRecur1(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.value + " ");
			if(root.right != null) {
				stack.push(root.right);
			}
			if(root.left != null) {
				stack.push(root.left);
			}
		}
		System.out.println();
	}
	@SuppressWarnings("unused")
	public static void inOrderRecur1(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while(!stack.isEmpty() && root != null) {
				if(root != null) {
					stack.push(root);
					root = root.left;
				}else {
					root = stack.pop();
					System.out.println(root.value + " ");
					root = root.right;
				}
			}
		}
		System.out.println();
	}
	//用两个栈
	public static void posOrderRecur1(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(root);
			while(!s1.isEmpty()) {
				root = s1.pop();
				s2.push(root);
				if(root.left != null) {
					s1.push(root.left);
				}
				if(root.right != null) {
					s1.push(root.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.println(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	public static void posOrderRecur2(TreeNode root) {
		if(root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			TreeNode c = null;
			while(!stack.isEmpty()) {
				c = stack.peek();
				if(c.left!= null && root != c.left && root != c.right) {
					stack.push(c.left);
				}else if(c.right != null && root != c.right) {
					stack.push(c.right);
				}else {
					System.out.println(stack.pop().value);
					root = c;
				}
			}
		}
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
		preOrderRecur(root);
		System.out.println();
		inOrderRecur(root);
		System.out.println();
		posOrderRecur(root);
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
}
