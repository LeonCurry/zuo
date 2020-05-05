package class3;

import java.util.Stack;

public class GetMinStack {
	Stack<Integer> dataStack;
	Stack<Integer> minStack;
	public GetMinStack(){
		this.dataStack=new Stack<Integer>();
		this.minStack=new Stack<Integer>();
	}
	public void push(int obj) {
		if(this.minStack.isEmpty()) {
			this.minStack.push(obj);
		}else if(obj<=this.getMin()) {
			this.minStack.push(obj);
		}else {
			this.minStack.peek();
		}
		this.dataStack.push(obj);
	}
	public int pop() {
		if(this.dataStack.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value=this.dataStack.pop();
		this.minStack.pop();
		return value;
	}
	public int getMin() {
		if(this.minStack.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.minStack.peek();
	}
}
