package book_stackandqueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GetNearLessNoRepeat {
	//方法一：没有重复数字，时间复杂度为O(N);
	public static int[][] getNearLessNoRepeat(int[] arr){
		if(arr == null || arr.length <= 0) {
			return null;
		}
		int[][] res = new int[arr.length][2];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int popIndex = stack.pop();
				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
				res[popIndex][0] = leftLessIndex;
				res[popIndex][1] = i;
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int popIndex = stack.pop();
			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
			res[popIndex][0] = leftLessIndex;
			res[popIndex][1] = -1;
		}
		return res;
	}
	//方法二：时间复杂度为O(N^2)，找到i位置上的数左右各遍历；
	
	//进阶问题：有重复数值的，时间复杂度为O(N)
	public static int[][] getNearLess(int[] arr) {
		int[][] res = new int[arr.length][2];
		Stack<ArrayList<Integer>> stack = new Stack<>();
		for(int i = 0 ; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				ArrayList<Integer> popList = stack.pop();
				int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
				for(Integer popInteger : popList) {
					res[popInteger][0] = leftIndex;
					res[popInteger][1] = i;
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
				stack.peek().add(Integer.valueOf(i));
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				stack.push(list);
			}
		}
		while(!stack.isEmpty()) {
			ArrayList<Integer> popList = stack.pop();
			int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
			for(Integer popInteger : popList) {
				res[popInteger][0] = leftIndex;
				res[popInteger][1] = -1;
			}
		}
		return res;
	}
	/*
	 * 输入：
	 * 7
	 * 3 4 1 5 6 2 7
	 * 输出：
	 * -1 2
	 * 0 2
	 * -1 -1
	 * 2 5 
	 * 3 5
	 * 2 -1
	 * 5 -1
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		int len = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[len];
		for(int i = 0 ; i < len ; i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		//int[][] res = getNearLessNoRepeat(arr);
		int[][] res = getNearLess(arr);
		for(int i = 0 ; i < res.length ; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0 ; j < res[0].length ; j++) {
				sb.append(res[i][j]).append(" ");
				
			}
			System.out.println(sb.substring(0 , sb.length() - 1));
		}
	}
}
