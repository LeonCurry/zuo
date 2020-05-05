package book_stackandqueue;

import java.util.Stack;

public class GetAndRemoveLastElement {
	//��ջstack��ջ��Ԫ�ط��ز�ɾ���������result�������м����last��
	//��׵�last���أ�last�ڵݹ�Ĺ����в�������resultֵ�ı仯���仯
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
	//����һ��ջ�����õݹ�
	public void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
