package class_07;

import java.util.PriorityQueue;

public class LessMoney {

		public int lessMoney(int[] arr) {
			//没有使用比较器的优先队列，默认的是小根堆
			PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
			for(int i = 0 ; i < arr.length ; i++) {
				pQ.add(arr[i]);
			}
			int sum = 0;
			int cur = 0;
			while(pQ.size()>1) {
				cur = pQ.poll() + pQ.poll();
				sum += cur;
				pQ.add(cur);
			}
			return sum;
		}
}
