package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
	public static class TwoStacksQueue{
		Stack<Integer> stackPush;
		Stack<Integer> stackPop;
		public TwoStacksQueue() {
			stackPush=new Stack<Integer>();
			stackPop=new Stack<Integer>();
		}
		public void push(int obj) {
			stackPush.push(obj);
		}
		public int pop() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}else if(stackPop.isEmpty()) {
				while(!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}			
			return stackPop.pop();
		}
		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}else if(stackPop.isEmpty()) {
				while(!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}		
			return stackPop.peek();
		}
	}
	public static class TwoQueueStack{
		Queue<Integer> queue;
		Queue<Integer> help;
		public TwoQueueStack() {
			queue=new LinkedList<Integer>();
			help=new LinkedList<Integer>();
		}
		public void push(int obj) {
			queue.add(obj);
		}
		public int pop() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while(queue.size()>1) {
				help.add(queue.poll());
			}
			int res=queue.poll();
			swap();
			return res;
		}
		public int peek() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while(queue.size()>1) {
				help.add(queue.poll());
			}
			int res=queue.poll();
			help.add(res);
			swap();
			return res;
		}
		public void swap() {
			Queue<Integer> temp=queue;
			queue=help;
			help=temp;
		}
	}
}
