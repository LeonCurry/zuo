package book_stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class GetMaxWindow {
	//时间复杂度为O(N*W)
	public static int[] getMaxWindow1(int[] arr, int len, int w) {
		if(w > len || w <= 0 || arr == null) {
			return null;
		}
		int[] res = new int[len-w+1];		
		for(int i = 0 ; i < len-w+1; i++) {
			ArrayList <Integer> list = new ArrayList<Integer>();
			for(int j = i ; j<i+w;j++) {
				if(!list.isEmpty() && list.get(0) <= arr[j]) {
					list.add(0, arr[j]);
				}
				list.add(arr[j]);
			}
			res[i] = list.get(0);
		}
		return res;
	}
	//时间复杂度为O(N)
	public static int[] getMaxWindow2(int[] arr, int w) {
		if(arr == null|| w<1 || arr.length < w) {
			return null;
		}
		int[] res = new int[arr.length -w +1];
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			//从第w-1个位置开始算起，意思是从第w-1个位置是第一个滑动窗口的位置
			if(i >= w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		//输入
		/*
		 * 8 3
		 * 4 3 5 4 3 3 6 7
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] row1 = in.readLine().split(" ");
		int len = Integer.parseInt(row1[0]);
		int w = Integer.parseInt(row1[1]);
		String[] row2 = in.readLine().split(" ");
		int[] arr = new int[len];
		for(int i=0;i<len;i++) {
			arr[i] = Integer.parseInt(row2[i]);
		}
		//调用函数
		int[] result = getMaxWindow2(arr,  w);
		//输出
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i<result.length;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
}
