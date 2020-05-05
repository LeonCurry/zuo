package book_stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class MaxRecSize {
	public static int maxRecSize(int[][] map) {
		if(map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0 ; j < map[0].length ; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j]+1;
			}
			maxArea = Math.max(maxArea, maxRecFromBottom(height));
		}
		return maxArea;
	}
	public static int maxRecFromBottom(int[] arr) {
		if(arr == null || arr.length ==0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i-k-1)*arr[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (arr.length - k - 1) * arr[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;		
	}
	/*
	 * 输入
	 * 3 4 （行数列数）
	 * 1 1 1 0
	 * 1 1 1 1
	 * 1 1 1 0
	 * 输出：6
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] data1 = in.nextLine().split(" ");
		int rows = Integer.valueOf(data1[0]);
		int cols = Integer.valueOf(data1[1]);
		int[][] arr = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			String[] data2 = in.nextLine().split(" ");
			for(int j = 0; j < cols ; j++) {
				arr[i][j] = Integer.valueOf(data2[j]);
			}
		}
		int res = maxRecSize(arr);
		System.out.println(res);
		
	}
}
