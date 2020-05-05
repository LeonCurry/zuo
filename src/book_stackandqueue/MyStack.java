package book_stackandqueue;

import java.util.Stack;

/*
 * 时间复杂度为O(1). 空间复杂度为O(N)
 */
public class MyStack {
	public Stack<Integer> stackData;
	public Stack<Integer> stackMin;
	public MyStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	public void push(int num) {
		this.stackData.push(num);
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(num);
		}else if(num <= this.stackMin.peek()) {
			this.stackMin.push(num);
		}else {
			this.stackMin.push(this.stackMin.peek());
		}
	}
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empth!");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	public int getMin() {
		if(stackMin.isEmpty()) {
			throw new RuntimeException("Your stackMin is empty!");
		}
		return this.stackMin.peek();
	}
	
}
