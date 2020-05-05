package class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
	public static class Node{
		public int c;
		public int p;
		public Node(int c, int p) {
			this.c = c;
			this.p = p;
		}
	}
	
	public static class MinCostComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}
		
	}
	
	public static class MaxProfitComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p-o1.p;
		}
		
	}
	
	public static int findMaximizedCapital (int k, int M, int[] Profit, int[] Capital) {
		Node[] nodes = new Node[Profit.length];
		for(int i = 0; i < Profit.length; i++) {
			nodes[i] = new Node(Capital[i], Profit[i]);
		}
		
		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator()	);
		
		for(int i = 0; i < nodes.length ; i++) {
			minCostQ.add(nodes[i]);
		}
		for(int i = 0; i < k ; i++) {
			while(!minCostQ.isEmpty() && minCostQ.peek().c <= M) {
				maxProfitQ.add(minCostQ.poll());
			}
			if(maxProfitQ.isEmpty()) {
				return M;
			}
			M +=maxProfitQ.poll().p;
		}
		return M;
	}
}
