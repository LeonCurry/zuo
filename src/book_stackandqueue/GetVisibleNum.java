package book_stackandqueue;

import java.util.Scanner;
import java.util.Stack;

class Record {
	public int value;
	public int time;
	public Record(int value) {
		this.value = value;
		this.time = 1;
	}
}
public class GetVisibleNum {
	public static int getVisibleNum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		//找最大值位置
		int maxIndex = 0;
		int size = arr.length;
		for(int i = 0 ; i < size ; i++) {
			maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
		}
		//将最大值位置放入栈中
		Stack<Record> stack = new Stack<Record>();
		stack.push(new  Record(arr[maxIndex]));
		//从最大值位置的下一个位置开始沿着next方向遍历
		int index = nextIndex(maxIndex, size);
		//用“小找大” 的方式统计所有可见山峰对
		int res = 0;
		//遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段结束
		while(index != maxIndex) {
			//当前数字arr[index]要进栈，判断会不会破坏第一维的数字丛顶到底依次变大
			//如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
			while(stack.peek().value < arr[index]) {
				int k = stack.pop().time;
				//弹出记录为（X,K），如果K==1，产生2对
				//如果K>1,产生2*K+C（2，K）
				res += getInternalSum(k) + 2 * k;
			}
			//将新数据加入栈，如果和栈顶一样就合并，如果不一样就要把新的放入栈中
			if(stack.peek().value == arr[index]) {
				stack.peek().time++;
			}else {
				stack.push(new Record(arr[index]));
			}
			index =  nextIndex(index, size);		
		}
		//清算阶段第一阶段
		while(stack.size()>2) {
			int  time = stack.pop().time;
			res += getInternalSum(time) + 2*time;
		}
		//第二阶段，如果底层M==1，则输出1*time，否则为2*time
		if(stack.size() == 2) {
			int time = stack.pop().time;
			res += getInternalSum(time) +((stack.peek().time ==1) ? time : (2 * time));
		}
		//第三阶段
		res += getInternalSum(stack.pop().time);
		return res;
	}
	
	//环形数组中当前位置为i，如果超过size-1时，就回到数组的0位置开始递增，直到maxIndex
	public static int nextIndex(int i, int size) {
		return i < (size -1) ? (i+1):0;
	}
	//如果k==1,返回0，k>1,返回C(2,K)
	public static int getInternalSum(int k) {
		return k==1 ? 0 : (k*(k - 1) / 2);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		int result = getVisibleNum(arr);
		System.out.println(result);
	}
}
