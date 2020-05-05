package book_stackandqueue;

import java.util.Stack;

public class TwoStacksQueue {
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	public TwoStacksQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	public void add(int num) {
		stackPush.push(num);
	}
	public int poll() {
		if(stackPop.isEmpty()) {
			throw new RuntimeException("Your queue is Empty!");
		}
		if(!stackPop.isEmpty()) {
			return stackPop.pop();
		}else {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
			return stackPop.pop();
		}
	}
	public int peek() {
		if(stackPop.isEmpty()) {
			throw new RuntimeException("Your queue is Empty!");
		}
		if(!stackPop.isEmpty()) {
			return stackPop.peek();
		}else {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
			return stackPop.peek();
		}
	}
}
