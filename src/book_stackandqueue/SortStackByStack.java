package book_stackandqueue;

import java.util.Stack;
/*
 * 最好的时间复杂度为O（N），最差的是O（N^2）
 */
public class SortStackByStack {
	public static Stack<Integer> sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int cur = stack.pop();	
			//判断是否为空必须在前面
			while(!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}			
			help.push(cur);
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());
		}
		return stack;
	}
}

