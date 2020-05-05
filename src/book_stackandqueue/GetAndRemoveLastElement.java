package book_stackandqueue;

import java.util.Stack;

public class GetAndRemoveLastElement {
	//将栈stack的栈底元素返回并删除。变得是result，借助中间变量last将
	//最底的last返回，last在递归的过程中不会随着result值的变化而变化
	public int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		}else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	//逆序一个栈，仅用递归
	public void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
