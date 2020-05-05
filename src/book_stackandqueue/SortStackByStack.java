package book_stackandqueue;

import java.util.Stack;
/*
 * ��õ�ʱ�临�Ӷ�ΪO��N����������O��N^2��
 */
public class SortStackByStack {
	public static Stack<Integer> sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int cur = stack.pop();	
			//�ж��Ƿ�Ϊ�ձ�����ǰ��
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

